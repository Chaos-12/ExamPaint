package src.shapes;

public class Bolt extends Shape {

    public Bolt(Point p, Point q) {
        super(p, q);
    }

    public Bolt(Shape fig) {
        super(fig);
    }

    @Override
    public String getString() {
        return "Bolt -> " + super.getString();
    }

    @Override
    public void draw() {
        // TODO
    }
}