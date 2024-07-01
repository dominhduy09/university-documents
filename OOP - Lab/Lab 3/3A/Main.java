public class Main {
    public static void main(String[] args) {
        // Create a Rectangle object with length=10 and width=12
        Rectangle rectangle = new Rectangle(10, 12);

        // Create a Circle object with radius=3
        Circle circle = new Circle(3);

        // Print the area of the Rectangle
        System.out.println("Area of the Rectangle: " + rectangle.getArea());

        // Print the area of the Circle
        System.out.println("Area of the Circle: " + circle.getArea());

        // Print the area of the Rectangle
        System.out.println("Perimeter of the Rectangle: " + rectangle.getPerimeter());

        // Print the area of the Circle
        System.out.println("Perimeter of the Circle: " + circle.getPerimeter());

        // Print the area of the Rectangle
        System.out.println("" + rectangle.toString());

        // Print the area of the Circle
        System.out.println("" + circle.toString());
    }
}