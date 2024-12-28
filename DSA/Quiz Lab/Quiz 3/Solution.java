//  Problem A. Queue using Two Stacks

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Print
    public int front() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution queue = new Solution();
        int q = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int queryType = scanner.nextInt();
            switch (queryType) {
                case 1:
                    int x = scanner.nextInt();
                    queue.enqueue(x);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    output.append(queue.front()).append("\n");
                    break;
            }
        }

        System.out.println(output.toString());
        scanner.close();
    }
}
