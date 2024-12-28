// PartitionApp.java
// demonstrates partitioning an array
////////////////////////////////////////////////////////////////
// Exercises:
// 1. Add counters for the number of comparisons and swaps and display
//    them after partitioning

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
}

public class PartitionApp {
    public static void main(String[] args) {
        int maxSize = 16; // array size
        ArrayPar arr; // reference to array
        arr = new ArrayPar(maxSize); // create the array

        // Fill array with random numbers
        for (int j = 0; j < maxSize; j++) {
            long n = (int) (java.lang.Math.random() * 199);
            arr.insert(n);
        }
        arr.display(); // Display unsorted array

        long pivot = 99; // pivot value
        System.out.print("Pivot is " + pivot);
        int size = arr.size();

        // Partition the array
        int partDex = arr.partitionIt(0, size - 1, pivot);

        System.out.println(", Partition is at index " + partDex);
        arr.display(); // Display partitioned array

        // Display the number of comparisons and swaps
        System.out.println("Number of comparisons: " + arr.getCompCount());
        System.out.println("Number of swaps: " + arr.getSwapCount());
    } // end main()
} // end class PartitionApp
