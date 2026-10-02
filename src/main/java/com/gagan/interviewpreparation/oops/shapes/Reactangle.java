public class Reactangle implements Shape{
    protected float length;
    protected float width;

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float getArea(){

        return length * width;
    }

    public float getPerimeter(){
        return 2 * (length + width);
    }

    public String toString(){
        return "Rectangle: length = " + length + ", width = " + width;
    }
}
