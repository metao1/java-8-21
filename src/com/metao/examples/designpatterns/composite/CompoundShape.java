package com.metao.examples.designpatterns.composite;

import com.metao.examples.designpatterns.dp.composite.BaseShape;
import com.metao.examples.designpatterns.dp.composite.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundShape extends BaseShape {
    protected List<com.metao.examples.designpatterns.dp.composite.Shape> children = new ArrayList<>();

    public CompoundShape(com.metao.examples.designpatterns.dp.composite.Shape... components) {
        super(0, 0, Color.BLACK);
        add(components);
    }

    public void add(com.metao.examples.designpatterns.dp.composite.Shape component) {
        children.add(component);
    }

    public void add(com.metao.examples.designpatterns.dp.composite.Shape... components) {
        children.addAll(Arrays.asList(components));
    }

    public void remove(com.metao.examples.designpatterns.dp.composite.Shape child) {
        children.remove(child);
    }

    public void remove(com.metao.examples.designpatterns.dp.composite.Shape... components) {
        children.removeAll(Arrays.asList(components));
    }

    public void clear() {
        children.clear();
    }

    @Override
    public int getX() {
        if (children.isEmpty()) {
            return 0;
        }
        int x = children.get(0).getX();
        for (com.metao.examples.designpatterns.dp.composite.Shape child : children) {
            if (child.getX() < x) {
                x = child.getX();
            }
        }
        return x;
    }

    @Override
    public int getY() {
        if (children.size() == 0) {
            return 0;
        }
        int y = children.get(0).getY();
        for (com.metao.examples.designpatterns.dp.composite.Shape child : children) {
            if (child.getY() < y) {
                y = child.getY();
            }
        }
        return y;
    }

    @Override
    public int getWidth() {
        int maxWidth = 0;
        int x = getX();
        for (com.metao.examples.designpatterns.dp.composite.Shape child : children) {
            int childRelativeX = child.getX() - x;
            int childWidth = childRelativeX + child.getWidth();
            if (childWidth > maxWidth) {
                maxWidth = childWidth;
            }
        }
        return maxWidth;
    }

    @Override
    public int getHeight() {
        int maxHeight = 0;
        int y = getY();
        for (com.metao.examples.designpatterns.dp.composite.Shape child : children) {
            int childsRelativeY = child.getY() - y;
            int childHeight = childsRelativeY + child.getHeight();
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
        }
        return maxHeight;
    }

    @Override
    public void move(int x, int y) {
        for (com.metao.examples.designpatterns.dp.composite.Shape child : children) {
            child.move(x, y);
        }
    }

    @Override
    public boolean isInsideBound(int x, int y) {
        for (com.metao.examples.designpatterns.dp.composite.Shape child : children) {
            if (child.isInsideBound(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void unSelect() {
        super.unSelect();
        for (com.metao.examples.designpatterns.dp.composite.Shape child : children) {
            child.unSelect();
        }
    }

    public boolean selectChildAt(int x, int y) {
        for (com.metao.examples.designpatterns.dp.composite.Shape child : children) {
            if (child.isInsideBound(x, y)) {
                child.select();
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1);
            disableSelectionStyle(graphics);
        }

        for (Shape child : children) {
            child.paint(graphics);
        }
    }
}