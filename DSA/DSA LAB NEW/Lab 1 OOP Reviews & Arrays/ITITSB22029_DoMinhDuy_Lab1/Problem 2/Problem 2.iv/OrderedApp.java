import java.util.Random;

// OrderedArray.java
// demonstrates ordered array class

class OrderedArray {
    long[] a; // ref to array a
    private int nElems; // number of data items
    private int comparisons; // counter for comparisons

    public OrderedArray(int max) // constructor
    {
        a = new long[max]; // create array
        nElems = 0;
        comparisons = 0;
    }

    public int size() {
        return nElems;
    }

    public int getComparisons() {
        return comparisons;
    }

    public void resetComparisons() {
        comparisons = 0;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        comparisons = 0;
        while (true) {
            comparisons++;
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn; // found it
            else if (lowerBound > upperBound)
                return nElems; // can’t find it
            else // divide range
            {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1; // it’s in upper half
                else
                    upperBound = curIn - 1; // it’s in lower half
            } // end else divide range
        } // end while
    } // end find()

    public void insert(long value) // put element into array
    {
        int j;
        for (j = 0; j < nElems; j++) // find where it goes
            if (a[j] > value) // (linear search)
                break;
        for (int k = nElems; k > j; k--) // move bigger ones up
            a[k] = a[k - 1];
        a[j] = value; // insert it
        nElems++; // increment size
    } // end insert()
}

public class OrderedApp {
    public static void main(String[] args) {
        Random rand = new Random();
        int maxSize = 1000;
        int trials = 100;

        for (int size = 100; size <= maxSize; size += 100) {
            OrderedArray arr = new OrderedArray(size);

            // Insert random items
            for (int i = 0; i < size; i++) {
                arr.insert(rand.nextInt(10000));
            }

            // Compute average comparisons over 100 trials
            long totalComparisons = 0;
            for (int t = 0; t < trials; t++) {
                long searchKey = arr.a[rand.nextInt(size)];
                arr.find(searchKey);
                totalComparisons += arr.getComparisons();
            }

            double averageComparisons = (double) totalComparisons / trials;
            System.out.println("Average comparisons for size " + size + ": " + averageComparisons);
        }
    }
}
