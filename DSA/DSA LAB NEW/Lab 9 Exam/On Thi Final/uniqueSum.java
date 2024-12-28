import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        
        String[] weightsInput = scanner.nextLine().split(" ");
        int[] weights = new int[weightsInput.length];
        for (int i = 0; i < weightsInput.length; i++) {
            weights[i] = Integer.parseInt(weightsInput[i]);
        }

        int target = scanner.nextInt();

        System.out.println(countCombinations(weights, target));
    }

    public static int countCombinations(int[] weights, int target) {
        return count(weights, target, 0);
    }

    private static int count(int[] weights, int target, int start) {
        if (target == 0) {
            return 1; 
        }
        
        if (target < 0) {
            return 0; 
        }

        int totalCount = 0;
        for (int i = start; i < weights.length; i++) {
            totalCount += count(weights, target - weights[i], i + 1); // Explore further
        }
        return totalCount;
    }
}