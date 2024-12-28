import java.io.*;
import java.util.*;

// TreeApp.java
// demonstrates binary tree
public class TreeApp {
   public static void main(String[] args) throws IOException {
      int value;
      Tree theTree = new Tree();

      theTree.insert(50, 1.5);
      theTree.insert(25, 1.2);
      theTree.insert(75, 1.7);
      theTree.insert(12, 1.5);
      theTree.insert(37, 1.2);
      theTree.insert(43, 1.7);
      theTree.insert(30, 1.5);
      theTree.insert(33, 1.2);
      theTree.insert(87, 1.7);
      theTree.insert(93, 1.5);
      theTree.insert(97, 1.5);

      while (true) {
         System.out.print("\nEnter first letter of show and there are some special cases, ");
         System.out.print(
               "insert(i), find(f), delete(d), traverse(t), clear(c), random(r), min(m), max(x), save(a), or quit(q): ");

         int choice = getChar();
         switch (choice) {
            case 's':
               System.out.print("horizontal or vertical (1 or 2)? ");
               value = getInt();
               if (value == 1) {
                  System.out.println();
                  showTree(0, theTree.root);
               } else
                  theTree.displayTree();
               break;
            case 'i':
               System.out.print("Enter value to insert: ");
               value = getInt();
               theTree.insert(value, value + 0.9);
               System.out.println("Comparisons = " + theTree.comps);
               break;
            case 'f':
               System.out.print("Enter value to find: ");
               value = getInt();
               Node found = theTree.find(value);
               if (found != null) {
                  System.out.print("Found: ");
                  found.displayNode();
                  System.out.print("\n");
               } else {
                  System.out.print("Could not find ");
                  System.out.println(value);
               }
               System.out.println("Comparisons = " + theTree.comps);
               break;
            case 'd':
               System.out.print("Enter value to delete: ");
               value = getInt();
               boolean didDelete = theTree.delete(value);
               if (didDelete)
                  System.out.print("Deleted " + value + '\n');
               else {
                  System.out.print("Could not delete ");
                  System.out.println(value);
               }
               System.out.println("Comparisons = " + theTree.comps);
               break;
            case 't':
               System.out.print("Enter type 1, 2 or 3: ");
               value = getInt();
               theTree.traverse(value);
               break;
            case 'c':
               theTree.clearTree();
               System.out.println("Tree cleared.");
               break;
            case 'r':
               System.out.print("Enter the number of random items to insert: ");
               value = getInt();
               insertRandomItems(theTree, value);
               break;
            case 'm':
               Node minNode = theTree.findMin();
               System.out.print("Minimal item: ");
               minNode.displayNode();
               System.out.println();
               break;
            case 'x':
               Node maxNode = theTree.findMax();
               System.out.print("Maximal item: ");
               maxNode.displayNode();
               System.out.println();
               break;
            case 'a':
               int[] items = saveItemsInArray(theTree.root);
               System.out.println("Items saved to array.");
               theTree.clearTree();
               System.out.println("Tree cleared.");
               reinsertionFromArray(theTree, items);
               break;
            case 'q':
               return;
            default:
               System.out.print("Invalid entry\n");
         }
      }
   }

   public static String getString() throws IOException {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
   }

   public static char getChar() throws IOException {
      String s = getString();
      return s.charAt(0);
   }

   public static int getInt() throws IOException {
      String s = getString();
      return Integer.parseInt(s);
   }

   public static void showTree(int n, Node t) {
      tab(n);
      if (t == null)
         System.out.println("*");
      else {
         n = n + 3;
         System.out.println(t.iData);
         if (t.leftChild == null && t.rightChild == null)
            return;
         showTree(n, t.leftChild);
         showTree(n, t.rightChild);
      }
   }

   public static void tab(int n) {
      for (int i = 0; i < n; i++)
         System.out.print(" ");
   }

   public static void insertRandomItems(Tree tree, int n) {
      Random rand = new Random();
      for (int i = 0; i < n; i++) {
         int value = rand.nextInt(100) + 1; // Random values between 1 and 100
         tree.insert(value, value + 0.9);
      }
   }

   public static int[] saveItemsInArray(Node root) {
      List<Integer> itemsList = new ArrayList<>();
      inOrderSave(root, itemsList);
      return itemsList.stream().mapToInt(i -> i).toArray();
   }

   private static void inOrderSave(Node node, List<Integer> itemsList) {
      if (node != null) {
         inOrderSave(node.leftChild, itemsList);
         itemsList.add(node.iData);
         inOrderSave(node.rightChild, itemsList);
      }
   }

   public static void reinsertionFromArray(Tree tree, int[] items) {
      for (int item : items) {
         tree.insert(item, item + 0.9);
      }
   }

   public static Node node(int data, Node l, Node r) {
      Node a = new Node();
      a.iData = data;
      a.leftChild = l;
      a.rightChild = r;
      return a;
   }
}

