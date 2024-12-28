import java.util.Random;

class MergeSort {
   private long comparisons = 0;
   private long copies = 0;

   public void mergeSort(int[] array) {
      int[] workspace = new int[array.length];
      comparisons = 0;
      copies = 0;
      recMergeSort(array, workspace, 0, array.length - 1);
   }

   private void recMergeSort(int[] array, int[] workspace, int lowerBound, int upperBound) {
      if (lowerBound == upperBound)
         return;
      int mid = (lowerBound + upperBound) / 2;
      recMergeSort(array, workspace, lowerBound, mid);
      recMergeSort(array, workspace, mid + 1, upperBound);
      merge(array, workspace, lowerBound, mid + 1, upperBound);
   }

   private void merge(int[] array, int[] workspace, int lowPtr, int highPtr, int upperBound) {
      int lowerBound = lowPtr, mid = highPtr - 1, j = 0;
      int n = upperBound - lowerBound + 1;

      while (lowPtr <= mid && highPtr <= upperBound) {
         comparisons++;
         if (array[lowPtr] < array[highPtr]) {
            workspace[j++] = array[lowPtr++];
            copies++;
         } else {
            workspace[j++] = array[highPtr++];
            copies++;
         }
      }

      while (lowPtr <= mid) {
         workspace[j++] = array[lowPtr++];
         copies++;
      }

      while (highPtr <= upperBound) {
         workspace[j++] = array[highPtr++];
         copies++;
      }

      System.arraycopy(workspace, 0, array, lowerBound, n);
      copies += n;
   }

   public void printMetrics(int size) {
      System.out.println("Merge Sort -> Size: " + size + ", Comparisons: " + comparisons + ", Copies: " + copies);
   }
}

public class MergeSortApp {
   public static void main(String[] args) {
      int[] sizes = { 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000 };
      Random rand = new Random();

      for (int size : sizes) {
         int[] data = new int[size];
         for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(100000); // Random integers
         }

         System.out.println("\nTesting for size: " + size);

         // Merge Sort
         int[] mergeData = data.clone();
         MergeSort mergeSort = new MergeSort();
         mergeSort.mergeSort(mergeData);
         mergeSort.printMetrics(size);
      }
   }
}