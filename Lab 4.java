import java.util.Scanner;
abstract class Shape {
    int dimension1, dimension2;
    abstract void printArea();
}

class Rectangle extends Shape {
 
    public Rectangle(int length, int width) {
        this.dimension1 = length;
        this.dimension2 = width;
    }

    void printArea() {
        int area = dimension1 * dimension2;
        System.out.println("Area of Rectangle: " + area);
    }
}

class Triangle extends Shape {
   
    public Triangle(int base, int height) {
        this.dimension1 = base;
        this.dimension2 = height;
    }

    void printArea() {
        double area = 0.5 * dimension1 * dimension2;
        System.out.println("Area of Triangle: " + area);
    }
}

class Circle extends Shape {
   
    public Circle(int radius) {
        this.dimension1 = radius;
    }

    void printArea() {
        double area = 3.14* dimension1 * dimension1;
        System.out.println("Area of Circle: " + area);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of rectangle: ");
        int length = scanner.nextInt();
        System.out.print("Enter width of rectangle: ");
        int width = scanner.nextInt();
        Shape rectangle = new Rectangle(length, width);

        System.out.print("Enter base of triangle: ");
        int base = scanner.nextInt();
        System.out.print("Enter height of triangle: ");
        int height = scanner.nextInt();
        Shape triangle = new Triangle(base, height);

        System.out.print("Enter radius of circle: ");
        int radius = scanner.nextInt();
        Shape circle = new Circle(radius);

        rectangle.printArea();
        triangle.printArea();
        circle.printArea();

        scanner.close();
    }
}
