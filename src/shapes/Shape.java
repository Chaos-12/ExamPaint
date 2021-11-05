package src.shapes;

import java.awt.Color;

public abstract class Shape {
    private Point pTop;
    private Point pBot;
    private Color cInt;
    private Color cExt;

    public Shape(Point p, Point q) {
        int xMin = Math.min(p.getX(), q.getX());
        int yMin = Math.min(p.getY(), q.getY());
        int xMax = Math.max(p.getX(), q.getX());
        int yMax = Math.max(p.getY(), q.getY());
        this.pTop = new Point(xMin, yMin);
        this.pBot = new Point(xMax, yMax);
        this.cInt = Color.white;
        this.cExt = Color.black;
    }

    public void setColorInter(Color c) {
        cInt = c;
    }

    public void setColorExter(Color c) {
        cExt = c;
    }

    public String getStringColors() {
        return "cInt: [" + cInt.getRed() + ", " + cInt.getGreen() + ", " + cInt.getBlue() + "], cExt: [" + cExt.getRed()
                + ", " + cExt.getGreen() + ", " + cExt.getBlue() + "]";
    }

    public String getStringPoints() {
        return "pTop: " + pTop.toString() + ", pBot: " + pBot.toString();
    }

    public String getString() {
        return getStringColors() + ", " + getStringPoints() + ".";
    }

    public boolean contains(Point p) {
        if (pTop.getX() <= p.getX() && p.getX() <= pBot.getX() && pTop.getY() <= p.getY() && p.getY() <= pBot.getY()) {
            return true;
        }
        return false;
    }

    public abstract void draw();
}
