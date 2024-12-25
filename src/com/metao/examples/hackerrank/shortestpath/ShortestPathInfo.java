package com.metao.examples.hackerrank.shortestpath;

/**
 * Class for information determined about a vertex during a
 * shortest-path algorithm.
 */

public class ShortestPathInfo {
    /**
     * The current shortest-path estimate for this vertex.
     */
    private double d;

    /**
     * The current predecessor (parent) for this vertex.
     */
    private Vertex pi;

    /**
     * Initializes the shortest-path estimate to infinity and the
     * predecessor to <code>null</code>.
     */
    public ShortestPathInfo() {
        d = Double.POSITIVE_INFINITY;
        pi = null;
    }

    /**
     * Sets the shortest-path estimate.
     *
     * @param newEstimate The new shortest-path estimate.
     */
    public void setEstimate(double newEstimate) {
        d = newEstimate;
    }

    /**
     * Returns the shortest-path estimate.
     */
    public double getEstimate() {
        return d;
    }

    /**
     * Sets the predecessor.
     *
     * @param v The new predecessor.
     */
    public void setPredecessor(Vertex v) {
        pi = v;
    }

    /**
     * Returns the predecessor.
     */
    public Vertex getPredecessor() {
        return pi;
    }


    /**
     * Relaxes an edge entering this vertex, say <code>v</code>, based
     * on the Relax procedure on page 586 of <i>Introduction to
     * Algorithms</i>, Second edition.
     *
     * @param u  Vertex that the edge leaves.
     * @param du <code>u</code>'s shortest-path estimate.
     * @param w  The weight of the edge (u,v).
     * @return <code>true</code> if the shortest-path estimate for
     * <code>v</code> changes, <code>false</code> if the shortest-path
     * estimate remains unchanged.
     */
    public boolean relax(Vertex u, double du, double w) {
        double newWeight = du + w;
        if (newWeight < d) {
            d = newWeight;
            pi = u;
            return true;
        } else return false;
    }

    /**
     * Returns the <code>String</code> representation of this object.
     */
    public String toString() {
        String parentName;

        if (pi == null) parentName = "(null)";
        else parentName = pi.getName();

        return "d = " + d + ", pi = " + parentName;
    }
}