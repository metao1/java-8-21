package com.metao.java8.shortestpath;

import java.util.TreeSet;

/**
 * Implementation of Dijkstra's algorithm on page 595 of
 * <i>Introduction to Algorithms</i>, Second edition.
 */
public class Dijkstra extends SingleSourceShortestPaths {
	/**
	 * Sets up the instance variables, including allocation of the
	 * <code>spInfo</code> array but <em>not</em> allocation of the
	 * <code>ShortestPathInfo</code> objects referenced by the array.
	 * (That's {@link #initializeSingleSource}'s job.)
	 *
	 * @param theGraph The graph for which we are computing
	 *                 single-source shortest paths.
	 */
	public Dijkstra(WeightedAdjacencyListGraph theGraph) {
		super(theGraph);
	}

	/**
	 * Computes single-source shortest paths from a given source
	 * vertex, filling in weights and predecessors in the
	 * <code>spInfo</code> array.
	 *
	 * @param s The source vertex.
	 */
	public void computeShortestPaths(Vertex s) {
		initializeSingleSource(s);

		// Create a min-priority queue.
		TreeSet<DijkstraInfo> q = new TreeSet<>();

		// The information we're keeping for each vertex is a
		// DijkstraInfo object.  We need to set the theVertex and
		// handle fields.  By inserting each DijkstraInfo object into
		// the min-priority queue, we get the handle that we store in
		// the object.
		int cardV = g.getCardV();
		for (int i = 0; i < cardV; i++) {
			DijkstraInfo info = (DijkstraInfo) getShortestPathInfo(i);
			info.theVertex = g.getVertex(i);
			info.handle = q.add(info);
		}

		while (!q.isEmpty()) {
			// Find the vertex in the queue with the smallest key.
			DijkstraInfo uInfo = q.pollFirst();
			uInfo.handle = null; // no longer in the queue
			Vertex u = uInfo.theVertex;
			double du = getShortestPathInfo(u).getEstimate();

			// Check each incident edge.
			WeightedEdgeIterator edgeIter = g.weightedEdgeIterator(u);

			while (edgeIter.hasNext()) {
				Vertex v = edgeIter.next();
				DijkstraInfo vInfo = (DijkstraInfo) getShortestPathInfo(v);
				double weight = edgeIter.getWeight();
				if (vInfo.relax(u, du, weight)) {
					// v's shortest-path estimate has changed, so
					// update the min-priority queue.
					q.remove(vInfo);
				}
			}
		}
	}

	/**
	 * Returns a new <code>DijkstraInfo</code> object, overriding
	 * {@link SingleSourceShortestPaths#newShortestPathInfo}.
	 */
	// Override newShortestPathInfo.
	protected ShortestPathInfo newShortestPathInfo() {
		return new DijkstraInfo();
	}

	/**
	 * Inner class to maintain the <code>Vertex</code> object, key,
	 * parent, and handle into the priority queue for each vertex.
	 * The key (shortest-path estimate) and parent are inherited from
	 * the superclass {@link ShortestPathInfo}.
	 */
	private static class DijkstraInfo extends ShortestPathInfo implements Comparable<DijkstraInfo> {
		/**
		 * The vertex.
		 */
		public Vertex theVertex;

		/**
		 * A handle to the vertex's information in the priority
		 * queue, or <code>null</code> if the vertex is not in the
		 * priority queue.
		 */
		public Object handle;

		/**
		 * Creates a <code>DijkstraInfo</code> object.  The instance
		 * variables <code>theVertex</code> and <code>handle</code>
		 * fields will have to be set by the caller.
		 */
		public DijkstraInfo() {
			super();
		}

		/**
		 * Sets the key.
		 *
		 * @param key The new key value.
		 */
		public void setKey(Comparable key) {
			setEstimate((Double) key);
		}

		/**
		 * Returns the value of the key.
		 */
		public Comparable getKey() {
			return getEstimate();
		}

		/**
		 * Compares the key of this object's vertex to that of
		 * another.
		 *
		 * @param e The other <code>DijkstraInfo</code> object.
		 * @return A negative integer if the key of this object's
		 * vertex is less; 0 if the keys are equal; a positive integer
		 * if the key of this object's vertex is greater.
		 */
		@Override
		public int compareTo(DijkstraInfo e) {
			return Double.compare(e.theVertex.getIndex(), theVertex.getIndex());
		}
	}
}
