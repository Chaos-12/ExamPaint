package src.shapes;

public class Oval extends Shape {

    public Oval(Point p, Point q) {
        super(p, q);
    }

    public Oval(Shape fig) {
        super(fig);
    }

    @Override
    public String getString() {
        return "Oval -> " + super.getString();
    }

    @Override
    public void draw() {
        // TODO
    }
}