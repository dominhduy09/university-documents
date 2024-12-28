// Problem 1: Simple stack application
// Convert a decimal number and convert it to octal form.
// Concatenate two stacks.
// Determine if the contents of one stack are identical to that of another.

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // Create a stack
        Stack<Integer> stack = new Stack<>();

        // Push elements to the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("Stack: " + stack);

        // Convert the decimal number to octal
        int decimal = 18;
        System.out.println("Decimal: " + decimal);
        System.out.println("Octal: " + Integer.toOctalString(decimal));

        // Concatenate two stacks
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(10);
        stack1.push(20);
        stack1.push(30);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(40);
        stack2.push(50);

        stack1.addAll(stack2);
        System.out.println("Concatenated stack: " + stack1);

        // Determine if the contents of one stack are identical to that of another
        Stack<Integer> stack3 = new Stack<>();
        stack3.push(10);
        stack3.push(20);
        stack3.push(30);

        Stack<Integer> stack4 = new Stack<>();
        stack4.push(10);
        stack4.push(20);
        stack4.push(30);

        System.out.println("Stack 3: " + stack3);
        System.out.println("Stack 4: " + stack4);
        System.out.println("Are the stacks identical? " + stack3.equals(stack4));
    }
}