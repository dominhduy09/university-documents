public abstract class Shape {
    Location c;

    public Shape(Location c) {
        this.c = c;
    }

    @Override
    public abstract String toString();

    public abstract double area();

    public abstract double perimeter();
}
