package src.app;

import lists.*;
import src.interfaces.*;

public class Main {

    public static void main(String[] agrs) {
        Out.print("Import Shapes:");
        ShapeData.createLists();
        Out.print(ShapeData.getShapeInfo());
        Out.print("Import Colors:");
        ColorData.createLists();
        Out.print(ColorData.getColorInfo());

        ICanvas lienzo = new Canvas();
        IPainter david = new Painter(lienzo);
        IPubSubBroker controller = new PubSubBroker();
        controller.subscribe("Shape", lienzo);
        controller.subscribe("Click", lienzo);
        controller.subscribe("cExt", lienzo);
        controller.subscribe("cInt", lienzo);
        controller.subscribe("trash", lienzo);
        controller.subscribe("Shape", david);
        controller.subscribe("initPoint", david);
        controller.subscribe("endPoint", david);
        controller.subscribe("cExt", david);
        controller.subscribe("cInt", david);

        IUser pedro = new User("Pedro", controller);

        pedro.chooseIntColor(4);
        pedro.dragMouse(0, 100, 100, 0);
        pedro.chooseIntColor(2);

        pedro.clickOn(110, 110);
        pedro.chooseShape(5);
        pedro.chooseIntColor(5);
        pedro.dragMouse(110, 00, 210, 100);
        pedro.chooseShape(2);

        pedro.clickOn(0, 110);
        pedro.chooseShape(2);
        pedro.chooseExtColor(5);
        pedro.chooseIntColor(1);
        pedro.dragMouse(220, 00, 320, 100);

        pedro.dragMouse(40, 100, 0, 45);
        pedro.trashIcon();

        Out.print("Exit");
    }
}