// priorityQ.java
// demonstrates priority queue
// to run this program: C>java PriorityQApp
////////////////////////////////////////////////////////////////
class PriorityQ {
   private int maxSize;
   private long[] queArray;
   private int nItems;

   public PriorityQ(int s) { // constructor
      maxSize = s;
      queArray = new long[maxSize];
      nItems = 0;
   }

   public void insert(long item) { // insert item in sorted order
      int j;
      if (nItems == 0) { // if no items,
         queArray[nItems++] = item; // insert at 0
      } else { // if items,
         for (j = nItems - 1; j >= 0; j--) { // start at end,
            if (item < queArray[j]) // if new item smaller,
               queArray[j + 1] = queArray[j]; // shift upward
            else
               break; // done shifting
         }
         queArray[j + 1] = item; // insert it
         nItems++;
      }
   }

   public long remove() { // remove minimum item
      return queArray[--nItems];
   }

   public long peekMin() { // peek at minimum item
      return queArray[nItems - 1];
   }

   public boolean isEmpty() { // true if queue is empty
      return (nItems == 0);
   }

   public boolean isFull() { // true if queue is full
      return (nItems == maxSize);
   }

   public void displayQueue() { // display the current state of the queue
      System.out.print("Queue: ");
      for (int i = 0; i < nItems; i++) {
         System.out.print(queArray[i] + " ");
      }
      System.out.println();
   }
}

class CustomerQueueApp {
   public static void main(String[] args) {
      PriorityQ customerQueue = new PriorityQ(10); // A priority queue to hold customers

      // Simulating customer arrivals with different priority levels
      customerQueue.insert(30); // Customer 1 (low priority)
      customerQueue.displayQueue();
      customerQueue.insert(10); // Customer 2 (high priority)
      customerQueue.displayQueue();
      customerQueue.insert(20); // Customer 3 (medium priority)
      customerQueue.displayQueue();

      // Simulate serving customers based on priority
      System.out.println("Serving customers based on priority:");
      while (!customerQueue.isEmpty()) {
         long customer = customerQueue.remove(); // Serve highest-priority customer first
         System.out.println("Serving customer with priority: " + customer);
         customerQueue.displayQueue();
      }
   }
}

////////////////////////////////////////////////////////////////
