package src.interfaces;

import src.shapes.Point;

public interface IPainter extends ISub {
    public void paintShape();

    public void setShapeBuilder(int value);

    public void setColorExt(int value);

    public void setColorInt(int value);

    public void setInitialPoint(Point p);

    public void setEndPoint(Point p);

    public void clearPoints();
}