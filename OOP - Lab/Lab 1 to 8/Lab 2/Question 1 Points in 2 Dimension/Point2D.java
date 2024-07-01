import java.util.Scanner;

public class Point2D {
    private int x;
    private int y;

    public Point2D() {
        this(0, 0);
    }

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D p) {
        this(p.x, p.y);
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter X: ");
        this.x = scanner.nextInt();
        System.out.println("Enter Y: ");
        this.y = scanner.nextInt();
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isOrigin() {
        return x == 0 && y == 0;
    }

    public double distance(Point2D p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static double distance(Point2D p1, Point2D p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
