public class Triangle {
    private Point2D p1;
    private Point2D p2;
    private Point2D p3;

    // Initialization constructor
    public Triangle(Point2D p1, Point2D p2, Point2D p3) {
        this.p1 = new Point2D(p1);
        this.p2 = new Point2D(p2);
        this.p3 = new Point2D(p3);
    }

    // Calculate the perimeter of the triangle
    // public double perimeter() {
    // return Point2D.distance(p1, p2) + Point2D.distance(p2, p3) +
    // Point2D.distance(p3, p1);
    // }

    // // Calculate the area of the triangle
    // public double area() {
    // double a = Point2D.distance(p1, p2);
    // double b = Point2D.distance(p2, p3);
    // double c = Point2D.distance(p3, p1);
    // double s = (a + b + c) / 2; // semi-perimeter
    // return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    // }

    // Getters for vertices
    public Point2D getP1() {
        return p1;
    }

    public Point2D getP2() {
        return p2;
    }

    public Point2D getP3() {
        return p3;
    }
}
