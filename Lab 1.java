import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();
        double d = b * b - 4 * a * c;
        double x1,x2;
       
        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("The real solutions are x1 = " + x1 + " and x2 = " + x2);
        } else if (d == 0) {
            x1 = -b / (2 * a);
            System.out.println("There is one real solution: x = " + x1);
        } else {
            System.out.println("There are no real solutions.");
        }
    }
                  }
