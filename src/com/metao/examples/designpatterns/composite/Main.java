package com.metao.examples.designpatterns.composite;

import com.metao.examples.designpatterns.composite.Circle;
import com.metao.examples.designpatterns.composite.CompoundShape;
import com.metao.examples.designpatterns.composite.Dot;
import com.metao.examples.designpatterns.composite.ImageEditor;
import com.metao.examples.designpatterns.composite.Rectangle;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();

        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),
                new Circle(20, 20, 10, Color.RED),
                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new com.metao.examples.designpatterns.composite.Dot(160, 160, Color.RED)
                ),

                new CompoundShape(
                        new com.metao.examples.designpatterns.composite.Rectangle(250, 250, 100, 100, Color.GREEN),
                        new com.metao.examples.designpatterns.composite.Dot(240, 240, Color.GREEN),
                        new com.metao.examples.designpatterns.composite.Dot(240, 360, Color.GREEN),
                        new com.metao.examples.designpatterns.composite.Dot(360, 360, Color.GREEN),
                        new com.metao.examples.designpatterns.composite.Dot(360, 240, Color.GREEN)
                )
                ,
                new CompoundShape(
                        new Rectangle(110, 110, 100, 100, Color.GREEN),
                        new Circle(120, 120, 10, Color.GREEN),
                        new com.metao.examples.designpatterns.composite.Dot(120, 360, Color.GREEN),
                        new com.metao.examples.designpatterns.composite.Dot(120, 360, Color.GREEN),
                        new Dot(120, 240, Color.GREEN)
                )
        );
    }
}
