package com.metao.examples.designpatterns.flyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    static Map<String, com.metao.examples.designpatterns.flyweight.TreeType> treeTypes = new HashMap<>();

    public static com.metao.examples.designpatterns.flyweight.TreeType getTreeType(String name, Color color, String otherTreeData) {
        com.metao.examples.designpatterns.flyweight.TreeType result = treeTypes.get(name);
        if (result == null) {
            result = new TreeType(name, color, otherTreeData);
            treeTypes.put(name, result);
        }
        return result;
    }
}