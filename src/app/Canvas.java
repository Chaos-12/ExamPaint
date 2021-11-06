package src.app;

import java.util.ArrayList;
import java.awt.Color;
import src.shapes.Shape;
import src.interfaces.ICanvas;
import src.shapes.Point;

public class Canvas implements ICanvas {
    private ArrayList<Shape> figures;
    private int selectedFig = -1;

    public Canvas() {
        figures = new ArrayList<Shape>();
    }

    public void addShape(Shape fig) {
        figures.add(fig);
        selectedFig = figures.size() - 1;
    }

    public void removeShape(Shape fig) {
        figures.remove(fig);
    }

    public void selectShape(Point p) {
        selectedFig = -1;
        for (int i = 0; i < figures.size(); i++) {
            if (figures.get(i).contains(p)) {
                selectedFig = i;
            }
        }
    }

    public Shape getSelectedShape() {
        return figures.get(selectedFig);
    }

    public boolean existsSelection() {
        return selectedFig != -1;
    }

    public void removeSelected() {
        if (existsSelection()) {
            figures.remove(selectedFig);
        }
    }

    public void changeColorInter(Color c) {
        if (existsSelection()) {
            figures.get(selectedFig).setColorInter(c);
        }
    }

    public void changeColorExter(Color c) {
        if (existsSelection()) {
            figures.get(selectedFig).setColorExter(c);
        }
    }
}