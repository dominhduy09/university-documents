public class TestCircle {
    public static void main(String[] args) {
        // Create a Circle object with radius 5
        Circle circle = new Circle(5);
        Circle circle1 = new Circle(5);
        // Display the area and perimeter of the circle
        System.out.println(circle);
        System.out.printf("Circle Area: %.2f\n", circle.getArea());
        System.out.printf("Circle Perimeter: %.2f", circle.getPerimeter());

        System.out.println("Circle 1:");
        System.out.println("Area: " + circle1.getArea());
        System.out.println("Perimeter: " + circle1.getPerimeter());
        System.out.println("Details: " + circle1);

        // Create a ResizableCircle object
        ResizableCircle circle2 = new ResizableCircle(3);

        // Test ResizableCircle methods
        System.out.println("\nResizable Circle 2:");
        System.out.println("Resizing by 50%...");
        circle2.resize(50);
        System.out.println("Area: " + circle2.getArea());
        System.out.println("Perimeter: " + circle2.getPerimeter());
        System.out.println("Details: " + circle2);
    }
}
