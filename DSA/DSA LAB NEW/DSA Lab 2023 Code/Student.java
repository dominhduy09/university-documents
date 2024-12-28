public class Student
{
    private String fname, lname;
    private int grade;
    
    public Student(String fname, String lname, int grade)
    {
        this.fname = fname;
        this.lname = lname;
        this.grade = grade;
    }

    public String toString()
    {
        return fname + " " + lname + "\t" + grade;
    }
}
