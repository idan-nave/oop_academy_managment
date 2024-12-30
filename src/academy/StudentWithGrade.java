package academy;

import java.util.ArrayList;
import java.util.List;

public class StudentWithGrade {

    // Fields for student details and course-grade relationship
    private String studentId;
    private String name;
    private String email;
    private List<Course> courses;
    private List<Double> grades;

    // Constructor to initialize the student
    public StudentWithGrade(String studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.courses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    // Getters and setters for student details
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Methods to manage courses and grades

    // Add a course to the student
    public void addCourse(Course course) {
        this.courses.add(course);
    }

    // Add a grade for the student
    public void addGrade(double grade) {
        this.grades.add(grade);
    }

    // Get all courses for the student
    public List<Course> getCourses() {
        return this.courses;
    }

    // Get all grades for the student
    public List<Double> getGrades() {
        return this.grades;
    }

    // Method to get the grade for a specific course by courseId
    public Double getGradeForCourse(String courseId) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equals(courseId)) {
                return grades.get(i);
            }
        }
        return null;  // Return null if the course is not found
    }

    // Method to display the student's details along with courses and grades
    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Courses and Grades: ");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("Course: " + courses.get(i).getCourseName() + ", Grade: " + grades.get(i));
        }
    }
    
    public static void main(String[] args) {

        // Create some courses
        Course math = new Course("Mathematics", 3);
        Course science = new Course("Science", 4);

        // Create a StudentWithGrade
        StudentWithGrade student1 = new StudentWithGrade("S001", "John Doe", "john.doe@example.com");

        // Add courses to the student
        student1.addCourse(math);
        student1.addCourse(science);

        // Add grades to the student for the respective courses
        student1.addGrade(90.5);  // Grade for CSE101 (Math)
        student1.addGrade(85.0);  // Grade for CSE102 (Science)

        // Display student details
        student1.displayStudentDetails();

        // Retrieve grade for a specific course
        Double gradeForMath = student1.getGradeForCourse(math.getCourseId());
        System.out.println("Grade for Mathematics: " + gradeForMath);
    }
}