import java.util.Scanner;
class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}

class Father {
    int age;

    public Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative!");
        }
        this.age = age;
    }
}

class Son extends Father {
    int sonAge;

    public Son(int fatherAge, int sonAge) throws WrongAge {
      
        super(fatherAge);

        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to the father's age!");
        }

        this.sonAge = sonAge;
    }
}

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.print("Enter Father's Age: ");
            int fatherAge = scanner.nextInt();

            System.out.print("Enter Son's Age: ");
            int sonAge = scanner.nextInt();

            Son son = new Son(fatherAge, sonAge);
            System.out.println("Father's Age: " + fatherAge);
            System.out.println("Son's Age: " + son.sonAge);
        } catch (WrongAge e) {
           
            System.out.println("Error: " + e.getMessage());
        } finally {
   
            scanner.close();
        }
    }
}
