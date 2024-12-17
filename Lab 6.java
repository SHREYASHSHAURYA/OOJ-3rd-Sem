package CIE;
public class Personal {
    public String usn;
    public String name;
    public int sem;

    public Personal(String usn, String name, int sem) {
        this.usn = usn;
        this.name = name;
        this.sem = sem;
    }
}

package SEE;
import CIE.Personal;
import CIE.Internals;

public class External extends Personal {
    public int[] externalMarks = new int[5];

    public External(String usn, String name, int sem, int[] externalMarks) {
        super(usn, name, sem); 
        this.externalMarks = externalMarks;
    }

    public int[] calculateFinalMarks(Internals internals) {
        int[] finalMarks = new int[5];
        int[] internalMarks = internals.internalMarks;

        for (int i = 0; i < 5; i++) {
            finalMarks[i] = internalMarks[i] + externalMarks[i];
        }

        return finalMarks;
    }
}

import CIE.Internals;
import SEE.External;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        sc.nextLine();  

        for (int i = 0; i < n; i++) {
           
            System.out.println("\nEnter details for student " + (i + 1));

            System.out.print("Enter USN: ");
            String usn = sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter semester: ");
            int sem = sc.nextInt();
            sc.nextLine(); 

            int[] internalMarks = new int[5];
            System.out.println("Enter internal marks for 5 courses:");
            for (int j = 0; j < 5; j++) {
                System.out.print("Course " + (j + 1) + ": ");
                internalMarks[j] = sc.nextInt();
            }
            sc.nextLine(); 

            Internals internals = new Internals(internalMarks);

            int[] externalMarks = new int[5];
            System.out.println("Enter external marks for 5 courses:");
            for (int j = 0; j < 5; j++) {
                System.out.print("Course " + (j + 1) + ": ");
                externalMarks[j] = sc.nextInt();
            }
            sc.nextLine();  
            External external = new External(usn, name, sem, externalMarks);

            int[] finalMarks = external.calculateFinalMarks(internals);

            System.out.println("\nFinal marks for " + external.name + " (" + external.usn + "):");
            for (int j = 0; j < 5; j++) {
                System.out.println("Course " + (j + 1) + ": " + finalMarks[j]);
            }
        }

        sc.close();


    }
}
