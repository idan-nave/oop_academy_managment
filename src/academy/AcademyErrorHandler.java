package academy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcademyErrorHandler {

    // Error handler for invalid grade value
    public static void handleInvalidGradeValue(double gradeValue) {
        if (gradeValue < 0 || gradeValue > 100) {
            throw new IllegalArgumentException("Invalid grade value: " + gradeValue + ". Grade must be between 0 and 100.");
        }
    }

    // Error handler for null student
    public static void handleNullStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }
    }

    // Error handler for null course
    public static void handleNullCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null.");
        }
    }

    // Error handler for invalid email format
    public static void handleInvalidEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }

        // Regular expression for simple email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }
    }

    // Error handler for empty or null name
    public static void handleInvalidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
    }

    // Error handler for duplicate course enrollment
    public static void handleDuplicateEnrollment(Student student, Course course) {
        if (student.getEnrolledCourses().contains(course) || course.getEnrolledStudents().contains(student)) {
            throw new IllegalArgumentException(student.getName() + " is already enrolled in " + course.getCourseName());
        }
    }

    // Generic error handler
    public static void handleError(String errorMessage) {
        System.err.println("Error: " + errorMessage);
        // Optionally, log this error to a file or reporting system
    }


    // Handle invalid course name (should not be null or empty)
    public static void handleInvalidCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty.");
        }
    }

    // Handle invalid credit hours (should be positive)
    public static void handleInvalidCreditHours(int creditHours) {
        if (creditHours <= 0) {
            throw new IllegalArgumentException("Credit hours must be a positive number.");
        }
    }

}
