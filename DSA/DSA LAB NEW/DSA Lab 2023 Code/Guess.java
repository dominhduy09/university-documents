/*
 * Gussing game (do loop)
 * Suggested exercises:
 * - Change the range of numbers. What is the optimal strategy?
 * - Include a counter to count the number of guesses.
 * - Change the do-loop with a while-loop.
 */
import java.util.Scanner;
import java.util.Random;

public class Guess
{
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
        int number = generator.nextInt(10) + 1;
        int guess;
        
        do
        {
            System.out.print("Enter a number [1,10]: ");
            guess = scan.nextInt();
            if (guess < number) System.out.println("Higher");
            if (guess > number) System.out.println("Lower");
        }
        while (guess != number);
        
        System.out.println("You guessed. Congratulations!");

    }
}
