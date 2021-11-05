package src.app;

import src.shapes.*;
import src.tools.*;

public class Main {

    public static void main(String[] agrs) {
        Out.print("Iniciando la app");
        Canvas lienzo = new Canvas();
        Point origin = new Point(0, 0);
        Point last = new Point(50, 50);
        ShapeBuilder sb = new ShapeBuilder();

        Shape s = sb.build(2).execute(origin, last);

        Out.print(s.getString());
        Out.print("Exito");
    }
}