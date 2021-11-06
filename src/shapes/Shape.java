package src.shapes;

import lists.ColorData;

public abstract class Shape {
    private Point pTop;
    private Point pBot;
    private int cExt;
    private int cInt;

    public Shape(Point p, Point q) {
        int xMin = Math.min(p.getX(), q.getX());
        int yMin = Math.min(p.getY(), q.getY());
        int xMax = Math.max(p.getX(), q.getX());
        int yMax = Math.max(p.getY(), q.getY());
        this.pTop = new Point(xMin, yMin);
        this.pBot = new Point(xMax, yMax);
        this.cExt = 0;
        this.cInt = 1;
    }

    public Shape(Shape fig) {
        this.pTop = fig.pTop;
        this.pBot = fig.pBot;
        this.cExt = fig.cExt;
        this.cInt = fig.cInt;
    }

    public void setColorInter(int value) {
        cInt = value;
    }

    public void setColorExter(int value) {
        cExt = value;
    }

    public String getStringColors() {
        return "cExt: " + ColorData.getColorString().get(cExt) + ", cInt: " + ColorData.getColorString().get(cInt);
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