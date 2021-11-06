package src.app;

import src.shapes.Point;

public interface IPainter {
    public void paintShape(Point p, Point q);

    public void changeShapeBuilder(int value);

    public void changeColorExt(int value);

    public void changeColorInt(int value);
}