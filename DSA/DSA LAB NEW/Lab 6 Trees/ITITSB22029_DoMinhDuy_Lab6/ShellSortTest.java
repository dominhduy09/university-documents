import java.util.Random;

class ShellSort {
    private long comparisons = 0;
    private long swaps = 0;

    public void shellSort(int[] array) {
        comparisons = 0;
        swaps = 0;
        int h = 1;
        while (h <= array.length / 3)
            h = h * 3 + 1;

        while (h > 0) {
            for (int outer = h; outer < array.length; outer++) {
                int temp = array[outer];
                int inner = outer;

                while (inner > h - 1 && array[inner - h] >= temp) {
                    comparisons++;
                    array[inner] = array[inner - h];
                    swaps++;
                    inner -= h;
                }
                array[inner] = temp;
                swaps++;
            }
            h = (h - 1) / 3;
        }
    }

    public void printMetrics(int size) {
        System.out.println("Shell Sort -> Size: " + size + ", Comparisons: " + comparisons + ", Swaps: " + swaps);
    }
}

// Test Runner
public class ShellSortTest {
    public static void main(String[] args) {
        int[] sizes = { 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000 };
        Random rand = new Random();

        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(100000); // Random integers
            }

            System.out.println("\nTesting for size: " + size);

            // Shell Sort
            int[] shellData = data.clone();
            ShellSort shellSort = new ShellSort();
            shellSort.shellSort(shellData);
            shellSort.printMetrics(size);
        }
    }
}