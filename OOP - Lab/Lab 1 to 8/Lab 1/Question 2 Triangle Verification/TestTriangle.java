import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter lengths of three sides
        System.out.print("Please enter 3 numbers for the sides of a triangle:\n");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        // Create a Triangle object
        Triangle triangle = new Triangle(x, y, z);

        // Verify and display the result
        String triangleType = triangle.verify();
        System.out.println("The triangle is: " + triangleType);

        scanner.close();
    }
}
