import java.util.Random;

class ArraySortTracker {
    private long[] a;
    private int nElems;
    private int comparisons;
    private int copies;
    private int swaps;

    public ArraySortTracker(int max) {
        a = new long[max];
        nElems = 0;
        comparisons = 0;
        copies = 0;
        swaps = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void fillRandom(int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            insert(rand.nextInt(100000)); // Random numbers up to 100000
        }
    }

    public void resetCounters() {
        comparisons = 0;
        copies = 0;
        swaps = 0;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }

    public void bubbleSort() {
        int out, in;
        resetCounters(); // Reset metrics before sorting

        for (out = nElems - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                comparisons++; // Count comparison
                if (a[in] > a[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }

        System.out.println("Bubble Sort - Comparisons: " + comparisons + ", Swaps: " + swaps);
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
        swaps++;
        copies += 3; // One swap involves 3 copies
    }

    public void selectionSort() {
        int out, in, min;
        resetCounters(); // Reset metrics before sorting

        for (out = 0; out < nElems - 1; out++) {
            min = out;
            for (in = out + 1; in < nElems; in++) {
                comparisons++;
                if (a[in] < a[min]) {
                    min = in;
                }
            }
            if (out != min) {
                swap(out, min);
            }
        }

        System.out.println("Selection Sort - Comparisons: " + comparisons + ", Swaps: " + swaps);
    }

    public void insertionSort() {
        int in, out;
        resetCounters(); // Reset metrics before sorting

        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                comparisons++;
                a[in] = a[in - 1];
                in--;
                copies++; // Each shift is a copy
            }
            a[in] = temp;
            copies++; // Insert temp back into array
        }

        System.out.println("Insertion Sort - Comparisons: " + comparisons + ", Copies: " + copies);
    }
}

public class SortAnalysis {
    public static void main(String[] args) {
        int[] sizes = {10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};

        for (int size : sizes) {
            ArraySortTracker arr = new ArraySortTracker(size);
            arr.fillRandom(size);
            
            System.out.println("\nArray size: " + size);
            arr.bubbleSort();
            arr.selectionSort();
            arr.insertionSort();
        }
    }
}
