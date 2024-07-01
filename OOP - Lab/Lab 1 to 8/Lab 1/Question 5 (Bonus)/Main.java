import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize player and house with initial money
        Player player = new Player(100);
        House house = new House(1000);

        // Create a BigSmallGame instance
        BigSmallGame bigSmallGame = new BigSmallGame(player.getMoney(), house.getMoney());

        System.out.println("The house has $" + house.getMoney());
        System.out.println("The player has $" + player.getMoney());
        System.out.println("Try your luck to win all the money of the house!");

        boolean continuePlaying = true;
        int round = 1;

        while (continuePlaying && player.getMoney() > 0 && house.getMoney() > 0) {
            System.out.println("\nRound " + round + ":");

            // Player places a bet
            int betAmount = player.placeBet(scanner);

            // Player chooses Big or Small
            String choice = player.chooseOption(scanner);

            // Play the round and check the outcome
            boolean win = bigSmallGame.playRound(betAmount, choice);

            // Update player and house money based on the outcome
            if (win) {
                System.out.println("You won $" + betAmount + "!");
                player.setMoney(player.getMoney() + betAmount);
                house.setMoney(house.getMoney() - betAmount);
            } else {
                System.out.println("You lost $" + betAmount + "!");
                player.setMoney(player.getMoney() - betAmount);
                house.setMoney(house.getMoney() + betAmount);
            }

            System.out.println("House has $" + house.getMoney());
            System.out.println("Player has $" + player.getMoney());

            // Ask if the player wants to continue playing
            System.out.println("Do you still want to continue to play? (true/false)");
            continuePlaying = scanner.nextBoolean();
            round++;
        }

        // Determine the final winner
        if (player.getMoney() <= 0) {
            System.out.println("Player ran out of money! House wins!");
        } else if (house.getMoney() <= 0) {
            System.out.println("House ran out of money! Player wins!");
        }

        scanner.close();
    }
}
