package src.shapes;

public class Circle extends Shape {

    public Circle(Point p, Point q) {
        super(p, q);
    }

    @Override
    public String getString() {
        return "Circle -> " + super.getString();
    }

    @Override
    public void draw() {
        // TODO
    }

}