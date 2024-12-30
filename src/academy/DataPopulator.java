package academy;

public class DataPopulator {

    // Method to populate the academy with some students, courses, and grades
    public static void populateAcademy(AcademySystem academySystem) {
        // Create some students
        Student student1 = new Student("John Doe", "johndoe@example.com");
        Student student2 = new Student("Jane Smith", "janesmith@example.com");
        Student student3 = new Student("Alice Brown", "alicebrown@example.com");

        // Add students to the system
        academySystem.addStudent(student1);
        academySystem.addStudent(student2);
        academySystem.addStudent(student3);

        // Create some courses
        Course course1 = new Course("Java Programming", 3);
        Course course2 = new Course("Data Structures", 4);
        Course course3 = new Course("Web Development", 3);

        // Add courses to the system
        academySystem.addCourse(course1);
        academySystem.addCourse(course2);
        academySystem.addCourse(course3);

        // Enroll students in courses
        academySystem.enrollStudentInCourse(student1.getStudentId(), course1.getCourseId());
        academySystem.enrollStudentInCourse(student2.getStudentId(), course2.getCourseId());
        academySystem.enrollStudentInCourse(student3.getStudentId(), course3.getCourseId());

        // Add some grades
        academySystem.addGrade(student1.getStudentId(), course1.getCourseId(), 90.0);
        academySystem.addGrade(student2.getStudentId(), course2.getCourseId(), 85.5);
        academySystem.addGrade(student3.getStudentId(), course3.getCourseId(), 92.0);
    }
}
