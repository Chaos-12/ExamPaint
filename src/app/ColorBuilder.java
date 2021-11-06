package src.app;

import java.util.ArrayList;
import java.util.List;

import src.interfaces.IBuilder;

import java.awt.Color;

public class ColorBuilder implements IBuilder<Color> {

    private List<Color> cList;

    public ColorBuilder() {
        cList = new ArrayList<Color>();
        cList.add(0, Color.black);
        cList.add(1, Color.white);
        cList.add(2, Color.red);
        cList.add(3, Color.green);
        cList.add(4, Color.blue);
        cList.add(5, Color.yellow);
        cList.add(6, Color.orange);
        cList.add(7, Color.pink);
    }

    public Color build(int value) {
        return cList.get(value);
    }

}