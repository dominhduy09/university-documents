public class LinkQueue {
    private FirstLastList theList;
    private int removeCallCount = 0; // Counter for remove() calls
    private final int N = 3; // Remove only after N calls

    public LinkQueue() {
        theList = new FirstLastList();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void insert(long j) {
        theList.insertLast(j);
    }

    public long remove() {
        removeCallCount++;
        if (removeCallCount == N) { // Only remove if N calls have been made
            removeCallCount = 0; // Reset counter after removal
            return theList.deleteFirst();
        }
        return -1; // No removal
    }

    public int size() {
        return theList.getSize();
    }

    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }
}
