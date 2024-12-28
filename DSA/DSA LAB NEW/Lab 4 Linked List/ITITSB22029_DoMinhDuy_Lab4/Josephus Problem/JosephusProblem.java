import java.util.Scanner;

class Person {
    public int position;
    public Person next;

    public Person(int pos) {
        position = pos;
        next = null;
    }
}

class CircularLinkedList {
    private Person first;
    private Person last;

    public CircularLinkedList(int numPeople) {
        first = null;
        last = null;

        for (int i = 1; i <= numPeople; i++) {
            addPerson(i);
        }

        // Make the list circular
        if (last != null) {
            last.next = first;
        }
    }

    private void addPerson(int pos) {
        Person newPerson = new Person(pos);
        if (first == null) {
            first = newPerson;
            last = newPerson;
            first.next = first; // Point to itself for single node circularity
        } else {
            last.next = newPerson;
            newPerson.next = first;
            last = newPerson;
        }
    }

    public void solveJosephusProblem(int startPos, int countOff) {
        Person current = first;
        Person previous = last;

        // Move to the starting position
        while (current.position != startPos) {
            previous = current;
            current = current.next;
        }

        System.out.println("Elimination order:");

        while (current.next != current) { // More than one person remains
            for (int count = 1; count < countOff; count++) { // Count off to `countOff`
                previous = current;
                current = current.next;
            }
            System.out.print(current.position + " ");
            // Remove current person from the circle
            previous.next = current.next;
            current = current.next;
        }

        System.out.println("\nLast person left standing (safe position): " + current.position);
    }
}

public class JosephusProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of people in the circle: ");
        int numPeople = scanner.nextInt();

        System.out.print("Enter the number used for counting off: ");
        int countOff = scanner.nextInt();

        System.out.print("Enter the starting position: ");
        int startPos = scanner.nextInt();

        CircularLinkedList circle = new CircularLinkedList(numPeople);
        circle.solveJosephusProblem(startPos, countOff);
    }
}
