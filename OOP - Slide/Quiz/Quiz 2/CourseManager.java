import java.util.HashMap;

public class CourseManager {
    private HashMap<String, Course> courses;

    public CourseManager() {
        courses = new HashMap<>();
    }

    public boolean addCourse(String id, String name, int lectureCredits, int labCredits) {
        if (id.isEmpty() || courses.containsKey(id) || lectureCredits <= 0 || labCredits < 0) {
            return false; // Invalid parameters
        }
        Course course = new Course(id, name, lectureCredits, labCredits);
        courses.put(id, course);
        return true;
    }

    public Course getCourse(String id) {
        return courses.get(id);
    }

    // Other methods like removeCourse, updateCourseDetails, etc. can be added here.
}