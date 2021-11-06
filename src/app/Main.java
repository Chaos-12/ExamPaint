package src.app;

import src.interfaces.ICanvas;
import src.interfaces.IPainter;
import src.shapes.*;

public class Main {

    public static void main(String[] agrs) {
        Out.print("Iniciando la app");

        ICanvas lienzo = new Canvas();
        IPainter pedro = new Painter(lienzo);
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