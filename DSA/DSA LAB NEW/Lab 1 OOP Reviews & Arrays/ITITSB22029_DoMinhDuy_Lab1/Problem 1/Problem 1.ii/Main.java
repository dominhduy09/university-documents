// Write a function to input a list of integer numbers from users and return the
// median of that list.
// Median Example
// For the data set 1, 1, 2, 5, 6, 6, 9 the median is 5.
// For the data set 1, 1, 2, 6, 6, 9 the median is 4. Take the mean of 2 and 6
// or, (2+6)/2 = 4.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();
    System.out.println("Enter the number of elements in the list: ");
    int n = scanner.nextInt();
    System.out.println("Enter the elements of the list: ");
    for (int i = 0; i < n; i++) {
      list.add(scanner.nextInt());
    }
    System.out.println("The median of the list is: " + findMedian(list));
  }

  public static double findMedian(ArrayList<Integer> list) {
    Collections.sort(list);
    int n = list.size();
    if (n % 2 == 0) {
      return (list.get(n / 2) + list.get(n / 2 - 1)) / 2.0;
    } else {
      return list.get(n / 2);
    }
  }
}
