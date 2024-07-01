// Class ResizableCircle
public class ResizableCircle extends Circle implements Resizable {
    // Constructor
    public ResizableCircle(double radius) {
        super(radius);
    }

    // Override resize method
    @Override
    public void resize(int percentage) {
        // Modifying the radius by the given percentage
        System.out.println(radius *= (percentage / 100.0));
    }

    // Override toString method
    @Override
    public String toString() {
        return "ResizableCircle[radius=" + radius + "]";
    }
}