package academy;

import java.util.List;
import java.util.UUID;
import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
    private String courseId;
    private String courseName;
    private int creditHours;

    // List to store students enrolled in the course
    private List<Student> enrolledStudents = new ArrayList<>();

    public Course(String courseName, int creditHours) {
        // Error handling during object creation
        AcademyErrorHandler.handleInvalidCourseName(courseName);
        AcademyErrorHandler.handleInvalidCreditHours(creditHours);

        this.courseId = generateCourseId();
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    private String generateCourseId() {
        return UUID.randomUUID().toString().substring(0, 9); // Generate unique 9-digit ID
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        AcademyErrorHandler.handleInvalidCourseName(courseName); // Handle error for invalid course name
        this.courseName = courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents; // Return the list of enrolled courses
    }

    public void setCreditHours(int creditHours) {
        AcademyErrorHandler.handleInvalidCreditHours(creditHours); // Handle error for invalid credit hours
        this.creditHours = creditHours;
    }

    // Method to enroll a student in the course
    public void enrollStudent(Student student) {
        // Error handling for null student
        AcademyErrorHandler.handleNullStudent(student);

        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            System.out.println(student.getName() + " has been enrolled in " + courseName);
        } else {
            System.out.println(student.getName() + " is already enrolled in " + courseName);
        }
    }

    // Method to list all students enrolled in the course
    public void listEnrolledStudents() {
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students are enrolled in " + courseName);
        } else {
            System.out.println("The following students are enrolled in " + courseName + ":");
            for (Student student : enrolledStudents) {
                System.out.println(student.getName());
            }
        }
    }

    public class Main {
    public static void main(String[] args) {
        // Creating courses with error handling
        try {
            Course mathCourse = new Course("Math 101", 3);
            Course historyCourse = new Course("History 101", 3);

            // Creating students
            Student student1 = new Student("John Doe", "john.doe@example.com");
            Student student2 = new Student("Jane Smith", "jane.smith@example.com");

            // Enrolling students with error handling
            mathCourse.enrollStudent(student1);
            mathCourse.enrollStudent(student2);
            historyCourse.enrollStudent(student1);

            // Attempting to enroll the same student again (will trigger error)
            mathCourse.enrollStudent(student1); // Should show that John Doe is already enrolled

            // Listing all enrolled students for each course
            mathCourse.listEnrolledStudents();
            historyCourse.listEnrolledStudents();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

}
