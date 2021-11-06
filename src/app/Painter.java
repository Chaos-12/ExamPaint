package src.app;

import java.util.HashMap;
import java.util.Map;

import lists.*;
import src.interfaces.*;
import src.shapes.Shape;
import src.shapes.Point;

public class Painter implements IPainter {
    private Map<String, IFunction> strategies;
    private Map<String, IBiArgFunction> unsubscribe;
    private ICanvas canvas;
    private IBiFunction<Shape, Point> createShape;
    private int cExt;
    private int cInt;
    private Point initPoint;
    private Point endPoint;

    public Painter(ICanvas canvas) {
        this.canvas = canvas;
        setShapeBuilder(0);
        setColorExt(0);
        setColorInt(1);
        strategies = PainterStrategies.createStrategies(this);
        unsubscribe = new HashMap<String, IBiArgFunction>();
    }

    public void paintShape() {
        Shape s = createShape.execute(initPoint, endPoint);
        s.setColorExter(cExt);
        s.setColorInter(cInt);
        this.canvas.addShape(s);
        Out.print("App draws a " + s.getString());
    }

    public void receive(String topic, Object message) {
        strategies.get(topic).execute(message);
    }

    public void setShapeBuilder(int value) {
        this.createShape = ShapeData.getBuilderPoint().get(value);
    }

    public void setColorExt(int value) {
        this.cExt = value;
    }

    public void setColorInt(int value) {
        this.cInt = value;
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

    public void getDispose(String topic, IBiArgFunction f) {
        unsubscribe.put(topic, f);
    }

    public void unsubscribe(String topic) {
        this.unsubscribe.get(topic).execute(topic, this);
    }
}