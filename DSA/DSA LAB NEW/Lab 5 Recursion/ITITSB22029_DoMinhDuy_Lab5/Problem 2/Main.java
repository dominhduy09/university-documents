public class Main {
    public static void main(String[] args) {
        System.out.print(sum(10));
        System.out.print("\n");
        System.out.print(sum(3));
        System.out.print("\n");
        System.out.print(sum(1));
        System.out.print("\n");
    }

    public static double sum(int n)
    // n >= 1
    {
        if (n == 1) // base case
            return 1; // when n is 1, return 1
        return 1.0 / n + sum(n - 1); // recursive case: 1/n + sum of previous terms
    }

}
