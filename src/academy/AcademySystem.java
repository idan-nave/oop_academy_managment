package academy;

import java.io.Serializable;
import java.util.*;

public class AcademySystem implements Serializable {

    // Lists to hold all the objects in the system
    private List<Student> students;
    private List<Course> courses;
    private List<Grade> grades;

    // Constructor to initialize lists
    public AcademySystem() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    // Getter and setter methods for students, courses, and grades
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    // singular-object methods

    // Method to add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Overloaded Method to add a student
    public void addStudent(String name, String email) {
        // Create a new Student object and add it to the students list
        students.add(new Student(name, email));
    }

    // Method to remove a student from the system by their student ID
    public void removeStudent(String studentId) {
        // Remove the student by matching their studentId
        students.removeIf(student -> student.getStudentId().equals(studentId));
    }

    // Method to retrieve a student by their student ID
    public Student getStudentById(String studentId) {
        // Search for a student with the given studentId, return null if not found
        return students.stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst()
                .orElse(null);
    }

    // Method to add a course to the system
    public void addCourse(Course course) {
        courses.add(course); // Add the course to the courses list
    }

    // Method to remove a course from the system by course ID
    public void removeCourse(String courseId) {
        // Remove the course by matching its courseId
        courses.removeIf(course -> course.getCourseId().equals(courseId));
    }

    // Method to retrieve a course by its course ID
    public Course getCourseById(String courseId) {
        // Search for a course with the given courseId, return null if not found
        return courses.stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);
    }

    // Method to add a grade for a student in a specific course
    public void addGrade(String studentId, String courseId, double gradeValue) {
        // Retrieve the student and course by their IDs
        Student student = getStudentById(studentId);
        Course course = getCourseById(courseId);

        // Check if both student and course exist
        if (student != null && course != null) {
            // Create a new Grade object and add it to the grades list
            grades.add(new Grade(student, course, gradeValue));
        } else {
            // Print error message if student or course is invalid
            System.out.println("Invalid student or course ID.");
        }
    }

    // Method to enroll a student in a specific course by their IDs
    public void enrollStudentInCourse(String studentId, String courseId) {
        // Retrieve the student and course by their IDs
        Student student = getStudentById(studentId);
        Course course = getCourseById(courseId);

        // Check if both student and course exist
        if (student != null && course != null) {
            // Print confirmation of successful enrollment
            student.enrollInCourse(course);
            System.out.println("Student " + student.getName() + " enrolled in course " + course.getCourseName());
        } else {
            // Print error message if student or course is invalid
            System.out.println("Invalid student or course ID.");
        }
    }

    // Method to display all students with their details
    public void showAllStudents() {
        // Iterate through the list of students and print their information
        students.forEach(student -> System.out
                .println("Student ID: " + student.getStudentId() + ", Name: " + student.getName()));
    }

    // Method to display all courses with their details
    public void showAllCourses() {
        // Iterate through the list of courses and print their information
        courses.forEach(course -> System.out
                .println("Course ID: " + course.getCourseId() + ", Name: " + course.getCourseName()));
    }

    // Method to display all grades with their details
    public void showAllGrades() {
        // Iterate through the list of grades and print the student, course, and grade
        // information
        grades.forEach(grade -> System.out.println("Student: " + grade.getStudent().getName() + ", Course: "
                + grade.getCourse().getCourseName() + ", Grade: " + grade.getGradeValue()));
    }

    // Method to save all system data (students, courses, grades) to a file
    public void saveData(String filename) {
        // File save logic (using FileHandler class for file operations)
    }

    // Method to load all system data (students, courses, grades) from a file
    public void loadData(String filename) {
        // File load logic (using FileHandler class for file operations)
    }
}
