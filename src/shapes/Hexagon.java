package src.shapes;

public class Hexagon extends Shape {

    public Hexagon(Point p, Point q) {
        super(p, q);
    }

    public Hexagon(Shape fig) {
        super(fig);
    }

    @Override
    public String getString() {
        return "Hexagon -> " + super.getString();
    }

    @Override
    public void draw() {
        // TODO
    }
}