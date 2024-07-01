public class TestShape {
    public static void main(String[] args) {
        Location loc1 = new Location(5, 10);
        Circle circle = new Circle(loc1, 7);
        System.out.println(circle.toString());
        System.out.println("Area: " + circle.area());
        System.out.println("Perimeter: " + circle.perimeter());

        Location loc2 = new Location(15, 25);
        Rectangle rectangle = new Rectangle(loc2, 5, 10);
        System.out.println(rectangle.toString());
        System.out.println("Area: " + rectangle.area());
        System.out.println("Perimeter: " + rectangle.perimeter());
    }
}
