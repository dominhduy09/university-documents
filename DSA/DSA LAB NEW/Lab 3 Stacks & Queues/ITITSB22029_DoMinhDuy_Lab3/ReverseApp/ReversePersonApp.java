// reverse.java
// stack used to reverse a string
// to run this program: C>java ReverseApp

// Create a stack of objects of class Person and use to reverse a list of persons.
import java.util.*; // for I/O and List

// Define a class Person to store the name and age
class Person {
   private String name;
   private int age;

   public Person(String name, int age) {
      this.name = name;
      this.age = age;
   }

   public String getName() {
      return name;
   }

   public int getAge() {
      return age;
   }

   @Override
   public String toString() {
      return name + " (" + age + " years)";
   }
}

// Stack class that stores Person objects
class PersonStack {
   private int maxSize;
   private Person[] stackArray;
   private int top;

   public PersonStack(int max) { // Constructor
      maxSize = max;
      stackArray = new Person[maxSize];
      top = -1;
   }

   public void push(Person p) { // Push a Person object onto the stack
      stackArray[++top] = p;
   }

   public Person pop() { // Pop a Person object from the stack
      return stackArray[top--];
   }

   public boolean isEmpty() { // Check if stack is empty
      return (top == -1);
   }
}

// Reverser class to reverse a list of Person objects
class PersonReverser {
   private List<Person> persons; // List of Person objects to reverse

   public PersonReverser(List<Person> persons) {
      this.persons = persons;
   }

   public List<Person> reverse() { // Reverse the list using a stack
      int stackSize = persons.size();
      PersonStack stack = new PersonStack(stackSize); // Create a stack of Person objects

      // Push all persons onto the stack
      for (Person person : persons) {
         stack.push(person);
      }

      // Pop all persons from the stack to reverse the list
      List<Person> reversedPersons = new ArrayList<>();
      while (!stack.isEmpty()) {
         reversedPersons.add(stack.pop());
      }

      return reversedPersons;
   }
}

// Main class to demonstrate the reversing of a list of Person objects
public class ReversePersonApp {
   public static void main(String[] args) {
      // Create a list of Person objects
      List<Person> personList = new ArrayList<>();
      personList.add(new Person("Alice", 30));
      personList.add(new Person("Bob", 25));
      personList.add(new Person("Charlie", 35));
      personList.add(new Person("Diana", 28));

      System.out.println("Original List of Persons:");
      for (Person person : personList) {
         System.out.println(person);
      }

      // Reverse the list using the PersonReverser
      PersonReverser reverser = new PersonReverser(personList);
      List<Person> reversedList = reverser.reverse();

      System.out.println("\nReversed List of Persons:");
      for (Person person : reversedList) {
         System.out.println(person);
      }
   }
}

////////////////////////////////////////////////////////////////
