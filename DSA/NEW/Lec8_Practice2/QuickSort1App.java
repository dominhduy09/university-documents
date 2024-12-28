class QuickSort1App {
   public static void main(String[] args) {
      int maxSize = 16; // array size
      int runs = 100; // number of runs
      long totalComparisons = 0;
      long totalSwaps = 0;
      long totalRecursiveCalls = 0;

      // Run quick sort 100 times
      for (int i = 0; i < runs; i++) {
         ArrayIns1 arr = new ArrayIns1(maxSize); // create array for each run

         // Fill array with random numbers
         for (int j = 0; j < maxSize; j++) {
            long n = (int) (java.lang.Math.random() * 99);
            arr.insert(n);
         }

         arr.quickSort(); // Perform quick sort

         // Accumulate the counts
         totalComparisons += arr.getCompareCount();
         totalSwaps += arr.getSwapCount();
         totalRecursiveCalls += arr.getRecursiveCallCount();
      }

      // Compute averages
      double avgComparisons = totalComparisons / (double) runs;
      double avgSwaps = totalSwaps / (double) runs;
      double avgRecursiveCalls = totalRecursiveCalls / (double) runs;

      // Display averages
      System.out.println("Average Comparisons: " + avgComparisons);
      System.out.println("Average Swaps: " + avgSwaps);
      System.out.println("Average Recursive Calls: " + avgRecursiveCalls);
   }
}

class ArrayIns1 {
   private long[] theArray; // ref to array theArray
   private int nElems; // number of data items
   private int compareCount; // number of comparisons
   private int swapCount; // number of swaps
   private int recursiveCallCount; // number of recursive calls

   // --------------------------------------------------------------
   public ArrayIns1(int max) { // constructor
      theArray = new long[max]; // create the array
      nElems = 0; // no items yet
      compareCount = 0; // no comparisons yet
      swapCount = 0; // no swaps yet
      recursiveCallCount = 0; // no recursive calls yet
   }

   // --------------------------------------------------------------
   public void insert(long value) { // put element into array
      theArray[nElems] = value; // insert it
      nElems++; // increment size
   }

   // --------------------------------------------------------------
   public void quickSort() {
      recQuickSort(0, nElems - 1);
   }

   // --------------------------------------------------------------
   public void recQuickSort(int left, int right) {
      recursiveCallCount++; // count this recursive call
      if (right - left <= 0) // if size <= 1,
         return; // already sorted
      else { // size is 2 or larger
         long pivot = theArray[right]; // rightmost item
         int partition = partitionIt(left, right, pivot);
         recQuickSort(left, partition - 1); // sort left side
         recQuickSort(partition + 1, right); // sort right side
      }
   } // end recQuickSort()
   // --------------------------------------------------------------

   public int partitionIt(int left, int right, long pivot) {
      int leftPtr = left - 1; // left (after ++)
      int rightPtr = right; // right-1 (after --)
      while (true) {
         // find bigger item
         while (theArray[++leftPtr] < pivot)
            ; // (nop)

         // find smaller item
         while (rightPtr > 0 && theArray[--rightPtr] > pivot)
            ; // (nop)

         if (leftPtr >= rightPtr) // if pointers cross,
            break; // partition done
         else // not crossed, so
            swap(leftPtr, rightPtr); // swap elements
      } // end while(true)
      swap(leftPtr, right); // restore pivot
      return leftPtr; // return pivot location
   } // end partitionIt()
   // --------------------------------------------------------------

   public void swap(int dex1, int dex2) { // swap two elements
      long temp = theArray[dex1]; // A into temp
      theArray[dex1] = theArray[dex2]; // B into A
      theArray[dex2] = temp; // temp into B
      swapCount++; // increment swap counter
   } // end swap()

   // --------------------------------------------------------------
   public void displayCounters() {
      System.out.println("Comparisons: " + compareCount);
      System.out.println("Swaps: " + swapCount);
      System.out.println("Recursive calls: " + recursiveCallCount);
   } // end displayCounters()

   // --------------------------------------------------------------
   // Getter methods for counters
   public int getCompareCount() {
      return compareCount;
   }

   public int getSwapCount() {
      return swapCount;
   }

   public int getRecursiveCallCount() {
      return recursiveCallCount;
   }
} // end class ArrayIns1
