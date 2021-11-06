package src.interfaces;

import java.awt.Color;
import src.shapes.Shape;
import src.shapes.Point;

public interface ICanvas {
    public void addShape(Shape fig);

    public void removeShape(Shape fig);

    public void selectShape(Point p);

    public Shape getSelectedShape();

    public boolean existsSelection();

    public void removeSelected();

    public void changeColorInter(Color c);

    public void changeColorExter(Color c);
}
