import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student's major (CS or NE): ");
            String major = scanner.nextLine();

            if (major.equals("CS") || major.equals("NE")) {
                Student student = new Student(name);
                student.setMajor(major);

                System.out.println("Student created:");
                System.out.println("Name: " + student.getName());
                System.out.println("ID: " + student.getID());
                System.out.println("Major: " + student.getMajor());
            } else {
                System.out.println("Error: Invalid major. Major must be either 'CS' or 'NE'.");
            }

            System.out.print("Do you want to enter another student? (y/n): ");
            choice = scanner.nextLine().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        scanner.close();
    }
}

// Student student1 = new Student("John");
// student1.setMajor("CS");
//
// Student student2 = new Student("Alice");
// student2.setMajor("NE");
//
// Student student3 = new Student("Bob");
// student3.setMajor("Math"); // This should print an error message
//
// System.out.println("Student details:");
// System.out.println(
// "ID: " + student1.getID() + ", Name: " + student1.getName() + ", Major: "
// + student1.getMajor());
// System.out.println(
// "ID: " + student2.getID() + ", Name: " + student2.getName() + ", Major: "
// + student2.getMajor());
// System.out.println(
// "ID: " + student3.getID() + ", Name: " + student3.getName() + ", Major: "
// + student3.getMajor()); // This should print an error message