package academy;

import java.io.*;

public class DataManager {

    // Method to save all system data (students, courses, grades) to a text file
    public static void saveData(AcademySystem academySystem, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Save students
            for (Student student : academySystem.getStudents()) {
                writer.write("Student Name: " + student.getName() + ", Email: " + student.getEmail());
                writer.newLine();
            }

            // Save courses
            for (Course course : academySystem.getCourses()) {
                writer.write("Course Name: " + course.getCourseName() + ", Credit Hours: " + course.getCreditHours());
                writer.newLine();
            }

            // Save grades
            for (Grade grade : academySystem.getGrades()) {
                writer.write("Student: " + grade.getStudent().getName() + ", Course: " + grade.getCourse().getCourseName() + ", Grade: " + grade.getGradeValue());
                writer.newLine();
            }

            System.out.println("Data has been saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Method to load all system data (students, courses, grades) from a text file
    public static void loadData(AcademySystem academySystem, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Logic for loading the data. For simplicity, this example assumes data is loaded directly from the file.
                // You will need to parse the data and create Student, Course, and Grade objects accordingly.
                System.out.println(line);
            }

            System.out.println("Data has been loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    // Method to serialize system data (students, courses, grades) to a file
    public static void serializeFile(AcademySystem academySystem, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(academySystem);
            System.out.println("Data has been serialized and saved successfully.");
        } catch (IOException e) {
            System.out.println("Error serializing data: " + e.getMessage());
        }
    }

    // Deserialize the file and return the AcademySystem object
    public static AcademySystem deserializeFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (AcademySystem) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error deserializing data: " + e.getMessage());
            return null;
        }
    }
}
