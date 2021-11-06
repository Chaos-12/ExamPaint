package src.app;

import java.awt.Color;
import src.shapes.Shape;
import src.shapes.Point;
import src.tools.*;

public class Painter {
    private Canvas canvas;
    private ShapeBuilder sBuild;
    private IBiFunction<Shape, Point> createShape;
    private ColorBuilder cBuild;
    private Color cExt;
    private Color cInt;

    public Painter(Canvas canvas) {
        this.canvas = canvas;
        this.sBuild = new ShapeBuilder();
        this.cBuild = new ColorBuilder();
        changeShape(0);
        changeColorExt(0);
        changeColorInt(1);
    }

    public void paintShape(Point p, Point q) {
        Shape s = createShape.execute(p, q);
        s.setColorExter(cExt);
        s.setColorInter(cInt);
        this.canvas.addShape(s);
    }

    public void changeShape(int value) {
        this.createShape = sBuild.build(value);
    }

    public void changeColorExt(int value) {
        this.cExt = cBuild.build(value);
    }

    public void changeColorInt(int value) {
        this.cInt = cBuild.build(value);
    }
}
