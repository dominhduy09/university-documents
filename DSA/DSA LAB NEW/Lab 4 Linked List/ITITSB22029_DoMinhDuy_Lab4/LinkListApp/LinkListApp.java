class Link {
   public int iData; // data item
   public double dData; // data item
   public Link next; // next link in list

   public Link(int id, double dd) { // constructor
      iData = id; // initialize data
      dData = dd; // ('next' is automatically set to null)
   }

   public void displayLink() { // display ourself
      System.out.print("{" + iData + ", " + dData + "} ");
   }

   @Override
   public String toString() {
      return "{" + iData + ", " + dData + "}";
   }
}

class LinkList {
   private Link first; // ref to first link on list

   public LinkList() { // constructor
      first = null; // no links on list yet
   }

   public boolean isEmpty() { // true if list is empty
      return (first == null);
   }

   public void insertFirst(int id, double dd) { // insert at start of list
      Link newLink = new Link(id, dd);
      newLink.next = first; // newLink --> old first
      first = newLink; // first --> newLink
   }

   public Link deleteFirst() { // delete first item
      if (isEmpty()) {
         return null; // if empty, nothing to delete
      }
      Link temp = first; // save reference to link
      first = first.next; // delete it: first-->old next
      return temp; // return deleted link
   }

   public Link getFirst() { // get the first element
      return first;
   }

   public Link getLast() { // get the last element
      if (isEmpty()) {
         return null;
      }
      Link current = first;
      while (current.next != null) { // traverse to the last link
         current = current.next;
      }
      return current;
   }

   public void displayList() {
      System.out.print("List (first-->last): ");
      Link current = first; // start at beginning of list
      while (current != null) { // until end of list,
         current.displayLink(); // print data
         current = current.next; // move to next link
      }
      System.out.println("");
   }

   @Override
   public String toString() { // Override toString for easy printing
      StringBuilder listStr = new StringBuilder("List (first-->last): ");
      Link current = first;
      while (current != null) {
         listStr.append(current.toString()).append(" ");
         current = current.next;
      }
      return listStr.toString();
   }
}

class LinkListApp {
   public static void main(String[] args) {
      LinkList theList = new LinkList(); // make new list

      theList.insertFirst(22, 2.99); // insert four items
      theList.insertFirst(44, 4.99);
      theList.insertFirst(66, 6.99);
      theList.insertFirst(88, 8.99);

      System.out.println(theList); // display list using toString()

      while (!theList.isEmpty()) { // until it's empty,
         Link aLink = theList.deleteFirst(); // delete link
         System.out.print("Deleted "); // display it
         System.out.println(aLink);
      }
      System.out.println(theList); // display empty list using toString()

      // Example usage of getFirst() and getLast()
      theList.insertFirst(55, 5.99); // insert one item
      System.out.println("First element: " + theList.getFirst());
      System.out.println("Last element: " + theList.getLast());
   }
}
