import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;

public class SolutionB {

    static class Job {
        int priority;
        int index;

        Job(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        ArrayList<Integer> results = new ArrayList<>(); // Store results to print later

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Queue<Job> queue = new LinkedList<>();
            int[] priorities = new int[n];

            for (int i = 0; i < n; i++) {
                int priority = sc.nextInt();
                queue.offer(new Job(priority, i));
                priorities[i] = priority;
            }

            java.util.Arrays.sort(priorities);
            int maxPriorityIndex = n - 1; // Start with the highest priority

            int time = 0;

            while (!queue.isEmpty()) {
                Job current = queue.poll();

                if (current.priority == priorities[maxPriorityIndex]) {
                    time++; // Print this job
                    maxPriorityIndex--; // Move to the next highest priority

                    if (current.index == m) {
                        results.add(time); // Add the result to the list
                        break;
                    }
                } else {
                    queue.offer(current);
                }
            }
        }
        sc.close();

        // Print all results at once
        for (int result : results) {
            System.out.println(result);
        }
    }
}
