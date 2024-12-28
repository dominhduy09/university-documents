// PartitionApp.java
// demonstrates partitioning an array
////////////////////////////////////////////////////////////////
// Exercises:
// 2. Investigate the relationship between the index of partitioning,
//    the number of comparison, and the number of swaps.
class ArrayPar {
    private long[] theArray; // reference to the array theArray
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

    // Getter for theArray to access it from outside
    public long[] getArray() {
        return theArray;
    }
}

public class PartitionApp {
    public static void main(String[] args) {
        int maxSize = 16; // Array size
        int runs = 100; // Number of runs for average
        long totalComparisons = 0;
        long totalSwaps = 0;

        // Perform multiple runs to collect data
        for (int i = 0; i < runs; i++) {
            ArrayPar arr = new ArrayPar(maxSize); // Reset array for each run

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

            // Partition the array and track comparisons and swaps
            arr.resetCounters(); // Reset comparison and swap counters for each run
            int partitionIndex = arr.partitionIt(0, arr.size() - 1, pivot);

            totalComparisons += arr.getCompCount();
            totalSwaps += arr.getSwapCount();

            // Print detailed information for investigation
            System.out.println("Run " + (i + 1) + ": ");
            System.out.println("Pivot = " + pivot);
            System.out.println("Partition Index = " + partitionIndex);
            System.out.println("Comparisons = " + arr.getCompCount());
            System.out.println("Swaps = " + arr.getSwapCount());
            System.out.println("Array after partition: ");
            arr.display();
            System.out.println();
        }

        // Compute average comparisons and swaps
        double avgComparisons = totalComparisons / (double) runs;
        double avgSwaps = totalSwaps / (double) runs;

        System.out.println("Average number of comparisons over " + runs + " runs: " + avgComparisons);
        System.out.println("Average number of swaps over " + runs + " runs: " + avgSwaps);
    }
}
