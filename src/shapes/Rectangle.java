package src.shapes;

public class Rectangle extends Shape {

    public Rectangle(Point p, Point q) {
        super(p, q);
    }

    public Rectangle(Shape fig) {
        super(fig);
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