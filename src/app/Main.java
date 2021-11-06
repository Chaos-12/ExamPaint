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

        pedro.setColorExt(3);
        pedro.setShapeBuilder(4);
        pedro.setInitialPoint(origin);
        pedro.setEndPoint(last);
        pedro.paintShape();
        Shape s = lienzo.getSelectedShape();
        Out.print(s.getString());

        Out.print("Exito");
    }
}