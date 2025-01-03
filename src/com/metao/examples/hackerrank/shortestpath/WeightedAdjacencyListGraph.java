package com.metao.examples.hackerrank.shortestpath;

import java.util.Iterator;

/**
 * Implementation of a weighted graph, using adjacency lists.
 * <p>
 * The representation and use are similar to the superclass {@link
 * AdjacencyListGraph}.  The primary difference is that the inner
 * class {@link AdjacencyListGraph.Edge} is subclassed here as {@link
 * WeightedAdjacencyListGraph.WeightedEdge}, and objects of this
 * subclass include a weight.  The inner {@link
 * WeightedAdjacencyListGraph.EdgeIterator} class overrides the {@link
 * AdjacencyListGraph.EdgeIterator} class and implements the {@link
 * WeightedEdgeIterator} interface, so that edge weights can be get
 * and set during iterations through edges.
 */

public class WeightedAdjacencyListGraph extends AdjacencyListGraph {
	/**
	 * Creates an empty <code>WeightedAdjacencyListGraph</code>.
	 *
	 * @param cardV    How many vertices this graph will have.
	 * @param directed Flag indicating whether this graph is directed.
	 */
	public WeightedAdjacencyListGraph(int cardV, boolean directed) {
		super(cardV, directed);
	}

	/**
	 * Unsupported, since edges in a weighted graph must have weights.
	 *
	 * @throws UnsupportedOperationException always.
	 */
	public void addEdge(Vertex u, Vertex v) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Unsupported, since edges in a weighted graph must have weights.
	 *
	 * @throws UnsupportedOperationException always.
	 */
	public void addEdge(int u, int v) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Adds a weighted edge to this graph.  The edge is specified by a
	 * pair of <code>Vertex</code> objects.
	 *
	 * @param u      One vertex.
	 * @param v      The other vertex.
	 * @param weight The weight of the edge.
	 */
	public void addEdge(Vertex u, Vertex v, double weight) {
		// Put v on u's list.
		int uIndex = u.getIndex();
		Edge x = new WeightedEdge(v, adj[uIndex].head, weight);
		adj[uIndex].head = x;

		// If undirected, put u on v's list.
		if (!directed) {
			int vIndex = v.getIndex();
			x = new WeightedEdge(u, adj[vIndex].head, weight);
			adj[vIndex].head = x;
		}

		e++;
	}

	/**
	 * Adds a weighted edge to this graph.  The edge is specified by a
	 * pair of vertex indices.
	 *
	 * @param u      The index of one vertex.
	 * @param v      The index of the other vertex.
	 * @param weight The weight of the edge.
	 */
	public void addEdge(int u, int v, double weight) {
		// Put v on u's list.
		Edge x = new WeightedEdge(adj[v].thisVertex, adj[u].head, weight);
		adj[u].head = x;

		// If undirected, put u on v's list.
		if (!directed) {
			x = new WeightedEdge(adj[u].thisVertex, adj[v].head, weight);
			adj[v].head = x;
		}

		e++;
	}

	/**
	 * Inner class for weighted edges in adjacency lists.  Adjacency
	 * lists are singly linked.
	 */
	protected static class WeightedEdge extends Edge {
		/**
		 * The weight of this edge.
		 */
		private double weight;

		/**
		 * Creates a new edge.
		 *
		 * @param v         The adjacent vertex.
		 * @param successor Successor edge to this one.
		 * @param wgt       The weight of the new edge.
		 */
		public WeightedEdge(Vertex v, Edge successor, double wgt) {
			super(v, successor);
			weight = wgt;
		}

		/**
		 * Sets the weight of this edge.
		 *
		 * @param wgt The new weight for this edge.
		 */
		public void setWeight(double wgt) {
			weight = wgt;
		}

		/**
		 * Returns the weight of this edge.
		 */
		public double getWeight() {
			return weight;
		}
	}

	/**
	 * Returns an iterator that iterates through the weighted edges
	 * incident on a given vertex.  Each incident edge is indicated by
	 * the corresponding adjacent vertex.
	 *
	 * @param u The vertex whose incident edges are returned by the
	 *          iterator.
	 */
	public Iterator<Vertex> edgeIterator(Vertex u) {
		return new EdgeIterator(u.getIndex());
	}

	/**
	 * Returns an iterator that iterates through the weighted edges
	 * incident on a given vertex.  Each incident edge is indicated by
	 * the corresponding adjacent vertex.
	 *
	 * @param u The index of the vertex whose incident edges are
	 *          returned by the iterator.
	 */
	public Iterator<Vertex> edgeIterator(int u) {
		return new EdgeIterator(u);
	}

	/**
	 * Returns an iterator, of type <code>WeightedEdgeIterator</code>
	 * (so that the caller does not need to cast the result), that
	 * iterates through the weighted edges incident on a given vertex.
	 * Each incident edge is indicated by the corresponding adjacent
	 * vertex.
	 *
	 * @param u The vertex whose incident edges are returned by the
	 *          iterator.
	 */
	public WeightedEdgeIterator weightedEdgeIterator(Vertex u) {
		return weightedEdgeIterator(u.getIndex());
	}

	/**
	 * Returns an iterator, of type <code>WeightedEdgeIterator</code>
	 * (so that the caller does not need to cast the result), that
	 * iterates through the weighted edges incident on a given vertex.
	 * Each incident edge is indicated by the corresponding adjacent
	 * vertex.
	 *
	 * @param u The index of the vertex whose incident edges are
	 *          returned by the iterator.
	 */
	public WeightedEdgeIterator weightedEdgeIterator(int u) {
		return new EdgeIterator(u);
	}

	/**
	 * Inner class that overrides
	 * <code>AdjacencyListGraph.EdgeIterator</code> to implement
	 * <code>WeightedEdgeIterator</code>.
	 */
	public class EdgeIterator extends AdjacencyListGraph.EdgeIterator
			implements WeightedEdgeIterator {
		/**
		 * Starts an iteration through the weighted edges incident on
		 * a given vertex.
		 *
		 * @param v The index of the vertex.
		 */
		public EdgeIterator(int v) {
			super(v);
		}

		/**
		 * Returns the weight of the edge returned by the most recent
		 * call to <code>next</code>.
		 */
		public double getWeight() {
			return ((WeightedEdge) current).getWeight();
		}

		/**
		 * Sets the weight of the edge returned by the most recent
		 * call to <code>next</code>.
		 *
		 * @param weight The new weight for the edge.
		 */
		public void setWeight(double weight) {
			((WeightedEdge) current).setWeight(weight);
		}
	}

	/**
	 * Creates and returns an empty
	 * <code>WeightedAdjacencyListGraph</code> with no edges, given
	 * the number of vertices and a boolean indicating whether the
	 * graph is directed.
	 *
	 * @param cardV    How many vertices in the new graph.
	 * @param directed Flag indicating whether this graph is directed.
	 */
	protected AdjacencyListGraph makeEmptyGraph(int cardV, boolean directed) {
		return new WeightedAdjacencyListGraph(cardV, directed);
	}

	/**
	 * Returns the <code>String</code> representation of this
	 * weighted graph.
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();

		Iterator<Vertex> vertexIter = vertexIterator();
		while (vertexIter.hasNext()) {
			Vertex u = vertexIter.next();
			result.append(u).append(":\n");

			WeightedEdgeIterator edgeIter = weightedEdgeIterator(u);
			while (edgeIter.hasNext()) {
				Vertex v = (Vertex) edgeIter.next();
				double w = edgeIter.getWeight();
				result.append("    ").append(v).append(", weight = ").append(w).append("\n");
			}
		}

		return result.toString();
	}
}
