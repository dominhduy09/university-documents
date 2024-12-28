import java.util.Scanner;

// A - Reverse a linked list 

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListReversal {

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null) {
            return null; // if the list is empty, return null
        }

        SinglyLinkedListNode prev = null; // Initialize previous pointer
        SinglyLinkedListNode current = head; // Start with the head of the list

        // Traverse the list and reverse the links
        while (current != null) {
            SinglyLinkedListNode nextNode = current.next; // Store the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move the prev pointer up
            current = nextNode; // Move to the next node
        }

        return prev;
    }

    public static void printList(SinglyLinkedListNode head) {
        SinglyLinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt(); // Number of elements in the linked list
            SinglyLinkedListNode head = null;
            SinglyLinkedListNode tail = null;

            for (int i = 0; i < n; i++) {
                int data = scanner.nextInt();
                SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

                if (head == null) {
                    head = newNode; // Set the first node as head
                } else {
                    tail.next = newNode; // Link the new node to the list
                }
                tail = newNode; // Update the tail reference
            }

            SinglyLinkedListNode reversedHead = reverse(head);

            printList(reversedHead);
        }
        scanner.close();
    }
}
