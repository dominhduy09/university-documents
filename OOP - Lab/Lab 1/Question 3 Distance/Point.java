public class Point {
    private double x;
    private double y;

    // Constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Method to compute the distance between two points
    public double distance(Point target) {
        double deltaX = this.x - target.x;
        double deltaY = this.y - target.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
