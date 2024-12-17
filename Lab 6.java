package CIE;

public class Internals extends Student {
    public int[] internalMarks = new int[5];

    public void setInternalMarks(int[] marks) {
        for (int i = 0; i < 5; i++) {
            internalMarks[i] = marks[i];
        }
    }

    public int[] getInternalMarks() {
        return internalMarks;
    }
}
package CIE;

public class Student {
    public String usn;
    public String name;
    public int sem;
}
package SEE;

import CIE.Student;

public class External extends Student {
    public int[] seeMarks = new int[5];

    public void setSEEMarks(int[] marks) {
        for (int i = 0; i < 5; i++) {
            seeMarks[i] = marks[i];
        }
    }

    public int[] getSEEMarks() {
        return seeMarks;
    }
}
import CIE.*;
import SEE.*;

import java.util.Scanner;

public class FinalMarksCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        Student[] students = new Student[n];
        Internals[] internalMarks = new Internals[n];
        External[] seeMarks = new External[n];

        for (int i = 0; i < n; i++) {
            students[i] = new Student();
            internalMarks[i] = new Internals();
            seeMarks[i] = new External();

            System.out.print("Enter USN for Student " + (i + 1) + ": ");
            students[i].usn = sc.next();
            sc.nextLine(); 

            System.out.print("Enter Name for Student " + (i + 1) + ": ");
            students[i].name = sc.nextLine();

            System.out.print("Enter Semester for Student " + (i + 1) + ": ");
            students[i].sem = sc.nextInt();

            int[] internals = new int[5];
            System.out.println("Enter Internal Marks (5 courses) for Student " + (i + 1) + ": ");
            for (int j = 0; j < 5; j++) {
                internals[j] = sc.nextInt();
            }
            internalMarks[i].setInternalMarks(internals);

            int[] see = new int[5];
            System.out.println("Enter SEE Marks (5 courses) for Student " + (i + 1) + ": ");
            for (int j = 0; j < 5; j++) {
                see[j] = sc.nextInt();
            }
            seeMarks[i].setSEEMarks(see);
        }

        System.out.println("\nFinal Marks of Students:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ": " + students[i].name + " (USN: " + students[i].usn + ")");
            System.out.println("Course\tInternal\tSEE\tFinal Marks");
            for (int j = 0; j < 5; j++) {
                int finalMark = internalMarks[i].getInternalMarks()[j] + seeMarks[i].getSEEMarks()[j];
                System.out.println("Course " + (j + 1) + ":\t" + internalMarks[i].getInternalMarks()[j] + "\t\t" + seeMarks[i].getSEEMarks()[j] + "\t" + finalMark);
            }
        }
       
        sc.close();
    }
}
