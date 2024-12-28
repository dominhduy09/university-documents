// B - New Year and Hurry
// Limak is going to participate in a contest on the last day of the 2016. The contest will start at 20:00 and will last four hours, exactly until midnight. There will be n problems, sorted by difficulty, i.e. problem 1 is the easiest and problem n is the hardest. Limak knows it will take him 5·i minutes to solve the i-th problem.

// Limak's friends organize a New Year's Eve party and Limak wants to be there at midnight or earlier. He needs k minutes to get there from his house, where he will participate in the contest first.

// How many problems can Limak solve if he wants to make it to the party?

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // number of problems
        int k = scanner.nextInt(); // minutes

        int totalTime = 240; // 4 hours = 240 minutes
        int timeAvailableForProblems = totalTime - k;

        int timeSpent = 0;
        int problemsSolved = 0;

        for (int i = 1; i <= n; i++) {
            int timeToSolve = 5 * i;
            if (timeSpent + timeToSolve <= timeAvailableForProblems) {
                timeSpent += timeToSolve;
                problemsSolved++;
            } else {
                break;
            }
        }

        System.out.println(problemsSolved);

        scanner.close();
    }
}
