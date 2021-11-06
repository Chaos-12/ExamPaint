package src.app;

import src.shapes.*;
import src.tools.*;

public class Main {

    public static void main(String[] agrs) {
        Out.print("Iniciando la app");

        Canvas lienzo = new Canvas();
        Painter pedro = new Painter(lienzo);
        Point origin = new Point(0, 0);
        Point last = new Point(50, 50);

        pedro.changeColorExt(3);
        pedro.changeShapeBuilder(4);
        pedro.paintShape(origin, last);
        Shape s = lienzo.getSelectedShape();
        Out.print(s.getString());

        Out.print("Exito");
    }
}