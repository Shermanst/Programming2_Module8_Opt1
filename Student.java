import java.util.Comparator;  

public class Student {  // Class definition starts
    private String name;  // Private field for storing the student's name
    private String address;  // Private field for storing the student's address
    private double GPA;  // Private field for storing the student's GPA

    // Constructor to initialize the student's name, address, and GPA
    public Student(String name, String address, double GPA) {
        this.name = name.toUpperCase();
        this.address = address.toUpperCase();
        this.GPA = GPA;
    }

    // Getter method to retrieve the student's name
    public String getName() {
        return name;
    }

    // Getter method to retrieve the student's address
    public String getAddress() {
        return address;
    }

    // Getter method to retrieve the student's GPA
    public double getGPA() {
        return GPA;
    }

    // Override the toString method to provide a string representation of the student object
    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", GPA: " + GPA;
    }

    // Comparator to compare two Student objects by their names for sorting purposes
    public static Comparator<Student> nameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            // Compare the names of the two students
            return s1.getName().compareTo(s2.getName());
        }  // End of compare method
    };  // End of Comparator anonymous class
}  // End of Student class