class ArrayBub {
   private long[] a; // ref to array a
   private int nElems; // number of data items
   private int nSwaps; // number of swaps
   private int nComparisons; // number of comparisons
   // --------------------------------------------------------------

   public ArrayBub(int max) // constructor
   {
      a = new long[max]; // create the array
      nElems = 0; // no items yet
      nSwaps = 0; // no swaps yet
      nComparisons = 0; // no comparisons yet
   }

   // --------------------------------------------------------------
   public void insert(long value) // put element into array
   {
      a[nElems] = value; // insert it
      nElems++; // increment size
   }

   // --------------------------------------------------------------
   public void display() // displays array contents
   {
      for (int j = 0; j < nElems; j++) // for each element,
         System.out.print(a[j] + " "); // display it
      System.out.println("");
   }

   // --------------------------------------------------------------
   public void bubbleSort() {
      int out, in;

      for (out = nElems - 1; out > 0; out--) { // outer loop (backward)
         System.out.println("Outer loop at index " + out + ":");
         for (in = 0; in < out; in++) { // inner loop (forward)
            nComparisons++; // increment number of comparisons
            if (a[in] > a[in + 1]) // out of order?
               swap(in, in + 1); // swap them
         }
         display(); // display array after each outer loop
         System.out.println("Number of swaps so far: " + nSwaps);
         System.out.println("Number of comparisons so far: " + nComparisons);
      }
      System.out.println("Total comparisons made: " + nComparisons);
   } // end bubbleSort()
     // --------------------------------------------------------------

   private void swap(int one, int two) {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;

      nSwaps++; // increase number of swaps by 1
   }

   public int getSwapNumber() {
      return nSwaps;
   }

   public int getComparisonNumber() {
      return nComparisons;
   }
   // --------------------------------------------------------------
} // end class ArrayBub
  ////////////////////////////////////////////////////////////////

class BubbleSortApp {
   public static void main(String[] args) {
      int maxSize = 100; // array size
      ArrayBub arr; // reference to array
      arr = new ArrayBub(maxSize); // create the array

      arr.insert(77); // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display(); // display items before sorting

      arr.bubbleSort(); // bubble sort them

      arr.display(); // display items after sorting

      // display the number of swaps and comparisons
      System.out.println("The number of swaps = " + arr.getSwapNumber());
      System.out.println("The total number of comparisons = " + arr.getComparisonNumber());

      // The algorithm complexity estimation
      int n = arr.getComparisonNumber();
      System.out.println("Estimated complexity (n*(n-1)/2): " + n * (n - 1) / 2);
      System.out.println("The algorithm has O(n^2) complexity.");
   } // end main()
} // end class BubbleSortApp
  ////////////////////////////////////////////////////////////////
