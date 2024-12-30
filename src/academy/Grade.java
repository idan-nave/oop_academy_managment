package academy;

import java.io.Serializable;

public class Grade implements Serializable {
    private Student student;
    private Course course;
    private double gradeValue;

    public Grade(Student student, Course course, double gradeValue) {
        // Error handling during object creation
        AcademyErrorHandler.handleNullStudent(student);
        AcademyErrorHandler.handleNullCourse(course);
        AcademyErrorHandler.handleInvalidGradeValue(gradeValue);

        this.student = student;
        this.course = course;
        this.gradeValue = gradeValue;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        AcademyErrorHandler.handleNullStudent(student);
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        AcademyErrorHandler.handleNullCourse(course);
        this.course = course;
    }

    public double getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(double gradeValue) {
        AcademyErrorHandler.handleInvalidGradeValue(gradeValue);
        this.gradeValue = gradeValue;
    }

    public class Main {
        @SuppressWarnings("unused")
        public static void main(String[] args) {
            try {
                Student student = new Student("John", "john@example.com");
                Course course = new Course("Math 101", 3);

                // Invalid grade value (below 0)
                Grade grade = new Grade(student, course, -5); // This will throw an IllegalArgumentException

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                // Null student
                Grade grade = new Grade(null, new Course("History 101", 4), 85); // This will throw an
                                                                                 // IllegalArgumentException
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

}
