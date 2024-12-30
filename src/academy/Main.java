package academy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AcademySystem academySystem = new AcademySystem();
        Scanner scanner = new Scanner(System.in);

        // Populate the system with sample data
        DataPopulator.populateAcademy(academySystem);

        // Start the console app
        runConsoleApp(academySystem, scanner);
    }

    private static void runConsoleApp(AcademySystem academySystem, Scanner scanner) {
        while (true) {
            displayMenu();

            int choice = getUserChoice(scanner);

            handleMenuOption(choice, academySystem, scanner);
        }
    }

    private static void handleMenuOption(int choice, AcademySystem academySystem, Scanner scanner) {
        scanner.nextLine(); // Consume the newline character from previous input

        switch (choice) {
            case 1 -> addStudent(academySystem, scanner);
            case 2 -> addCourse(academySystem, scanner);
            case 3 -> enrollStudent(academySystem, scanner);
            case 4 -> recordGrade(academySystem, scanner);
            case 5 -> academySystem.showAllStudents();
            case 6 -> academySystem.showAllCourses();
            case 7 -> academySystem.showAllGrades();
            case 8 -> saveData(academySystem);
            case 9 -> loadData(academySystem);
            case 10 -> exportData(academySystem);
            case 11 -> importData(academySystem);
            case 12 -> {
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0); // Exit the program
            }
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

    private static void displayMenu() {
        System.out.println("\nAcademy Management System");
        System.out.printf("%-30s%-30s%-30s%n", "1. Add Student", "2. Add Course", "3. Enroll Student");
        System.out.printf("%-30s%-30s%-30s%n", "4. Record Grade", "5. Show All Students", "6. Show All Courses");
        System.out.printf("%-30s%-30s%-30s%n", "7. Show All Grades", "8. Save Data (to file)",
                "9. Load Data (read last saved file)");
        System.out.printf("%-30s%-30s%-30s%n", "10. Export Data (Serialized)", "11. Import Data (Serialized)",
                "12. Exit");
        System.out.print("\nChoose an option: ");
    }

    private static int getUserChoice(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear buffer
            return -1; // Return an invalid option
        }
    }

    private static void addStudent(AcademySystem academySystem, Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student email: ");
        String email = scanner.nextLine();
        try {
            academySystem.addStudent(name, email);
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    private static void addCourse(AcademySystem academySystem, Scanner scanner) {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter credit hours: ");
        int creditHours = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        try {
            academySystem.addCourse(new Course(courseName, creditHours));
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding course: " + e.getMessage());
        }
    }

    private static void enrollStudent(AcademySystem academySystem, Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();
        try {
            academySystem.enrollStudentInCourse(studentId, courseId);
        } catch (IllegalArgumentException e) {
            System.out.println("Error enrolling student: " + e.getMessage());
        }
    }

    private static void recordGrade(AcademySystem academySystem, Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();
        try {
            academySystem.addGrade(studentId, courseId, grade);
        } catch (IllegalArgumentException e) {
            System.out.println("Error recording grade: " + e.getMessage());
        }
    }

    private static void saveData(AcademySystem academySystem) {
        try {
            DataManager.saveData(academySystem, "academy_system_data.txt");
            System.out.println("Data saved.");
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void loadData(AcademySystem academySystem) {
        try {
            DataManager.loadData(academySystem, "academy_system_data.txt");
            System.out.println("Data loaded.");
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    private static void exportData(AcademySystem academySystem) {
        try {
            DataManager.serializeFile(academySystem, "academy_system_data.ser");
            System.out.println("Data exported (serialized).");
        } catch (Exception e) {
            System.out.println("Error exporting data: " + e.getMessage());
        }
    }

    private static void importData(AcademySystem academySystem) {
        try {
            academySystem = DataManager.deserializeFile("academy_system_data.ser");
            System.out.println("Data imported (deserialized).");
        } catch (Exception e) {
            System.out.println("Error importing data: " + e.getMessage());
        }
    }
}
