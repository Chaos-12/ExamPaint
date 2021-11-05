package src.app;

import java.util.ArrayList;
import java.awt.Color;
import src.shapes.*;

public class Canvas {
    private ArrayList<Shape> figures;
    private int selectedFig = -1;

    public Canvas() {
        figures = new ArrayList<Shape>();
    }

    public void addShape(Shape fig) {
        figures.add(fig);
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

    public boolean existsSelect() {
        return !(selectedFig == -1);
    }

    public void removeSelected() {
        if (existsSelect()) {
            figures.remove(selectedFig);
        }
    }

    public void changeColorInter(Color c) {
        if (existsSelect()) {
            figures.get(selectedFig).setColorInter(c);
        }
    }

    public void changeColorExter(Color c) {
        if (existsSelect()) {
            figures.get(selectedFig).setColorExter(c);
        }
    }
}
