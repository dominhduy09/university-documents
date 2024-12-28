// Student.java
public class Student {
    private String fname;
    private String lname;
    private int grade;

    // Constructor to initialize the student details
    public Student(String fname, String lname, int grade) {
        this.fname = fname;
        this.lname = lname;
        this.grade = grade;
    }

    // Getter for last name
    public String getLname() {
        return lname;
    }

    // Getter for first name
    public String getFname() {
        return fname;
    }

    // Getter for grade
    public int getGrade() {
        return grade;
    }
}
