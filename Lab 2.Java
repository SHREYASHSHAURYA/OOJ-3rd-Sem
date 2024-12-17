import java.util.Scanner;
class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    int numberOfSubjects;

    public void acceptDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter USN: ");
        usn = scanner.nextLine();
        System.out.print("Enter Name: ");
        name = scanner.nextLine();

        System.out.print("Enter the number of subjects: ");
        numberOfSubjects = scanner.nextInt();
        
        credits = new int[numberOfSubjects];
        marks = new int[numberOfSubjects];

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = scanner.nextInt();
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }

    public void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.print("Credits: ");
        for (int credit : credits) {
            System.out.print(credit + " ");
        }
        System.out.println();
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    public double calculateSGPA() {
        double totalWeightedMarks = 0;
        int totalCredits = 0;

        for (int i = 0; i < numberOfSubjects; i++) {
            totalCredits += credits[i];
            totalWeightedMarks +=( marks[i]/10 +1) * credits[i];
        }

        return totalWeightedMarks / totalCredits;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();

        student.acceptDetails();
        student.displayDetails();

        double sgpa = student.calculateSGPA();
        System.out.println("SGPA of the student: " + sgpa);

        scanner.close();
    }
}
