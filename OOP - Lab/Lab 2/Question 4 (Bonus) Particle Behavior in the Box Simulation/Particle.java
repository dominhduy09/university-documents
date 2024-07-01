
import java.util.Random;

// Enum for directions
enum Direction {
    NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST
}

// Particle class
class Particle {
    private int x;
    private int y;

    public Particle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveRandomly() {
        Random random = new Random();
        Direction direction = Direction.values()[random.nextInt(Direction.values().length)];

        switch (direction) {
            case NORTH:
                if (y > 0)
                    y--;
                break;
            case NORTHEAST:
                if (y > 0 && x < Box.getInstance().getWidth() - 1) {
                    y--;
                    x++;
                }
                break;
            case EAST:
                if (x < Box.getInstance().getWidth() - 1)
                    x++;
                break;
            case SOUTHEAST:
                if (y < Box.getInstance().getHeight() - 1 && x < Box.getInstance().getWidth() - 1) {
                    y++;
                    x++;
                }
                break;
            case SOUTH:
                if (y < Box.getInstance().getHeight() - 1)
                    y++;
                break;
            case SOUTHWEST:
                if (y < Box.getInstance().getHeight() - 1 && x > 0) {
                    y++;
                    x--;
                }
                break;
            case WEST:
                if (x > 0)
                    x--;
                break;
            case NORTHWEST:
                if (y > 0 && x > 0) {
                    y--;
                    x--;
                }
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
