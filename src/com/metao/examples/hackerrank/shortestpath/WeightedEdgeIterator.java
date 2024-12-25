package com.metao.examples.hackerrank.shortestpath;

import java.util.Iterator;

/**
 * Interface for an iterator that returns weighted edges.
 */

public interface WeightedEdgeIterator extends Iterator<Vertex> {
    /**
     * Returns the weight of the edge returned by the most recent
     * call to <code>next</code>.
     */
    public double getWeight();

    /**
     * Sets the weight of the edge returned by the most recent call to
     * <code>next</code>.
     *
     * @param weight The new weight for the edge.
     */
    public void setWeight(double weight);
}