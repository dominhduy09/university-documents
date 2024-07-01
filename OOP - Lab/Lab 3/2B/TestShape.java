public class TestShape {
    public static void main(String[] args) {
        // Upcasting Circle to Shape
        Shape s1 = new Circle(5.5, "red", false);
        System.out.println(s1); // calls Circle's toString()
        System.out.println("Area: " + s1.getArea()); // calls Circle's getArea()
        System.out.println("Perimeter: " + s1.getPerimeter()); // calls Circle's getPerimeter()
        System.out.println("Color: " + s1.getColor()); // calls Shape's getColor()
        System.out.println("Filled: " + s1.isFilled()); // calls Shape's isFilled()

        // Downcasting back to Circle
        Circle c1 = (Circle) s1;
        System.out.println(c1); // calls Circle's toString()
        System.out.println("Area: " + c1.getArea()); // calls Circle's getArea()
        System.out.println("Perimeter: " + c1.getPerimeter()); // calls Circle's getPerimeter()
        System.out.println("Color: " + c1.getColor()); // calls Shape's getColor()
        System.out.println("Filled: " + c1.isFilled()); // calls Shape's isFilled()
        System.out.println("Radius: " + c1.getRadius()); // calls Circle's getRadius()

        // Upcasting Rectangle to Shape
        Shape s2 = new Rectangle(1.0, 2.0, "red", false);
        System.out.println(s2); // calls Rectangle's toString()
        System.out.println("Area: " + s2.getArea()); // calls Rectangle's getArea()
        System.out.println("Perimeter: " + s2.getPerimeter()); // calls Rectangle's getPerimeter()
        System.out.println("Color: " + s2.getColor()); // calls Shape's getColor()

        // Downcasting back to Rectangle
        Rectangle r1 = (Rectangle) s2;
        System.out.println(r1); // calls Rectangle's toString()
        System.out.println("Area: " + r1.getArea()); // calls Rectangle's getArea()
        System.out.println("Color: " + r1.getColor()); // calls Shape's getColor()
        System.out.println("Length: " + r1.getLength()); // calls Rectangle's getLength()

        // Upcasting Square to Shape
        Shape s3 = new Square(6.6);
        System.out.println(s3); // calls Square's toString()
        System.out.println("Area: " + s3.getArea()); // calls Square's getArea()
        System.out.println("Color: " + s3.getColor()); // calls Shape's getColor()
        System.out.println("Side: " + ((Square) s3).getWidth()); // Downcasting to access getWidth()
    }
}