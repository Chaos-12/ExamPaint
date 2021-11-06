package src.app;

import java.util.ArrayList;
import java.util.List;

import src.interfaces.IBiFunction;
import src.interfaces.IBuilder;
import src.shapes.*;

public class ShapeBuilder implements IBuilder<IBiFunction<Shape, Point>> {

    private List<IBiFunction<Shape, Point>> builders;

    public ShapeBuilder() {
        builders = new ArrayList<IBiFunction<Shape, Point>>();
        builders.add(0, (p, q) -> new Circle(p, q));
        builders.add(1, (p, q) -> new Heart(p, q));
        builders.add(2, (p, q) -> new Bolt(p, q));
        builders.add(3, (p, q) -> new Star(p, q));
        builders.add(4, (p, q) -> new Rectangle(p, q));
    }

    public IBiFunction<Shape, Point> build(int value) {
        return builders.get(value);
    }

}