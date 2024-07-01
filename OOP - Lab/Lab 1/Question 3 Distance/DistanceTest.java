import java.util.Scanner;

public class DistanceTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter coordinates for point 1
        System.out.println("Enter the first point x and y:");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        // Prompt the user to enter coordinates for point 2
        System.out.println("Enter the second point x and y:");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        // Create two Point objects
        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);

        // Compute and print the distance between the two points
        System.out.println("The distance between X and Y is: " + point1.distance(point2));

        scanner.close();
    }
}
