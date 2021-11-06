package src.shapes;

public class Rectangle extends Shape {

    public Rectangle(Point p, Point q) {
        super(p, q);
    }

    @Override
    public String getString() {
        return "Rectangle -> " + super.getString();
    }

    @Override
    public void draw() {
        // TODO
    }
}