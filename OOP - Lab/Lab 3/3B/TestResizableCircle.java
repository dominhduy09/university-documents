public class TestResizableCircle {
    public static void main(String[] args) {
        // Create a ResizableCircle object with initial radius
        ResizableCircle circle = new ResizableCircle(5.0);

        // Display the initial state of the circle
        System.out.println("Initial Circle:");
        System.out.println(circle);

        // Resize the circle by a percentage
        int resizePercentage = 50;
        circle.resize(resizePercentage);

        // Display the resized circle
        System.out.println("\nResized Circle (by " + resizePercentage + "%):");
        System.out.println(circle);
    }
}
