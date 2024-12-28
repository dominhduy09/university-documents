// QuickSort2App.java
// demonstrates quick sort with median-of-three partitioning
////////////////////////////////////////////////////////////////

class QuickSort2App {
    public static void main(String[] args) {
        int maxSize = 16; // array size
        ArrayIns2 arr; // reference to array
        arr = new ArrayIns2(maxSize); // create the array

        // Run 100 times for average comparisons, swaps, and recursive calls
        int totalComparisons = 0;
        int totalSwaps = 0;
        int totalRecCalls = 0;

        for (int run = 0; run < 100; run++) {
            // Fill array with random numbers
            for (int j = 0; j < maxSize; j++) {
                long n = (int) (Math.random() * 99);
                arr.insert(n);
            }

            // Run quicksort and count the number of operations
            arr.quickSort();

            // Accumulate the statistics for the current run
            totalComparisons += arr.getComparisons();
            totalSwaps += arr.getSwaps();
            totalRecCalls += arr.getRecursiveCalls();

            // Reset the array for the next run
            arr.clear();
        }

        // Display average values after 100 runs
        System.out.println("Average Comparisons: " + totalComparisons / 100.0);
        System.out.println("Average Swaps: " + totalSwaps / 100.0);
        System.out.println("Average Recursive Calls: " + totalRecCalls / 100.0);
    } // end main()
} // end class QuickSort2App

////////////////////////////////////////////////////////////////

class ArrayIns2 {
    private long[] theArray; // reference to array theArray
    private int nElems; // number of data items
    private int comparisons; // counter for comparisons
    private int swaps; // counter for swaps
    private int recursiveCalls; // counter for recursive calls

    // --------------------------------------------------------------
    public ArrayIns2(int max) {
        theArray = new long[max]; // create the array
        nElems = 0; // no items yet
        comparisons = 0; // initialize comparisons
        swaps = 0; // initialize swaps
        recursiveCalls = 0; // initialize recursive calls
    }

    // --------------------------------------------------------------
    public void insert(long value) {
        theArray[nElems] = value; // insert the element
        nElems++; // increment the size
    }

    // --------------------------------------------------------------
    public void display() {
        System.out.print("A=");
        for (int j = 0; j < nElems; j++) {
            System.out.print(theArray[j] + " ");
        }
        System.out.println("");
    }

    // --------------------------------------------------------------
    public void quickSort() {
        recursiveCalls++; // count initial recursive call
        recQuickSort(0, nElems - 1);
    }

    // --------------------------------------------------------------
    public void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3) {
            manualSort(left, right); // manual sort if small
        } else {
            long median = medianOf3(left, right); // get median of 3
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1); // left side
            recQuickSort(partition + 1, right); // right side
        }
    }

    // --------------------------------------------------------------
    public long medianOf3(int left, int right) {
        int center = (left + right) / 2;

        // Order left & center
        if (theArray[left] > theArray[center]) {
            swap(left, center);
        }

        // Order left & right
        if (theArray[left] > theArray[right]) {
            swap(left, right);
        }

        // Order center & right
        if (theArray[center] > theArray[right]) {
            swap(center, right);
        }

        swap(center, right - 1); // put pivot on right
        return theArray[right - 1]; // return median value
    }

    // --------------------------------------------------------------
    public void swap(int dex1, int dex2) {
        long temp = theArray[dex1]; // A into temp
        theArray[dex1] = theArray[dex2]; // B into A
        theArray[dex2] = temp; // temp into B
        swaps++; // increment swap counter
    }

    // --------------------------------------------------------------
    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left; // right of first element
        int rightPtr = right - 1; // left of pivot

        while (true) {
            while (theArray[++leftPtr] < pivot) {
                comparisons++; // increment comparisons
            }
            while (theArray[--rightPtr] > pivot) {
                comparisons++; // increment comparisons
            }
            if (leftPtr >= rightPtr) { // if pointers cross
                break; // partition done
            } else {
                swap(leftPtr, rightPtr); // swap elements
            }
        }
        swap(leftPtr, right - 1); // restore pivot
        return leftPtr; // return pivot location
    }

    // --------------------------------------------------------------
    public void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return; // no sort necessary
        if (size == 2) {
            if (theArray[left] > theArray[right]) {
                swap(left, right);
            }
            return;
        } else { // size is 3
            if (theArray[left] > theArray[right - 1]) {
                swap(left, right - 1); // left, center
            }
            if (theArray[left] > theArray[right]) {
                swap(left, right); // left, right
            }
            if (theArray[right - 1] > theArray[right]) {
                swap(right - 1, right); // center, right
            }
        }
    }

    // --------------------------------------------------------------
    // Reset array to clear data for the next run
    public void clear() {
        nElems = 0; // Reset number of elements
        comparisons = 0;
        swaps = 0;
        recursiveCalls = 0;
    }

    // --------------------------------------------------------------
    // Getters for the counters
    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }

    public int getRecursiveCalls() {
        return recursiveCalls;
    }
} // end class ArrayIns2
  ////////////////////////////////////////////////////////////////
