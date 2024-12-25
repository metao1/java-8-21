package com.metao.examples.designpatterns.composite;

import java.awt.*;

public interface Shape {
    int getX();

    int getY();

    int getHeight();

    int getWidth();

    void move(int x, int y);

    boolean isInsideBound(int x, int y);

    boolean isSelected();

    void select();

    void unSelect();

    void paint(Graphics graphics);
}
