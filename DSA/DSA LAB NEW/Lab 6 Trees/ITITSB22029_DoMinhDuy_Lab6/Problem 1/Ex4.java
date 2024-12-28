// 4. Compute the average number of comparisons and swaps over 100 runs.
class ArrayPar {
    private long[] theArray; // reference to array theArray
    private int nElems; // number of data items
    private int compCount; // counter for comparisons
    private int swapCount; // counter for swaps

    // Constructor
    public ArrayPar(int max) {
        theArray = new long[max]; // create the array
        nElems = 0; // no items yet
        compCount = 0; // initialize comparison count
        swapCount = 0; // initialize swap count
    }

    // Insert an element into array
    public void insert(long value) {
        theArray[nElems] = value; // insert it
        nElems++; // increment size
    }

    // Return number of items
    public int size() {
        return nElems;
    }

    // Display array contents
    public void display() {
        System.out.print("A=");
        for (int j = 0; j < nElems; j++) {
            System.out.print(theArray[j] + " "); // display it
        }
        System.out.println("");
    }

    // Partition the array and count comparisons and swaps
    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1; // right of first element
        int rightPtr = right + 1; // left of pivot
        while (true) {
            // Find bigger item (increment comparisons counter)
            while (leftPtr < right && theArray[++leftPtr] < pivot) {
                compCount++; // Increment comparison counter
            }

            // Find smaller item (increment comparisons counter)
            while (rightPtr > left && theArray[--rightPtr] > pivot) {
                compCount++; // Increment comparison counter
            }

            if (leftPtr >= rightPtr) // If pointers cross, partition done
                break;
            else { // Swap elements
                swap(leftPtr, rightPtr); // Swap elements
                swapCount++; // Increment swap counter
            }
        }
        return leftPtr; // Return partition index
    }

    // Swap two elements
    public void swap(int dex1, int dex2) {
        long temp = theArray[dex1]; // A into temp
        theArray[dex1] = theArray[dex2]; // B into A
        theArray[dex2] = temp; // Temp into B
    }

    // Get the number of comparisons
    public int getCompCount() {
        return compCount;
    }

    // Get the number of swaps
    public int getSwapCount() {
        return swapCount;
    }

    // Reset comparison and swap counts for new tests
    public void resetCounters() {
        compCount = 0;
        swapCount = 0;
    }

    // Getter for theArray
    public long[] getArray() {
        return theArray;
    }
}

public class PartitionApp {
    public static void main(String[] args) {
        int maxSize = 16; // array size
        int runs = 100; // number of runs for average
        long totalComparisons = 0;
        long totalSwaps = 0;

        // Perform 100 runs to compute average comparisons and swaps
        for (int i = 0; i < runs; i++) {
            ArrayPar arr = new ArrayPar(maxSize); // reset array for each run

            // Fill array with random numbers
            for (int j = 0; j < maxSize; j++) {
                long n = (int) (java.lang.Math.random() * 199);
                arr.insert(n);
            }

            // Pivot selection strategy
            long pivot = arr.getArray()[0]; // First element as pivot
            // Uncomment one of the following lines for different pivot strategies
            // long pivot = arr.getArray()[arr.size() - 1]; // Last element as pivot
            // long pivot = arr.getArray()[arr.size() / 2]; // Middle element as pivot

            // Partition the array and get partition index
            arr.resetCounters(); // Reset comparison and swap counters for each run
            arr.partitionIt(0, arr.size() - 1, pivot);

            totalComparisons += arr.getCompCount();
            totalSwaps += arr.getSwapCount();
        }

        // Compute average comparisons and swaps
        double avgComparisons = totalComparisons / (double) runs;
        double avgSwaps = totalSwaps / (double) runs;

        System.out.println("Average number of comparisons over " + runs + " runs: " + avgComparisons);
        System.out.println("Average number of swaps over " + runs + " runs: " + avgSwaps);
    }
}
