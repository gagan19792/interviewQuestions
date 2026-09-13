public class Square extends Reactangle {
    public Square(float side) {
        super(side, side);
    }

    public float getArea() {
        return length * length;
    }

    public float getPerimeter() {
        return 4 * length;
    }
    @Override
    public String toString() {
        return "Square: side = " + length;
    }

}
