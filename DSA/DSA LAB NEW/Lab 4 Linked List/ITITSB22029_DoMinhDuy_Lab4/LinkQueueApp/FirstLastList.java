public class FirstLastList {
    private Link first;
    private Link last;
    private int size = 0; // Track the size of the list

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertLast(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
        size++;
    }

    public long deleteFirst() {
        long temp = first.dData;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        size--;
        return temp;
    }

    public int getSize() {
        return size;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}
