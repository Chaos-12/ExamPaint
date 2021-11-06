package src.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lists.CanvasStrategies;
import lists.ShapeData;
import src.shapes.Shape;
import src.shapes.Point;
import src.interfaces.*;

public class Canvas implements ICanvas {
    private Map<String, IFunction> strategies;
    public Map<String, IBiArgFunction> unsubscribe;
    private ArrayList<Shape> figures;
    private int selectedFig;

    public Canvas() {
        selectedFig = -1;
        figures = new ArrayList<Shape>();
        strategies = CanvasStrategies.createStrategies(this);
        unsubscribe = new HashMap<String, IBiArgFunction>();
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
        if (existsSelection()) {
            Out.print("App highlights shape number " + selectedFig);
            Out.print("\t" + getSelectedShape().getString());
        } else {
            Out.print("No shape is highlighted");
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
            Out.print("Shape number " + selectedFig + " disapears");
        }
    }

    public void changeColorInter(int color) {
        if (existsSelection()) {
            figures.get(selectedFig).setColorInter(color);
            Out.print("Shape number " + selectedFig + " changes internal color:");
            Out.print("\t" + getSelectedShape().getString());
        }
    }

    public void changeColorExter(int color) {
        if (existsSelection()) {
            figures.get(selectedFig).setColorExter(color);
            Out.print("Shape number " + selectedFig + " changes external color:");
            Out.print("\t" + getSelectedShape().getString());
        }
    }

    public void changeShape(int value) {
        if (existsSelection()) {
            Shape newShape = ShapeData.getBuildShape().get(value).apply(getSelectedShape());
            figures.remove(selectedFig);
            figures.add(selectedFig, newShape);
            Out.print(
                    "Shape number " + selectedFig + " transforms into " + ShapeData.getShapeString().get(value) + ":");
            Out.print("\t" + getSelectedShape().getString());
        }
    }

    public void getDispose(String topic, IBiArgFunction f) {
        unsubscribe.put(topic, f);
    }

    public void unsubscribe(String topic) {
        this.unsubscribe.get(topic).execute(topic, this);
    }
}