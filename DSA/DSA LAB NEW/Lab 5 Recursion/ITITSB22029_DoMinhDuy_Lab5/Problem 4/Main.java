public class Main {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 3, 1 };
        int n = arr.length;

        // Find the minimum value
        System.out.println("Minimum value: " + findmin(arr, n));

        // Find the sum of values
        System.out.println("Sum of values: " + findsum(arr, n));
    }

    // Recursive function to find the minimum element in an array
    public static int findmin(int a[], int n) {
        if (n == 1) {
            return a[0]; // If there's only one element, it's the minimum
        }
        int minOfRest = findmin(a, n - 1); // Find the minimum of the rest
        return Math.min(a[n - 1], minOfRest); // Return the smaller of the current element and the min of the rest
    }

    // Recursive function to find the sum of elements in an array
    public static int findsum(int a[], int n) {
        if (n == 1) {
            return a[0]; // If there's only one element, its value is the sum
        }
        return a[n - 1] + findsum(a, n - 1); // Add the current element to the sum of the rest
    }

}
