public class GCD {
    // Method to calculate the greatest common divisor (GCD)
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p; // Base case: if q is 0, return p
        } else {
            return gcd(q, p % q); // Recursive call with q and p % q
        }
    }

    public static void main(String[] args) {
        int num1 = 56;
        int num2 = 98;

        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd(num1, num2));
    }
}
