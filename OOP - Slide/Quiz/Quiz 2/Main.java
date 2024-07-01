import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseManager courseManager = new CourseManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a course");
            System.out.println("2. Display course information");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter course ID: ");
                    String id = scanner.nextLine();

                    // Check if ID is empty or already exists
                    if (id.isEmpty() || courseManager.getCourse(id) != null) {
                        System.out.println("Invalid ID. Please provide a unique non-empty ID.");
                        break;
                    }

                    System.out.print("Enter course name: ");
                    String name = scanner.nextLine().toUpperCase(); // Convert name to upper case

                    System.out.print("Enter number of lecture credits: ");
                    int lectureCredits = scanner.nextInt();
                    if (lectureCredits <= 0) {
                        System.out.println("Lecture credits must be greater than zero.");
                        break;
                    }

                    System.out.print("Enter number of lab credits: ");
                    int labCredits = scanner.nextInt();
                    if (labCredits < 0) {
                        System.out.println("Lab credits cannot be negative.");
                        break;
                    }

                    // Add the course
                    boolean added = courseManager.addCourse(id, name, lectureCredits, labCredits);
                    if (added) {
                        System.out.println("Course added successfully!");
                    } else {
                        System.out.println("Failed to add course.");
                    }
                    break;
                case 2:
                    System.out.print("Enter course ID: ");
                    String courseId = scanner.nextLine();

                    Course course = courseManager.getCourse(courseId);
                    if (course != null) {
                        System.out.println("Course ID: " + course.getId());
                        System.out.println("Course Name: " + course.getName());
                        System.out.println("Lecture Credits: " + course.getLectureCredits());
                        System.out.println("Lab Credits: " + course.getLabCredits());
                    } else {
                        System.out.println("Course not found!");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
