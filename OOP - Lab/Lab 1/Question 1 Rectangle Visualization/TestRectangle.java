import java.util.Scanner;

public class TestRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter width
        System.out.print("Enter width:\n");
        int width = scanner.nextInt();
        // Prompt the user to enter height
        System.out.print("Enter height:\n");
        int height = scanner.nextInt();

        // Instantiate a rectangle with user-provided width and height
        Rectangle rect = new Rectangle(width, height);

        // Visualize the rectangle
        rect.visualize();

        scanner.close();
    }
}
