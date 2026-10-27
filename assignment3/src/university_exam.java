import java.util.Scanner;

// Custom Exception
class Invalid_registration_exception extends Exception {
    Invalid_registration_exception(String message) {
        super(message);
    }
}

// Exam Registration Class
class Exam_registration {

    public static void validate_registration(
            String studentID, int age, double exam_mark, int subjects
    ) throws Invalid_registration_exception {

        if (studentID.isEmpty()) {
            throw new Invalid_registration_exception(
                    "Student ID cannot be empty."
            );
        }

        if (age < 18) {
            throw new Invalid_registration_exception(
                    "Age must be at least 18."
            );
        }

        if (exam_mark < 0 || exam_mark > 100) {
            throw new Invalid_registration_exception(
                    "Exam marks must be between 0 and 100."
            );
        }

        if (subjects < 1 || subjects > 5) {
            throw new Invalid_registration_exception(
                    "Maximum allowed subjects is 5."
            );
        }
    }
}

// Main Class
public class university_exam {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== EXAM REGISTRATION SYSTEM =====");

        try {
            System.out.print("Enter Student ID: ");
            String studentID = input.nextLine();

            System.out.print("Enter Student Name: ");
            String studentName = input.nextLine();

            System.out.print("Enter Age: ");
            int age = input.nextInt();

            System.out.print("Enter Exam Mark: ");
            double exam_mark = input.nextDouble();

            System.out.print("Enter Number of Subjects: ");
            int subjects = input.nextInt();

            Exam_registration.validate_registration(
                    studentID, age, exam_mark, subjects
            );

            System.out.println("\nRegistration Successful!");
            System.out.println("Student ID: " + studentID);
            System.out.println("Student: " + studentName);
            System.out.println("Age: " + age);
            System.out.println("Exam Mark: " + exam_mark);
            System.out.println("Registered Subjects: " + subjects);

        } catch (Invalid_registration_exception e) {

            System.out.println("\nRegistration Failed!");
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {

            System.out.println("\nRegistration Failed!");
            System.out.println("Error: Please enter valid input.");

        } finally {

            System.out.println("\nRegistration attempt completed.");
            input.close();
        }
    }
}