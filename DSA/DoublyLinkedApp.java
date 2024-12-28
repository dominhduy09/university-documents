// doublyLinked.java
// demonstrates doubly-linked list
// to run this program: C>java DoublyLinkedApp
////////////////////////////////////////////////////////////////
class Link {
    public long dData; // data item
    public Link next; // next link in list
    public Link previous; // previous link in list
    // -------------------------------------------------------------

    public Link(long d) // constructor
    {
        dData = d;
    }

    // -------------------------------------------------------------
    public void displayLink() // display this link
    {
        System.out.print(dData + " ");
    }
    // -------------------------------------------------------------

} // end class Link
  ////////////////////////////////////////////////////////////////

class DoublyLinkedList {
    private Link first; // ref to first item
    private Link last; // ref to last item
    // -------------------------------------------------------------

    public DoublyLinkedList() // constructor
    {
        first = null; // no items on list yet
        last = null;
    }

    // -------------------------------------------------------------
    public boolean isEmpty() // true if no links
    {
        return first == null;
    }

    // -------------------------------------------------------------
    public void insertFirst(long dd) // insert at front of list
    {
        // YOUR CODE STARTS HERE
        Link newLink = new Link(dd);

        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
        // YOUR CODE ENDS HERE
    }

    // -------------------------------------------------------------
    public void insertLast(long dd) // insert at end of list
    {
        // YOUR CODE STARTS HERE
        Link newLink = new Link(dd);

        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }

        last = newLink;
        // YOUR CODE ENDS HERE
    }

    // -------------------------------------------------------------
    public Link deleteFirst() // delete first link
    { // (assumes non-empty list)
      // YOUR CODE STARTS HERE
        Link temp = first;

        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
        // YOUR CODE ENDS HERE
    }

    // -------------------------------------------------------------
    public Link deleteLast() // delete last link
    { // (assumes non-empty list)
      // YOUR CODE STARTS HERE
        Link temp = last;

        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
        // YOUR CODE ENDS HERE
    }

    // -------------------------------------------------------------
    // insert dd just after key
    public boolean insertAfter(long key, long dd) { // (assumes non-empty list)
        Link current = first; // start at beginning
        while (current.dData != key) // until match is found,
        {
            current = current.next; // move to next link
            if (current == null)
                return false; // didn't find it
        }
        Link newLink = new Link(dd); // make new link

        if (current == last) // if last link,
        {
            newLink.next = null; // newLink --> null
            last = newLink; // newLink <-- last
        } else // not last link,
        {
            newLink.next = current.next; // newLink --> old next
                                         // newLink <-- old next
            current.next.previous = newLink;
        }
        newLink.previous = current; // old current <-- newLink
        current.next = newLink; // old current --> newLink
        return true; // found it, did insertion
    }

    // -------------------------------------------------------------
    public Link deleteKey(long key) // delete item w/ given key
    { // (assumes non-empty list)
      // YOUR CODE STARTS HERE
        Link current = first;

        while (current.dData != key) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }

        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }

        return current;
        // YOUR CODE ENDS HERE
    }

    // -------------------------------------------------------------
    public void displayForward() {
        // YOUR CODE STARTS HERE
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
        // YOUR CODE ENDS HERE
    }

    // -------------------------------------------------------------
    public void displayBackward() {
        // YOUR CODE STARTS HERE
        System.out.print("List (last-->first): ");
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println("");
        // YOUR CODE ENDS HERE
    }
    // -------------------------------------------------------------
} // end class DoublyLinkedList
  ////////////////////////////////////////////////////////////////

class DoublyLinkedApp {
    public static void main(String[] args) { // make a new list
        DoublyLinkedList theList = new DoublyLinkedList();

        theList.insertFirst(22); // insert at front
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11); // insert at rear
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayForward(); // display list forward
        theList.displayBackward(); // display list backward

        theList.deleteFirst(); // delete first item
        theList.deleteLast(); // delete last item
        theList.deleteKey(11); // delete item with key 11

        theList.displayForward(); // display list forward

        theList.insertAfter(22, 77); // insert 77 after 22
        theList.insertAfter(33, 88); // insert 88 after 33

        theList.displayForward(); // display list forward
    } // end main()
} // end class DoublyLinkedApp
  ////////////////////////////////////////////////////////////////