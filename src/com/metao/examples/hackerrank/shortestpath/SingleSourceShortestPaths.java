package com.metao.examples.hackerrank.shortestpath;

/**
 * Abstract class for computing single-source shortest paths.
 * Defines methods for algorithms in Chapter 24 of <i>Introduction to
 * Algorithms</i>, Second edition.
 */
abstract public class SingleSourceShortestPaths {
    /**
     * The graph for which we are computing single-source shortest
     * paths.
     */
    protected WeightedAdjacencyListGraph g;

    /**
     * <code>true</code> if no negative-weight cycles were detected,
     * <code>false</code> if a negative-weight cycle was detected.
     */
    protected boolean noNegWeightCycle;

    /**
     * The result of running a single-source shortest-paths
     * algorithm.  Each object in this array corresponds to a vertex
     * of the graph, and you can query its answers by calling methods
     * of the {@link ShortestPathInfo} class.
     */
    private final ShortestPathInfo[] spInfo;

    /**
     * Sets up the instance variables, including allocation of the
     * <code>spInfo</code> array but <em>not</em> allocation of the
     * <code>ShortestPathInfo</code> objects referenced by the array.
     * (That's {@link #initializeSingleSource}'s job.)
     *
     * @param theGraph The graph for which we are computing
     *                 single-source shortest paths.
     */
    protected SingleSourceShortestPaths(WeightedAdjacencyListGraph theGraph) {
        g = theGraph;
        noNegWeightCycle = true; // haven't found one yet
        spInfo = new ShortestPathInfo[g.getCardV()];
    }

    /**
     * Computes single-source shortest paths from a given source
     * vertex, filling in weights and predecessors in the
     * <code>spInfo</code> array.
     *
     * @param s The source vertex.
     */
    abstract public void computeShortestPaths(Vertex s);

    /**
     * Initializes a single-source shortest-paths algorithm.
     *
     * @param s The source vertex.
     */
    public void initializeSingleSource(Vertex s) {
        for (int i = 0; i < spInfo.length; i++)
            spInfo[i] = newShortestPathInfo();

        getShortestPathInfo(s).setEstimate(0);
    }

    /**
     * Returns a new <code>ShortestPathInfo</code> object.  This
     * method may be overridden in subclasses.
     */
    protected ShortestPathInfo newShortestPathInfo() {
        return new ShortestPathInfo();
    }

    /**
     * After running <code>computeShortestPaths</code>, returns
     * <code>true</code> if no negative-weight cycles were detected,
     * <code>false</code> if a negative-weight cycle was detected.
     */
    public boolean hasNoNegativeWeightCycle() {
        return noNegWeightCycle;
    }

    /**
     * Returns a reference to the <code>ShortestPathInfo</code> object
     * for a given vertex.
     *
     * @param v The vertex for which the corresponding
     *          <code>ShortestPathInfo</code> is returned.
     */
    public ShortestPathInfo getShortestPathInfo(Vertex v) {
        return getShortestPathInfo(v.getIndex());
    }

    /**
     * Returns a reference to the <code>ShortestPathInfo</code> object
     * for a given vertex.
     *
     * @param v The index of the vertex for which the corresponding
     *          <code>ShortestPathInfo</code> is returned.
     */
    public ShortestPathInfo getShortestPathInfo(int v) {
        return spInfo[v];
    }
}
