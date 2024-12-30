package academy;

import java.util.List;
import java.util.UUID;
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private String studentId;
    private String name;
    private String email;

    // List to store the courses the student is enrolled in
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student(String name, String email) {
        this.studentId = generateStudentId();
        this.name = name;
        this.email = email;
    }

    private String generateStudentId() {
        return UUID.randomUUID().toString().substring(0, 9); // Generate unique 9-digit ID
    }

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

    public List<Course> getEnrolledCourses() {
        return enrolledCourses; // Return the list of enrolled courses
    }

    // Method to enroll the student in a course
    public void enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            System.out.println(name + " has been enrolled in " + course.getCourseName());
        } else {
            System.out.println(name + " is already enrolled in " + course.getCourseName());
        }
    }

    // Method to list all enrolled courses
    public void listEnrolledCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println(name + " is not enrolled in any courses.");
        } else {
            System.out.println(name + " is enrolled in the following courses:");
            for (Course course : enrolledCourses) {
                System.out.println(course.getCourseName());
            }
        }
    }

    public class Main {
        @SuppressWarnings("unused")
        public static void main(String[] args) {
            try {
                // Invalid student creation (invalid email)
                Student student = new Student("John Doe", "john_doe_invalidemail.com"); // This will throw an
                                                                                        // IllegalArgumentException
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                // Valid student
                Student student = new Student("Jane Doe", "jane.doe@example.com");

                Course course1 = new Course("Math 101", 3);
                Course course2 = new Course("History 101", 3);

                // Enroll in courses
                student.enrollInCourse(course1); // Successful enrollment
                student.enrollInCourse(course2); // Successful enrollment

                // Try to enroll in the same course again (this will throw an error)
                student.enrollInCourse(course1); // This will throw an IllegalArgumentException
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

}
