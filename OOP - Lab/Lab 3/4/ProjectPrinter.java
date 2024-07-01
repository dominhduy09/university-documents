import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ProjectPrinter implements Runnable {
    private Project project;

    // getter method
    public Project getProject() {
        return project;
    }

    // constructor
    public ProjectPrinter(Project project) {
        this.project = project;
    }

    // setter method
    public void setProject(Project project) {
        this.project = project;
    }

    // implements the run method of Runnable interface
    @Override
    public void run() {

        // get arraylist of employees
        ArrayList<Employee> listOfEmployees = project.getListOfEmployees();
        try {
            // initialize date formatter
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            // get formatted dates
            String sDate = formatter.format(project.getStartDate());
            String eDate = formatter.format(project.getEndDate());
            String projectStr = "[Project Id:" + project.getProjectId() + " - " + "Project Duration::" + sDate + " to "
                    + eDate + "]";
            System.out.println(projectStr);

            // loop through employees array list
            for (int i = 0; i < listOfEmployees.size(); i++) {
                // get employee at index i
                Employee employee = listOfEmployees.get(i);
                // print employee
                System.out.println(employee);
                // delay of 1 second
                Thread.sleep(1000);
            } // catch InterruptedException
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}