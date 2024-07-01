import java.util.Random;

class Dice {
    private static final int MAX_VALUE = 6;
    private Random random;

    public Dice() {
        random = new Random();
    }

    public int roll() {
        return random.nextInt(MAX_VALUE) + 1;
    }
}
