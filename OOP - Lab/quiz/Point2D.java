import java.util.Scanner;

public class Point2D {
    private int x;
    private int y;

    // Default constructor initializes the point at the origin (0,0)
    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor with coordinates
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Copy constructor
    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }

    // Method to input coordinates from keyboard
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x coordinate: ");
        this.x = scanner.nextInt();
        System.out.print("Enter y coordinate: ");
        this.y = scanner.nextInt();
    }

    // String representation of coordinates
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Move point to new coordinates
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Check if point is at origin
    public boolean isOrigin() {
        return (x == 0 && y == 0);
    }

    // Calculate distance from this point to another point p
    public double distance(Point2D p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Static method to calculate distance between two points
    public static double distance(Point2D p1, Point2D p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Getter methods for x and y coordinates
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
