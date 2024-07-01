// Implementation class Circle
public class Circle implements GeometricObject {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Override getArea method
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Override getPerimeter method
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Circle[radius=" + radius + "]";
    }
}
