package src.shapes;

public class Star extends Shape {

    public Star(Point p, Point q) {
        super(p, q);
    }

    @Override
    public String getString() {
        return "Star -> " + super.getString();
    }

    @Override
    public void draw() {
        // TODO
    }

}