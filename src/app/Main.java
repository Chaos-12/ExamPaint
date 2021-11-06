package src.app;

import lists.*;
import src.interfaces.*;
import src.shapes.*;

public class Main {

    public static void main(String[] agrs) {
        Out.print("Import shape List");
        ShapeData.createLists();
        Out.print(ShapeData.getShapeInfo());
        Out.print("Import color List");
        ColorData.createLists();
        Out.print(ColorData.getColorInfo());

        ICanvas lienzo = new Canvas();
        IPainter david = new Painter(lienzo);
        IPubSubBroker controller = new PubSubBroker();
        controller.subscribe("Shape", lienzo);
        controller.subscribe("cExt", lienzo);
        controller.subscribe("cInt", lienzo);
        controller.subscribe("Shape", david);
        controller.subscribe("cExt", david);
        controller.subscribe("cInt", david);
        controller.subscribe("endPoint", david);
        IUser pedro = new User("Pedro", controller);

        Shape s = lienzo.getSelectedShape();
        Out.print(s.getString());

        Out.print("Exito");
    }
}