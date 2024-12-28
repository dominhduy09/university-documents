class Person {
   private String lastName;
   private String firstName;
   private int age;
   private double grade; // new field to store grade
   // -----------------------------------------------------------

   public Person(String last, String first, int a, double g) { // constructor
      lastName = last;
      firstName = first;
      age = a;
      grade = g;
   }

   // -----------------------------------------------------------
   public void displayPerson() {
      System.out.print("   Last name: " + lastName);
      System.out.print(", First name: " + firstName);
      System.out.print(", Age: " + age);
      System.out.println(", Grade: " + grade);
   }

   // -----------------------------------------------------------
   public String getLast() {
      return lastName;
   }

   public String getFirst() {
      return firstName;
   }

   public int getAge() {
      return age;
   }

   public double getGrade() {
      return grade;
   }
} // end class Person

class ArrayInOb {
   private Person[] a; // reference to array a
   private int nElems; // number of data items
   // --------------------------------------------------------------

   public ArrayInOb(int max) { // constructor
      a = new Person[max]; // create the array
      nElems = 0; // no items yet
   }

   // --------------------------------------------------------------
   public void insert(String last, String first, int age, double grade) {
      a[nElems] = new Person(last, first, age, grade);
      nElems++; // increment size
   }

   // --------------------------------------------------------------
   public void display() { // displays array contents
      for (int j = 0; j < nElems; j++) { // for each element,
         a[j].displayPerson(); // display it
      }
   }

   // --------------------------------------------------------------
   public void sortByLastName() { // Insertion sort by last name
      int in, out;
      for (out = 1; out < nElems; out++) {
         Person temp = a[out];
         in = out;
         while (in > 0 && a[in - 1].getLast().compareTo(temp.getLast()) > 0) {
            a[in] = a[in - 1];
            --in;
         }
         a[in] = temp;
      }
   }

   // --------------------------------------------------------------
   public void sortByFirstName() { // Insertion sort by first name
      int in, out;
      for (out = 1; out < nElems; out++) {
         Person temp = a[out];
         in = out;
         while (in > 0 && a[in - 1].getFirst().compareTo(temp.getFirst()) > 0) {
            a[in] = a[in - 1];
            --in;
         }
         a[in] = temp;
      }
   }

   // --------------------------------------------------------------
   public void sortByAge() { // Insertion sort by age
      int in, out;
      for (out = 1; out < nElems; out++) {
         Person temp = a[out];
         in = out;
         while (in > 0 && a[in - 1].getAge() > temp.getAge()) {
            a[in] = a[in - 1];
            --in;
         }
         a[in] = temp;
      }
   }
}

class ObjectSortApp {
   public static void main(String[] args) {
      int maxSize = 10; // array size
      ArrayInOb arr; // reference to array
      arr = new ArrayInOb(maxSize); // create the array

      // Inserting 10 people with last name, first name, age, and grade
      arr.insert("Evans", "Patty", 24, 3.6);
      arr.insert("Smith", "Doc", 59, 2.9);
      arr.insert("Smith", "Lorraine", 37, 3.7);
      arr.insert("Smith", "Paul", 37, 3.2);
      arr.insert("Yee", "Tom", 43, 3.1);
      arr.insert("Hashimoto", "Sato", 21, 3.9);
      arr.insert("Stimson", "Henry", 29, 2.8);
      arr.insert("Velasquez", "Jose", 72, 3.5);
      arr.insert("Vang", "Minh", 22, 3.3);
      arr.insert("Creswell", "Lucinda", 18, 3.8);

      System.out.println("Before sorting:");
      arr.display(); // display items

      // Sort by last name
      arr.sortByLastName();
      System.out.println("\nAfter sorting by last name:");
      arr.display();

      // Sort by first name
      arr.sortByFirstName();
      System.out.println("\nAfter sorting by first name:");
      arr.display();

      // Sort by age
      arr.sortByAge();
      System.out.println("\nAfter sorting by age:");
      arr.display();
   }
}
