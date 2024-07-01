/**
 * Student
 */
public class Student {
    private static int totalStudents = 0;
    private int id;
    private String name;
    private String major;

    public Student(String name) {
        this.name = name;
        this.id = ++totalStudents;
    }

    public void setMajor(String major) {
        if (major.equals("CS") || major.equals("NE")) {
            this.major = major;
        } else {
            System.out.println("Error: Invalid major. Major must be either 'CS' or 'NE'.");
        }
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

}