public class Circle extends Shape {
    double dRadius;

    public Circle(Location c, double dRadius) {
        super(c);
        this.dRadius = dRadius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "Location=" + c +
                ", Radius=" + dRadius +
                '}';
    }

    @Override
    public double area() {
        return Math.PI * dRadius * dRadius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * dRadius;
    }
}
