import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static final long MOD = 1000000007;

    static long solve(int N, int X, List<Long> coins) {
        long[] dp = new long[X + 1];
        Arrays.fill(dp, 0);

        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = coins.get(i).intValue(); j <= X; j++) {
                dp[j] = (dp[j] + dp[j - coins.get(i).intValue()]) % MOD;
            }
        }

        return dp[X];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int X = scanner.nextInt();

        List<Long> coins = Arrays.stream(new long[N])
                .mapToObj(i -> scanner.nextLong())
                .collect(Collectors.toList());
        scanner.close();
        System.out.println(solve(N, X, coins));
    }
}
