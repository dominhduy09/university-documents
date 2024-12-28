/*
 * Reading student records from a file, generating Student objects, counting and averaging
 * Suggested exercises:
 * - Use grade to determine the type of the student: excellent (> 89), ok [60,89], and failure (< 60)
 * - Define an enum type {excellent, ok, failure} and use it to print the student type
 * - Do counting and averaging within each student type (excellent, ok, and failure)
 * - Count students by using a static variable in class Student
 */
import java.util.Scanner;
import java.io.*;

public class Students
{
    public static void main (String[] args) throws IOException
    {   String first_name, last_name;
        int grade, total=0, count=0;
        double average;
        Scanner fileInput = new Scanner(new File("students.txt"));
        while (fileInput.hasNext())
        {
            first_name = fileInput.next();
            last_name = fileInput.next();
            grade = fileInput.nextInt();
            
            Student st = new Student(first_name, last_name, grade);
            
            System.out.println(st);
            total = total + grade; 
            count++;
        }
        average = (double)total/count;
        System.out.println("There are " + count + " students with average grade " + average);
    }
}
