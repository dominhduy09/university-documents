
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Duy", "123 Nguyen Anh Thu", "Computer Science", 2023, 5000.00);
        Student student2 = new Student("Nam", "456 Xa lo Ha Noi", "Mathematics", 2022, 5500.00);
        Staff staff1 = new Staff("Nghia", "789 Xa lo HCM", "School of Engineering", 60000.00);
        Staff staff2 = new Staff("Tung", "135 Cau Sai Gon", "School of Business", 65000.00);

        System.out.println("Student 1: " + student1);
        System.out.println("Student 2: " + student2);
        System.out.println("Staff 1: " + staff1);
        System.out.println("Staff 2: " + staff2);

        // Modifying information
        student1.setProgram("Electrical Engineering");
        student2.setYear(2021);
        staff1.setPay(62000.00);
        staff2.setSchool("School of Economics");

        System.out.println("\nModified information:");
        System.out.println("Student 1: " + student1);
        System.out.println("Student 2: " + student2);
        System.out.println("Staff 1: " + staff1);
        System.out.println("Staff 2: " + staff2);
    }
}