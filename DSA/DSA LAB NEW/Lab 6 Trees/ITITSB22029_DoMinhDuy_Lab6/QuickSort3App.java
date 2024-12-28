import java.util.Random;

class QuickSort {
   private long comparisons = 0;
   private long swaps = 0;

   public void quickSort(int[] array) {
      comparisons = 0;
      swaps = 0;
      recQuickSort(array, 0, array.length - 1);
   }

   private void recQuickSort(int[] array, int left, int right) {
      if (left >= right)
         return;
      int pivot = array[right];
      int partition = partitionIt(array, left, right, pivot);
      recQuickSort(array, left, partition - 1);
      recQuickSort(array, partition + 1, right);
   }

   private int partitionIt(int[] array, int left, int right, int pivot) {
      int leftPtr = left - 1;
      int rightPtr = right;
      while (true) {
         while (array[++leftPtr] < pivot)
            comparisons++;
         while (rightPtr > 0 && array[--rightPtr] > pivot)
            comparisons++;
         if (leftPtr >= rightPtr)
            break;
         swap(array, leftPtr, rightPtr);
      }
      swap(array, leftPtr, right);
      return leftPtr;
   }

   private void swap(int[] array, int dex1, int dex2) {
      int temp = array[dex1];
      array[dex1] = array[dex2];
      array[dex2] = temp;
      swaps++;
   }

   public void printMetrics(int size) {
      System.out.println("Quick Sort -> Size: " + size + ", Comparisons: " + comparisons + ", Swaps: " + swaps);
   }
}

public class QuickSort3App {
   public static void main(String[] args) {
      int[] sizes = { 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000 };
      Random rand = new Random();

      for (int size : sizes) {
         int[] data = new int[size];
         for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(100000); // Random integers
         }

         System.out.println("\nTesting for size: " + size);

         // Quick Sort
         int[] quickData = data.clone();
         QuickSort quickSort = new QuickSort();
         quickSort.quickSort(quickData);
         quickSort.printMetrics(size);

      }
   }
}