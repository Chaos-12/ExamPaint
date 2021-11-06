package src.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;

import lists.CanvasStrategies;
import lists.ShapeData;
import src.shapes.Shape;
import src.shapes.Point;
import src.interfaces.ICanvas;
import src.interfaces.IFunction;

public class Canvas implements ICanvas {
    private static Map<String, IFunction> strategies;
    private ArrayList<Shape> figures;
    private int selectedFig;

    public Canvas() {
        selectedFig = -1;
        figures = new ArrayList<Shape>();
        this.strategies = CanvasStrategies.createStrategies(this);
    }

    public void receive(String topic, Object message) {
        strategies.get(topic).execute(message);
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

    public void changeColorInter(int color) {
        if (existsSelection()) {
            figures.get(selectedFig).setColorInter(color);
        }
    }

    public void changeColorExter(int color) {
        if (existsSelection()) {
            figures.get(selectedFig).setColorExter(color);
        }
    }

    public void changeShape(int value) {
        if (existsSelection()) {
            int oldShape = 4;
            Shape newShape = ShapeData.getBuildShape().get(value).apply(getSelectedShape());
            figures.remove(selectedFig);
            figures.add(selectedFig, newShape);
        }
    }
}