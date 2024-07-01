class Course {
    private String id;
    private String name;
    private int lectureCredits;
    private int labCredits;

    // Consturex
    public Course(String id, String name, int lectureCredits, int labCredits) {
        this.id = id;
        this.name = name.toUpperCase(); // Convert name to upper case
        this.lectureCredits = lectureCredits;
        this.labCredits = labCredits;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLectureCredits() {
        return lectureCredits;
    }

    public int getLabCredits() {
        return labCredits;
    }
}