package src.app;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import src.shapes.Shape;
import src.interfaces.*;
import src.shapes.Point;

public class Painter implements IPainter, ISub {
    private static Map<String, IFunction> strategies;

    private ICanvas canvas;
    private ShapeBuilder sBuild;
    private IBiFunction<Shape, Point> createShape;
    private ColorBuilder cBuild;
    private Color cExt;
    private Color cInt;
    private Point initPoint;
    private Point endPoint;

    public Painter(ICanvas canvas) {
        this.canvas = canvas;
        this.sBuild = new ShapeBuilder();
        this.cBuild = new ColorBuilder();
        setShapeBuilder(0);
        setColorExt(0);
        setColorInt(1);
    }

    public void paintShape() {
        Shape s = createShape.execute(initPoint, endPoint);
        s.setColorExter(cExt);
        s.setColorInter(cInt);
        this.canvas.addShape(s);
        createStrategies();
    }

    public void createStrategies() {
        strategies = new HashMap<String, IFunction>();
        strategies.put("Shape", (value) -> this.setShapeBuilder((int) value));
        strategies.put("cExt", (value) -> this.setColorExt((int) value));
        strategies.put("cInt", (value) -> this.setColorInt((int) value));
        strategies.put("initPoint", (p) -> this.setInitialPoint((Point) p));
        strategies.put("endPoint", (p) -> this.setEndPoint((Point) p));
    }

    public void receive(String topic, Object message) {
        strategies.get(topic).execute(message);
    }

    public void setShapeBuilder(int value) {
        this.createShape = sBuild.build(value);
    }

    public void setColorExt(int value) {
        this.cExt = cBuild.build(value);
    }

    public void setColorInt(int value) {
        this.cInt = cBuild.build(value);
    }

    public void setInitialPoint(Point p) {
        this.initPoint = p;
    }

    public void setEndPoint(Point p) {
        this.endPoint = p;
    }

    public void clearPoints() {
        this.initPoint = null;
        this.endPoint = null;
    }
}