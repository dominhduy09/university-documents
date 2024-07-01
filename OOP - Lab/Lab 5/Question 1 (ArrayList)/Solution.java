import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */

        Scanner scanner = new Scanner(System.in);

        // First line input the length of List
        int N = scanner.nextInt();

        List<Integer> L = new ArrayList<Integer>(N);

        for (int i = 0; i < N; i++) {
            L.add(scanner.nextInt());
        }

        int Q = scanner.nextInt();
        // System.out.println("Queries: " + Integer.toString(Q));

        for (int i = 0; i < Q; i++) {
            String operation = scanner.next();
            // System.out.println("Current operation is: " + operation);

            if (operation.equals("Insert")) {
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                // System.out.println("Inserting element: " + Integer.toString(value) + " into
                // index: " + Integer.toString(index));
                L.add(index, value);
            }

            else if (operation.equals("Delete")) {
                int index = scanner.nextInt();
                // System.out.println("Removing element at index: " + Integer.toString(index));
                L.remove(index);
            }
        }

        for (int element : L)

        {
            System.out.print(element + " ");
        }

    }
}