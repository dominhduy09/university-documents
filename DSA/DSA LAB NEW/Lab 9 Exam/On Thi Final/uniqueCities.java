
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int E = scanner.nextInt();
            Set<Integer> uniqueCities = new HashSet<>();

            for (int e = 0; e < E; e++) {
                int cityX = scanner.nextInt();
                int cityY = scanner.nextInt();
                uniqueCities.add(cityX);
                uniqueCities.add(cityY);
            }

            System.out.println(uniqueCities.size());
        }
    }
}