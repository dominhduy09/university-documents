public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        long expectedSum = (long) N * (N + 1) / 2;

        long actualSum = 0;
        for (int i = 0; i < N - 1; i++) {
            actualSum += scanner.nextInt();
        }

        long missingNumber = expectedSum - actualSum;

        System.out.println(missingNumber);

    }
}