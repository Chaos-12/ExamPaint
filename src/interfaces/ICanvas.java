package src.interfaces;

import src.shapes.Shape;
import src.shapes.Point;

public interface ICanvas extends ISub {
    public void addShape(Shape fig);

    public void removeShape(Shape fig);

    public void selectShape(Point p);

    public Shape getSelectedShape();

    public boolean existsSelection();

    public void removeSelected();

    public void changeColorInter(int color);

    public void changeColorExter(int color);

    public void changeShape(int value);
}
