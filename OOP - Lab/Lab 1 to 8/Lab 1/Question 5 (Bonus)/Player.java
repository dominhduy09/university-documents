import java.util.Scanner;

public class Player {
    private int money;

    public Player(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int placeBet(Scanner scanner) {
        System.out.println("How much do you want to bet? (Minimum bet: $" + BigSmallGame.MIN_BET_AMOUNT + ")");
        return scanner.nextInt();
    }

    public String chooseOption(Scanner scanner) {
        System.out.println("Do you want to bet big or small? (big/small)");
        return scanner.next();
    }
}
