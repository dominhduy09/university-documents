class ArraySel {
   private long[] a; // reference to array a
   private int nElems; // number of data items
   private int nComparisons; // number of comparisons
   private int nSwaps; // number of swaps

   // --------------------------------------------------------------
   public ArraySel(int max) {
      a = new long[max]; // create the array
      nElems = 0; // no items yet
      nComparisons = 0; // initialize comparisons to 0
      nSwaps = 0; // initialize swaps to 0
   }

   // --------------------------------------------------------------
   public void insert(long value) { // put element into array
      a[nElems] = value; // insert it
      nElems++; // increment size
   }

   // --------------------------------------------------------------
   public void display() { // displays array contents
      for (int j = 0; j < nElems; j++) // for each element,
         System.out.print(a[j] + " "); // display it
      System.out.println("");
   }

   // --------------------------------------------------------------
   public void selectionSort() {
      int out, in, min;

      for (out = 0; out < nElems - 1; out++) { // outer loop
         min = out; // minimum element starts as out
         for (in = out + 1; in < nElems; in++) { // inner loop
            nComparisons++; // increment comparisons counter
            if (a[in] < a[min]) { // if min is greater,
               min = in; // we have a new min
            }
         }
         // Display the array after each inner loop
         System.out.println("After inner loop " + out + ": ");
         display();

         if (min != out) { // swap only if necessary
            swap(out, min); // swap them
            System.out.println("Swapping " + a[min] + " and " + a[out]);
         } else {
            System.out.println("No swap needed for index " + out);
         }
         System.out.println("Number of comparisons so far: " + nComparisons);
         System.out.println("Number of swaps so far: " + nSwaps);
      }
      System.out.println("Total comparisons made: " + nComparisons);
   }

   // --------------------------------------------------------------
   private void swap(int one, int two) {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
      nSwaps++; // increment swap counter
   }

   public int getComparisonNumber() {
      return nComparisons;
   }

   public int getSwapNumber() {
      return nSwaps;
   }

   // --------------------------------------------------------------
} // end class ArraySel

////////////////////////////////////////////////////////////////

class SelectSortApp {
   public static void main(String[] args) {
      int maxSize = 100; // array size
      ArraySel arr; // reference to array
      arr = new ArraySel(maxSize); // create the array

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

      arr.display(); // display items

      arr.selectionSort(); // selection-sort them

      arr.display(); // display them again

      // display the number of swaps and comparisons
      System.out.println("The number of swaps = " + arr.getSwapNumber());
      System.out.println("The total number of comparisons = " + arr.getComparisonNumber());

      // The algorithm complexity estimation
      int n = arr.getComparisonNumber();
      System.out.println("Estimated complexity (n*(n-1)/2): " + n * (n - 1) / 2);
      System.out.println("The algorithm has O(n^2) complexity.");
   }
} // end class SelectSortApp
