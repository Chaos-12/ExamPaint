package src.shapes;

public class Heart extends Shape {

    public Heart(Point p, Point q) {
        super(p, q);
    }

    public Heart(Shape fig) {
        super(fig);
    }

    @Override
    public String getString() {
        return "Heart -> " + super.getString();
    }

    @Override
    public void draw() {
        // TODO
    }
}