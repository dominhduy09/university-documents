public class BigSmallGame {
    public static final int MIN_BET_AMOUNT = 1;

    private int playerMoney;
    private int houseMoney;
    private Dice dice;

    public BigSmallGame(int playerMoney, int houseMoney) {
        this.playerMoney = playerMoney;
        this.houseMoney = houseMoney;
        this.dice = new Dice();
    }

    public boolean playRound(int betAmount, String choice) {
        if (betAmount < MIN_BET_AMOUNT || betAmount > playerMoney) {
            System.out.println("Invalid bet amount! Please enter a valid bet amount.");
            return false;
        }

        int dice1 = dice.roll();
        int dice2 = dice.roll();
        int dice3 = dice.roll();

        int sum = dice1 + dice2 + dice3;
        System.out.println("The dices are: " + dice1 + " " + dice2 + " " + dice3);
        System.out.println("Sum of 3 dices is: " + sum);

        boolean win = false;
        if ((sum >= 4 && sum <= 10 && choice.equalsIgnoreCase("big")) ||
                (sum >= 11 && sum <= 17 && choice.equalsIgnoreCase("small"))) {
            win = true;
        }

        return win;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public int getHouseMoney() {
        return houseMoney;
    }

    public void setHouseMoney(int houseMoney) {
        this.houseMoney = houseMoney;
    }
}
