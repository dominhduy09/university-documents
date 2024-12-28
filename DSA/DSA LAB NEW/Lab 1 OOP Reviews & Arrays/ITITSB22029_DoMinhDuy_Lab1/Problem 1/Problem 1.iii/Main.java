// Find the min-gap (10pts)
// Write a method named minGap that accepts an integer array and a number of
// elements as parameters and
// returns the minimum 'gap' between adjacent values in the array. The gap
// between two adjacent values in an
// array is defined as the second value minus the first value.
// For example, suppose a variable called array is an array of integers that
// stores the following sequence of
// values:
// int[] array = {1, 3, 6, 7, 12};
// The first gap is 2 (3 - 1), the second gap is 3 (6 - 3), the third gap is 1
// (7 - 6) and the fourth gap is 5 (12 - 7).
// Thus, the call of minGap(array, n) should return 1 because that is the
// smallest gap in the array. If you are
// passed an array with fewer than 2 elements, you should return 0.

public class Main {
    public static void main(String[] args) {
        int[] array = { 1, 3, 6, 7, 12 };
        System.out.println(minGap(array, 5));
    }

    public static int minGap(int[] array, int n) {
        if (n < 2) {
            return 0;
        }
        int min = array[1] - array[0];
        for (int i = 1; i < n - 1; i++) {
            if (array[i + 1] - array[i] < min) {
                min = array[i + 1] - array[i];
            }
        }
        return min;
    }
}