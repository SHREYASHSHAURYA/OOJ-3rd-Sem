import java.util.Scanner;
class Book {
    private String name;
    private String author;
    private double price;
    private int numPages;

    public Book(String name, String author, double price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public double getPrice() {
        return this.price;
    }

    public int getNumPages() {
        return this.numPages;
    }

    public String toString() {
        return "Book Name: " + name + "\n" +
               "Author: " + author + "\n" +
               "Price: $" + price + "\n" +
               "Number of Pages: " + numPages;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int n = obj.nextInt();
        obj.nextLine();

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for book " + (i + 1) + ":");

            System.out.print("Enter book name: ");
            String name = obj.nextLine();

            System.out.print("Enter author name: ");
            String author = obj.nextLine();

            System.out.print("Enter price: ");
            double price = obj.nextDouble();

            System.out.print("Enter number of pages: ");
            int numPages = obj.nextInt();
            obj.nextLine();

            books[i] = new Book(name, author, price, numPages);
        }

        System.out.println("\nBook Details:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nBook " + (i + 1) + ":");
            System.out.println(books[i].toString());
        }
        obj.close();
    }
}
