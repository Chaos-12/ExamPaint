package src.app;

import java.util.List;

import src.interfaces.IBiFunction;
import src.interfaces.IBuilder;
import src.shapes.*;

public class ShapeBuilder implements IBuilder<IBiFunction<Shape, Point>> {

    private List<IBiFunction<Shape, Point>> builders;

    public ShapeBuilder(List list) {
        builders = list;
    }

    public IBiFunction<Shape, Point> build(int value) {
        return builders.get(value);
    }
}