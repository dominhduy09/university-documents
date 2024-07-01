public class Triangle {
    private int x;
    private int y;
    private int z;

    // Constructor
    public Triangle(int x, int y, int z) {
        if (x < 0) {
            System.out.println("Warning: input x must not be negative!");
        } else {
            this.x = x;
        }

        if (y < 0) {
            System.out.println("Warning: input y must not be negative!");
        } else {
            this.y = y;
        }

        if (z < 0) {
            System.out.println("Warning: input z must not be negative!");
        } else {
            this.z = z;
        }
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    // Methods
    public String verify() {
        if (x + y <= z || x + z <= y || y + z <= x) {
            return "Not Triangle";
        } else if (x == y && y == z) {
            return "Equilateral Triangle";
        } else if (x == y || x == z || y == z) {
            return "Isosceles Triangle";
        } else {
            return "Scalene Triangle";
        }
    }
}
