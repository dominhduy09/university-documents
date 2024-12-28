// Write a function to input a list of integer numbers and return the median of that list.
// The median is the middle number in a sorted ascending or descending list. It can be more descriptive of the data set than the average.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
    }

    public static double median(int[] arr) {
        int n = arr.length;
        if (n % 2 == 0) {
            return (arr[n / 2] + arr[n / 2 - 1]) / 2.0;
        } else {
            return arr[n / 2];
        }
    }
}
