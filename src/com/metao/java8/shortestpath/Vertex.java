package com.metao.java8.shortestpath;

/**
 * A class for vertices in graphs.  Every vertex has a name and an
 * index in its graph.
 **/

public class Vertex {
    /**
     * Value that indicates that this vertex does not yet have an
     * index, i.e., the index is unknown.
     */
    public static final int UNKNOWN_INDEX = -1;

    /**
     * Index of this vertex in its graph, 0 to cardV-1.
     */
    private int index;

    /**
     * This vertex's name.
     */
    private String name;

    /**
     * Creates a vertex whose index is unknown.
     *
     * @param name This vertex's name.
     */
    public Vertex(String name) {
        index = UNKNOWN_INDEX;
        this.name = name;
    }

    /**
     * Creates a vertex with a given index and name.
     *
     * @param index This vertex's index.
     * @param name  This vertex's name.
     */
    public Vertex(int index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * Sets this vertex's index.
     *
     * @param index New value for this vertex's index.
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Returns this vertex's index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets this vertex's name.
     *
     * @param name New value for this vertex's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns this vertex's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the <code>String</code> representation of this
     * vertex.
     */
    public String toString() {
        return name + " (index = " + index + ")";
    }
}
