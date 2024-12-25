package com.metao.examples.designpatterns.flyweight;

import com.metao.examples.designpatterns.flyweight.Tree;
import com.metao.examples.designpatterns.flyweight.TreeFactory;
import com.metao.examples.designpatterns.flyweight.TreeType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Forest extends JFrame {
    private List<com.metao.examples.designpatterns.flyweight.Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
        com.metao.examples.designpatterns.flyweight.Tree tree = new com.metao.examples.designpatterns.flyweight.Tree(x, y, type);
        trees.add(tree);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Tree tree : trees) {
            tree.draw(graphics);
        }
    }
}