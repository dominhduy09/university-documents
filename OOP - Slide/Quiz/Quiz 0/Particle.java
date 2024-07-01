import java.util.Random;

public class Particle {
    private int x;
    private int y;

    private int getRandom() {
        Random rand = new Random();
        return rand.nextInt(3) - 1; // Returns a number among (-1, 0, 1)
    }

    public Particle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        int dx = getRandom();
        int dy = getRandom();
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean collidesWith(Particle other) {
        return this.x == other.getX() && this.y == other.getY();
    }
}
