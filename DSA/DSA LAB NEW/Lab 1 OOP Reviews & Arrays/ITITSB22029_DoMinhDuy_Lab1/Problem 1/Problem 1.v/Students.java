// Students.java
import java.io.*;
import java.util.ArrayList;

public class Students {
    private ArrayList<Student> studentList = new ArrayList<>();

    // Method to load students from a file (students.txt)
    public void loadStudents(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");  // Assuming the format: fname,lname,grade
                String fname = parts[0];
                String lname = parts[1];
                int grade = Integer.parseInt(parts[2]);
                studentList.add(new Student(fname, lname, grade));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to categorize and display students
    public void categorizeStudents() {
        int excellentCount = 0, okCount = 0, failureCount = 0;
        int excellentSum = 0, okSum = 0, failureSum = 0;

        // Using a for-loop to iterate through the student list
        for (Student st : studentList) {
            int grade = st.getGrade();
            if (grade > 89) {
                excellentCount++;
                excellentSum += grade;
            } else if (grade >= 60 && grade <= 89) {
                okCount++;
                okSum += grade;
            } else {
                failureCount++;
                failureSum += grade;
            }

            // Print student's last name
            System.out.println("Student: " + st.getLname() + ", Grade: " + st.getGrade());
        }

        // Calculate and print averages
        System.out.println("\nCategory Summary:");
        if (excellentCount > 0) {
            System.out.println("Excellent Students: " + excellentCount + ", Average Grade: " + (excellentSum / excellentCount));
        } else {
            System.out.println("No Excellent Students");
        }

        if (okCount > 0) {
            System.out.println("OK Students: " + okCount + ", Average Grade: " + (okSum / okCount));
        } else {
            System.out.println("No OK Students");
        }

        if (failureCount > 0) {
            System.out.println("Failure Students: " + failureCount + ", Average Grade: " + (failureSum / failureCount));
        } else {
            System.out.println("No Failure Students");
        }
    }

    public static void main(String[] args) {
        Students students = new Students();
        students.loadStudents("students.txt");
        students.categorizeStudents();
    }
}
