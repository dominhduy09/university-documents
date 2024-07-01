public class TriangleTesting {
    public static void main(String[] args) {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(2, 7);
        Point2D p3 = new Point2D(3, 4);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        Triangle myTriangle = new Triangle(p1, p2, p3);
        System.out.printf("The perimeter is %.2f\n", myTriangle.perimeter());
        System.out.printf("The area is %.2f\n", myTriangle.area());
    }
}