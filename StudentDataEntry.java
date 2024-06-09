import java.io.BufferedWriter;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.util.Collections;  
import java.util.LinkedList;  
import java.util.Scanner;  

public class StudentDataEntry {  
    public static void main(String[] args) {  // Main method starts
        LinkedList<Student> students = new LinkedList<>();  // Create a LinkedList to store Student objects
        Scanner scnr = new Scanner(System.in);  // Create a Scanner object to read input from the user
        String name, address, input;  // Declare variables to store user input
        double GPA;  // Declare variable to store the student's GPA
        
        // Start a loop to continuously prompt the user for student data
        while (true) {  // Infinite loop starts
            System.out.print("Enter student name (or 'done' to finish): ");  // Prompt user to enter the student's name
            name = scnr.nextLine();  // Read the student's name from the input
            if (name.equalsIgnoreCase("done")) {  // Check if the user wants to finish entering data
                break;  // Exit the loop if 'done' is entered
            }  // End of if block
            // Check if the name is empty
            if (name.trim().isEmpty()) {
                System.out.println("Name cannot be empty. Please enter a valid name.");
                continue;  // Prompt again for valid name
            }  // End of if block

            System.out.print("Enter student address: ");  // Prompt user to enter the student's address
            address = scnr.nextLine();  // Read the student's address from the input
            // Check if the address is empty
            if (address.trim().isEmpty()) {
                System.out.println("Address cannot be empty. Please enter a valid address.");
                continue;  // Prompt again for valid address
            }  // End of if block

            // Start a loop to validate the GPA input
            while (true) {  // Infinite loop starts
                System.out.print("Enter student GPA: ");  // Prompt user to enter the student's GPA
                input = scnr.nextLine();  // Read the GPA input from the user
                // Check if the GPA is empty
                if (input.trim().isEmpty()) {
                    System.out.println("GPA cannot be empty. Please enter a valid GPA.");
                    continue;  // Prompt again for valid GPA
                }  // End of if block
                try {
                    GPA = Double.parseDouble(input);  // Try to convert the input to a double
                    if (GPA < 0) {  // Check if the GPA is negative
                        System.out.println("GPA cannot be negative. Please enter a valid GPA.");
                    } else {
                        break;  // Exit the loop if the input is a valid number and not negative
                    }
                } catch (NumberFormatException e) {  // Catch exception if input is not a valid number
                    System.out.println("Invalid GPA. Please enter a numeric value.");  // Print error message
                }  // End of catch block
            }  // End of inner while loop

            students.add(new Student(name, address, GPA));  // Create a new Student object and add it to the list
        }  // End of outer while loop

        // Close the Scanner object
        scnr.close();

        // Sort the list of students by their names using the comparator
        Collections.sort(students, Student.nameComparator);

        // Write the sorted list of students to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {  // Try-with-resources block starts
            for (Student student : students) {  // Iterate over each student in the list
                writer.write(student.toString());  // Write the student's details to the file
                writer.newLine();  // Add a new line after each student's details
            }  // End of for loop
            System.out.println("Student data has been written to students.txt.");  // Confirm that data has been written
        } catch (IOException e) {  // Catch any exceptions that occur during file writing
            System.out.println("An error occurred while writing to the file.");  // Print error message
            e.printStackTrace();  // Print stack trace for debugging
        }  // End of catch block
    }  // End of main method
}  // End of StudentDataEntry class
