import java.util.Random;

// HighArray.java
// demonstrates array class with high-level interface
/////

public class HighArray {
    private long[] a;
    private int nElems;
    private int comparisons;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
        comparisons = 0;
    }

    public boolean find(long searchKey) {
        comparisons = 0;
        int j;
        for (j = 0; j < nElems; j++) {
            comparisons++;
            if (a[j] == searchKey) {
                break;
            }
        }
        return j != nElems;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (value == a[j]) {
                break;
            }
        }

        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems - 1; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
            return true;
        }
    }

    public long getMax() {
        if (nElems == 0) {
            return -1;
        }
        long max = a[0];
        for (int i = 1; i < nElems; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public void noDups() {
        for (int i = 0; i < nElems; i++) {
            for (int j = i + 1; j < nElems; j++) {
                if (a[i] == a[j]) {
                    a[j] = -1; // Mark duplicate with -1
                }
            }
        }
        int newSize = 0;
        for (int i = 0; i < nElems; i++) {
            if (a[i] != -1) {
                a[newSize++] = a[i];
            }
        }
        nElems = newSize;
    }

    public int getComparisons() {
        return comparisons;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        HighArray arr = new HighArray(1000);

        // Insert 100 random items
        for (int i = 0; i < 100; i++) {
            arr.insert(rand.nextInt(1000));
        }

        // Find a random item and print the number of comparisons
        long searchKey = arr.a[rand.nextInt(100)];
        arr.find(searchKey);
        System.out.println("Comparisons to find " + searchKey + ": " + arr.getComparisons());

        // Compute and print the average number of comparisons over 100 trials
        int totalComparisons = 0;
        for (int i = 0; i < 100; i++) {
            searchKey = arr.a[rand.nextInt(100)];
            arr.find(searchKey);
            totalComparisons += arr.getComparisons();
        }
        System.out.println("Average comparisons over 100 trials: " + (totalComparisons / 100.0));

        // Print the average number of comparisons for arrays with sizes 100, 200, ...,
        // 1000
        for (int size = 100; size <= 1000; size += 100) {
            arr = new HighArray(size);
            for (int i = 0; i < size; i++) {
                arr.insert(rand.nextInt(1000));
            }
            totalComparisons = 0;
            for (int i = 0; i < 100; i++) {
                searchKey = arr.a[rand.nextInt(size)];
                arr.find(searchKey);
                totalComparisons += arr.getComparisons();
            }
            System.out.println("Average comparisons for size " + size + ": " + (totalComparisons / 100.0));
        }
    }
}
