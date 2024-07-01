import java.util.Scanner;

public class OrderTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the order ID
        System.out.print("Enter a new number ID for order: ");
        int orderId = scanner.nextInt();

        Order order = new Order(orderId);

        // Prompt the user to enter the number of items in the order
        System.out.print("How many items in the order: ");
        int itemCount = scanner.nextInt();

        // Receive inputs for items of the order
        for (int i = 1; i <= itemCount; i++) {
            System.out.print("Please enter the ID for item " + i + ": ");
            int itemId = scanner.nextInt();

            System.out.print("Please enter the Name for item " + i + ": ");
            String itemName = scanner.next();

            System.out.print("Please enter the Price for item " + i + ": ");
            double itemPrice = scanner.nextDouble();

            // Create and add the item to the order
            order.addItem(new Item(itemId, itemName, itemPrice));
        }

        // Calculate and display the average cost of items in the order
        System.out.println("-----");
        System.out.println("You have a new order with ID: " + orderId);
        System.out.println("In the order, you have " + itemCount + " items.");
        System.out.println("The average price in the order is: " + order.calculateAverageCost());

        scanner.close();
    }
}