// Node.java
class Node {
   public int iData; // data item (key)
   public double dData; // data item
   public Node leftChild; // this node's left child
   public Node rightChild; // this node's right child

   public void displayNode() {
      System.out.print('{');
      System.out.print(iData);
      System.out.print(", ");
      System.out.print(dData);
      System.out.print("} ");
   }
}

// Tree.java
class Tree {
   int comps = 0;
   Node root; // first node of tree

   public Tree() {
      root = null;
   }

   public Node find(int key) {
      comps = 0;
      Node current = root;
      while (current.iData != key) {
         comps++;
         if (key < current.iData)
            current = current.leftChild;
         else
            current = current.rightChild;
         if (current == null)
            return null;
      }
      comps++; // final comparison when key is found
      return current;
   }

   public void insert(int id, double dd) {
      comps = 0;
      Node newNode = new Node();
      newNode.iData = id;
      newNode.dData = dd;
      if (root == null)
         root = newNode;
      else {
         Node current = root;
         Node parent;
         while (true) {
            parent = current;
            comps++;
            if (id < current.iData) {
               current = current.leftChild;
               if (current == null) {
                  parent.leftChild = newNode;
                  return;
               }
            } else {
               current = current.rightChild;
               if (current == null) {
                  parent.rightChild = newNode;
                  return;
               }
            }
         }
      }
   }

   public boolean delete(int key) {
      comps = 0;
      Node current = root;
      Node parent = root;
      boolean isLeftChild = true;

      while (current.iData != key) {
         comps++;
         parent = current;
         if (key < current.iData) {
            isLeftChild = true;
            current = current.leftChild;
         } else {
            isLeftChild = false;
            current = current.rightChild;
         }
         if (current == null)
            return false;
      }

      if (current.leftChild == null && current.rightChild == null) {
         if (current == root)
            root = null;
         else if (isLeftChild)
            parent.leftChild = null;
         else
            parent.rightChild = null;
      } else if (current.rightChild == null) {
         if (current == root)
            root = current.leftChild;
         else if (isLeftChild)
            parent.leftChild = current.leftChild;
         else
            parent.rightChild = current.leftChild;
      } else if (current.leftChild == null) {
         if (current == root)
            root = current.rightChild;
         else if (isLeftChild)
            parent.leftChild = current.rightChild;
         else
            parent.rightChild = current.rightChild;
      } else {
         Node successor = getSuccessor(current);
         if (current == root)
            root = successor;
         else if (isLeftChild)
            parent.leftChild = successor;
         else
            parent.rightChild = successor;
         successor.leftChild = current.leftChild;
      }
      return true;
   }

   public Node getSuccessor(Node delNode) {
      Node successorParent = delNode;
      Node successor = delNode;
      Node current = delNode.rightChild;
      while (current != null) {
         successorParent = successor;
         successor = current;
         current = current.leftChild;
      }

      if (successor != delNode.rightChild) {
         successorParent.leftChild = successor.rightChild;
         successor.rightChild = delNode.rightChild;
      }
      return successor;
   }

   public void traverse(int type) {
      switch (type) {
         case 1:
            System.out.print("In-order traversal: ");
            inOrder(root);
            break;
         case 2:
            System.out.print("Pre-order traversal: ");
            preOrder(root);
            break;
         case 3:
            System.out.print("Post-order traversal: ");
            postOrder(root);
            break;
         default:
            System.out.println("Invalid type");
      }
      System.out.println();
   }

   public void inOrder(Node node) {
      if (node != null) {
         inOrder(node.leftChild);
         node.displayNode();
         inOrder(node.rightChild);
      }
   }

   public void preOrder(Node node) {
      if (node != null) {
         node.displayNode();
         preOrder(node.leftChild);
         preOrder(node.rightChild);
      }
   }

   public void postOrder(Node node) {
      if (node != null) {
         postOrder(node.leftChild);
         postOrder(node.rightChild);
         node.displayNode();
      }
   }

   public void displayTree() {
      System.out.println("\nTree (in-order): ");
      inOrder(root);
   }

   public Node findMin() {
      Node current = root;
      while (current.leftChild != null)
         current = current.leftChild;
      return current;
   }

   public Node findMax() {
      Node current = root;
      while (current.rightChild != null)
         current = current.rightChild;
      return current;
   }

   public void clearTree() {
      root = null;
   }
}

// How the Tree Changes:
// In-order Traversal will "flatten" the tree by visiting the nodes in
// increasing order, which is especially useful for a binary search tree because
// it gives you the sorted order of the values.
// Pre-order Traversal starts with the root, which makes it useful when you want
// to process the root before its children (for instance, when copying or saving
// the tree structure).
// Post-order Traversal works from the leaves to the root, making it useful for
// deletion or when you need to process nodes in a bottom-up manner.
// In all of these traversals, the tree structure itself doesn’t change (i.e.,
// it remains the same throughout the traversal). Traversal merely determines
// the order in which the nodes are visited or processed, which can be useful in
// different algorithms or operations on the tree.