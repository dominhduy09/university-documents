import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Read the number of test cases
        scanner.nextLine(); // Consume the newline after the integer input

        // Loop through each test case
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine(); // Read each string
            // Call the function to check if the brackets are balanced
            if (isBalanced(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    // Function to check if the input string has balanced brackets
    public static boolean isBalanced(String s) {
        Stack<Character> stk = new Stack<>();

        // Iterate over each character of the string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Check for opening brackets '{', '[', '('
            if (currentChar == '{' || currentChar == '[' || currentChar == '(') {
                stk.push(currentChar);
            } 
            // Check for closing brackets '}', ']', ')'
            else if (currentChar == '}' || currentChar == ']' || currentChar == ')') {
                // If stack is empty or top doesn't match the closing bracket, return false
                if (stk.isEmpty()) {
                    return false;
                }

                char top = stk.peek();
                if ((currentChar == '}' && top == '{') || 
                    (currentChar == ']' && top == '[') || 
                    (currentChar == ')' && top == '(')) {
                    stk.pop(); // Pop the matching opening bracket
                } else {
                    return false; // Unmatched closing bracket
                }
            }
        }

        // If stack is empty, all brackets are balanced
        return stk.isEmpty();
    }
}
