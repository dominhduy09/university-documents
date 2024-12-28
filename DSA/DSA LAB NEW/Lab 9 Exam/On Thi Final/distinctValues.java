import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        HashSet<Integer> distinctValues = new HashSet<>();

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < input;i++) {
            int number = scanner.nextInt();
            distinctValues.add(number);
        }
        System.out.println(distinctValues.size());        
    }
}

        

