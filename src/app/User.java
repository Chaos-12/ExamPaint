package src.app;

import lists.ColorData;
import lists.ShapeData;
import src.interfaces.*;
import src.shapes.Point;

public class User implements IUser {
    private IPubSubBroker broker;
    private String name;

    public User(String name, IPubSubBroker broker) {
        this.name = name;
        this.broker = broker;
        Out.print("New user: " + name);
    }

    public void clickOn(int x, int y) {
        Point p = new Point(x, y);
        Out.print(name + " clicks on " + p.toString());
        broker.send("Click", p);
    }

    @Override
    public void dragMouse(int xFrom, int yFrom, int xTo, int yTo) {
        Point fromPoint = new Point(xFrom, yFrom);
        Point toPoint = new Point(xTo, yTo);
        Out.print(name + " drags mouse from " + fromPoint.toString() + " to " + toPoint.toString());
        broker.send("initPoint", fromPoint);
        broker.send("endPoint", toPoint);
    }

    @Override
    public void chooseShape(int sNumber) {
        Out.print(name + " selects shape number " + sNumber + ": " + ShapeData.getShapeString().get(sNumber));
        broker.send("Shape", sNumber);

    }

    @Override
    public void chooseExtColor(int cNumber) {
        Out.print(name + " selects extColor number " + cNumber + ": " + ColorData.getColorString().get(cNumber));
        broker.send("cExt", cNumber);

    }

    @Override
    public void chooseIntColor(int cNumber) {
        Out.print(name + " selects intColor number " + cNumber + ": " + ColorData.getColorString().get(cNumber));
        broker.send("cInt", cNumber);

    }
}
