public class Rectangle extends Shape {
    double dSide1, dSide2;

    public Rectangle(Location c, double dSide1, double dSide2) {
        super(c);
        this.dSide1 = dSide1;
        this.dSide2 = dSide2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "Location=" + c +
                ", Side1=" + dSide1 +
                ", Side2=" + dSide2 +
                '}';
    }

    @Override
    public double area() {
        return dSide1 * dSide2;
    }

    @Override
    public double perimeter() {
        return 2 * (dSide1 + dSide2);
    }
}
