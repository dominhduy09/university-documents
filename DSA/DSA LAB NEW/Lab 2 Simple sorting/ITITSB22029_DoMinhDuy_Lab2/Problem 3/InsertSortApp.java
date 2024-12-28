class ArrayIns {
   private long[] a; // ref to array a
   private int nElems; // number of data items
   private int innerLoopPasses; // number of passes of the inner loop
   private int totalPasses; // total number of passes

   // --------------------------------------------------------------
   public ArrayIns(int max) { // constructor
      a = new long[max]; // create the array
      nElems = 0; // no items yet
      innerLoopPasses = 0; // initialize inner loop passes to 0
      totalPasses = 0; // initialize total passes to 0
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
   public void insertionSort() {
      int in, out;

      for (out = 1; out < nElems; out++) { // outer loop (out is dividing line)
         long temp = a[out]; // remove marked item
         in = out; // start shifts at out
         innerLoopPasses = 0; // reset inner loop passes for this iteration

         // Inner loop: shift items to the right until the right spot is found
         while (in > 0 && a[in - 1] >= temp) { // until one is smaller,
            a[in] = a[in - 1]; // shift item to the right
            --in; // go left one position
            innerLoopPasses++; // increment inner loop passes
         }

         a[in] = temp; // insert marked item
         totalPasses += innerLoopPasses; // accumulate total passes

         // Display the array after each pass of the outer loop
         System.out.println("After pass " + out + ":");
         display();
         System.out.println("Inner loop passes for this pass: " + innerLoopPasses);
      }

      System.out.println("Total inner loop passes: " + totalPasses);
   }

   public int getTotalPasses() {
      return totalPasses;
   }
}

////////////////////////////////////////////////////////////////

class InsertSortApp {
   public static void main(String[] args) {
      int maxSize = 100; // array size
      ArrayIns arr; // reference to array
      arr = new ArrayIns(maxSize); // create the array

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

      arr.insertionSort(); // insertion-sort them

      arr.display(); // display them again

      // Estimate the algorithm's complexity
      int n = 10; // number of elements inserted
      System.out.println("Estimated complexity (n*(n-1)/4): " + n * (n - 1) / 4);
      System.out.println("The algorithm has O(n^2) complexity.");
   }
}
