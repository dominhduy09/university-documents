import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Project {
    // instance variables
    private String projectId;
    private Date startDate;
    private Date endDate;
    private ArrayList<Employee> listOfEmployees;

    // default constructor
    public Project() {

    }

    // parameterized constructor
    public Project(String projectId, Date startDate, Date endDate, ArrayList<Employee> listOfEmployees) {
        this.projectId = projectId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.listOfEmployees = listOfEmployees;
    }

    // getter method
    public String getProjectId() {
        return projectId;
    }

    // setter method
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    // getter method
    public Date getStartDate() {
        return startDate;
    }

    // setter method
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    // getter method
    public Date getEndDate() {
        return endDate;
    }

    // setter method
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    // getter method
    public ArrayList<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    // setter method
    public void setListOfEmployees(ArrayList<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

    // estimates budget based on employee's SalaryPerHour
    public Integer estimateBudget() {
        // find no of days between start and end date
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        long NO_OF_DAYS = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        // assuming
        long TOTAL_WORKING_HOURS = 8;
        long total = 0;

        // loop through listOfEmployees
        for (int i = 0; i < listOfEmployees.size(); i++) {
            Employee employee = listOfEmployees.get(i);
            total += NO_OF_DAYS * TOTAL_WORKING_HOURS * employee.getSalaryPerHour();
        }
        return Integer.parseInt(String.valueOf(total));
    }

    // overridden toString method
    @Override
    public String toString() {
        String employeeString = "";
        // sort the arraylist using compareTo method defined in Employee class
        Collections.sort(listOfEmployees);
        // loop through array list

        for (int i = 0; i < listOfEmployees.size(); i++) {
            // get employee at index i
            Employee employee = listOfEmployees.get(i);
            employeeString += employee.toString();
        }
        return employeeString;
    }
}