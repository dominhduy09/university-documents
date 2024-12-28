import java.util.Scanner;

public class GasMileage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input for first car
        System.out.print("Enter the car name, miles driven, and gallons used (separated by space): ");
        String car1 = input.next(); // Read car name
        double miles1 = input.nextDouble(); // Read miles driven
        double gallons1 = input.nextDouble(); // Read gallons used

        // Input for second car
        System.out.print("Enter the car name, miles driven, and gallons used (separated by space): ");
        String car2 = input.next(); // Read car name
        double miles2 = input.nextDouble(); // Read miles driven
        double gallons2 = input.nextDouble(); // Read gallons used

        // Calculate and display miles per gallon (MPG) for each car
        double mpg1 = miles1 / gallons1;
        double mpg2 = miles2 / gallons2;

        System.out.printf("%s MPG: %.2f\n", car1, mpg1);
        System.out.printf("%s MPG: %.2f\n", car2, mpg2);
    }
}
