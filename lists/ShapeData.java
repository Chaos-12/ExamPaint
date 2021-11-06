package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import src.interfaces.*;
import src.shapes.*;

public class ShapeData {

    private static List<String> figString;
    private static List<IBiFunction<Shape, Point>> builderFromPoint;
    private static List<UnaryOperator<Shape>> builderFromShape;

    public static void createLists() {
        figString = new ArrayList<String>();
        builderFromPoint = new ArrayList<IBiFunction<Shape, Point>>();
        builderFromShape = new ArrayList<UnaryOperator<Shape>>();
        figString.add("Heart");
        builderFromPoint.add((p, q) -> new Heart(p, q));
        builderFromShape.add((fig) -> new Heart(fig));
        figString.add("Bolt");
        builderFromPoint.add((p, q) -> new Bolt(p, q));
        builderFromShape.add((fig) -> new Bolt(fig));
        figString.add("Star");
        builderFromPoint.add((p, q) -> new Star(p, q));
        builderFromShape.add((fig) -> new Star(fig));
        figString.add("Oval");
        builderFromPoint.add((p, q) -> new Oval(p, q));
        builderFromShape.add((fig) -> new Oval(fig));
        figString.add("Rectangle");
        builderFromPoint.add((p, q) -> new Rectangle(p, q));
        builderFromShape.add((fig) -> new Rectangle(fig));
        figString.add("Hexagon");
        builderFromPoint.add((p, q) -> new Hexagon(p, q));
        builderFromShape.add((fig) -> new Hexagon(fig));
    }

    public static List<String> getShapeString() {
        return figString;
    }

    public static List<IBiFunction<Shape, Point>> getBuilderPoint() {
        return builderFromPoint;
    }

    public static List<UnaryOperator<Shape>> getBuildShape() {
        return builderFromShape;
    }

    public static String getShapeInfo() {
        String output = "List of Shapes: ";
        for (int i = 0; i < figString.size(); i++) {
            output = output + figString.get(i) + ", ";
        }
        return output;
    }
}