// Implementation class Rectangle
public class Rectangle implements GeometricObject {
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Override getArea method
    @Override
    public double getArea() {
        return width * height;
    }

    // Override getPerimeter method
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Override toString method
    @Override
    public String toString() {
        return "Rectangle[width=" + width + ",length=" + height + "]";
    }
}
