// linkList2.java
// demonstrates linked list
// to run this program: C>java LinkList2App
////////////////////////////////////////////////////////////////
class Link {
   public int iData;              // data item (key)
   public double dData;           // data item
   public Link next;              // next link in list

   // -------------------------------------------------------------
   public Link(int id, double dd) { // constructor
      iData = id;
      dData = dd;
   }

   // -------------------------------------------------------------
   public void displayLink() {      // display ourself
      System.out.print("{" + iData + ", " + dData + "} ");
   }
}  // end class Link

////////////////////////////////////////////////////////////////
class LinkList {
   private Link first;            // ref to first link on list

   // -------------------------------------------------------------
   public LinkList() {             // constructor
      first = null;                // no links on list yet
   }

   // -------------------------------------------------------------
   public void insertFirst(int id, double dd) {   // make new link
      Link newLink = new Link(id, dd);            // create a new link
      newLink.next = first;                       // new link points to old first link
      first = newLink;                            // first now points to new link
   }

   // -------------------------------------------------------------
   public Link find(int key) {      // find link with given key
      Link current = first;         // start at first link
      while (current != null && current.iData != key) {  // loop until end of list or key is found
         current = current.next;    // move to next link
      }
      return current;               // will be null if not found, or the link if found
   }

   // -------------------------------------------------------------
   public Link delete(int key) {    // delete link with given key
      Link current = first;         // search for link
      Link previous = null;
      while (current != null && current.iData != key) {
         previous = current;        // move one step behind
         current = current.next;
      }
      if (current == null) {        // key not found
         return null;
      }
      if (previous == null) {       // if it's the first link
         first = first.next;        // change first link
      } else {
         previous.next = current.next;  // bypass the deleted link
      }
      return current;
   }

   // -------------------------------------------------------------
   public void displayList() {      // display the list
      System.out.print("List (first-->last): ");
      Link current = first;         // start at beginning of list
      while(current != null) {      // until end of list,
         current.displayLink();     // print data
         current = current.next;    // move to next link
      }
      System.out.println("");
   }
}  // end class LinkList

////////////////////////////////////////////////////////////////
class LinkList2App {
   public static void main(String[] args) {
      LinkList theList = new LinkList();  // make list

      theList.insertFirst(22, 2.99);      // insert 4 items
      theList.insertFirst(44, 4.99);
      theList.insertFirst(66, 6.99);
      theList.insertFirst(88, 8.99);

      theList.displayList();              // display list

      Link f = theList.find(44);          // find item
      if( f != null)
         System.out.println("Found link with key " + f.iData);
      else
         System.out.println("Can't find link");

      Link d = theList.delete(66);        // delete item
      if( d != null )
         System.out.println("Deleted link with key " + d.iData);
      else
         System.out.println("Can't delete link");

      theList.displayList();              // display list
   }  // end main()
}  // end class LinkList2App
////////////////////////////////////////////////////////////////