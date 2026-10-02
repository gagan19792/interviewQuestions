public class Circle extends Reactangle {
    private float radius;

    public Circle(float radius) {
        super(radius, radius);
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * radius * radius);
    }

    @Override
    public float getPerimeter() {
        return (float) (2 * Math.PI * radius);
    }

    @Override
    public String toString() {
        return "Circle: radius = " + radius;
    }

}
