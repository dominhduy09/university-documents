public class TestTriangle {
    public static void main(String[] args) {
        // Create points for vertices of the triangle
        Point2D p1 = new Point2D(0, 0);
        Point2D p2 = new Point2D(3, 0);
        Point2D p3 = new Point2D(0, 4);

        // Create a triangle using the points
        Triangle triangle = new Triangle(p1, p2, p3);

        // Display the vertices of the triangle
        System.out.println("Vertices of the triangle:");
        System.out.println("Point 1: " + triangle.getP1());
        System.out.println("Point 2: " + triangle.getP2());
        System.out.println("Point 3: " + triangle.getP3());

        // Calculate and display the perimeter of the triangle
        System.out.println("Perimeter of the triangle: " + triangle.perimeter());

        // Calculate and display the area of the triangle
        System.out.println("Area of the triangle: " + triangle.area());
    }
}
