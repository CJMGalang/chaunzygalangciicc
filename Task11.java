class Book {

    private String title;
    private String author;
    private int yearPublished;
    private double price;

    public Book(String title, String author, int yearPublished, double price) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public double getPrice() {
        return price;
    }

    public String toString () {

        return
                "Title: " + getTitle() + "\n" +
                "Author: " + getAuthor() + "\n" +
                "Year Published: " + getYearPublished() + "\n" +
                "Price: $" + getPrice() + "\n";

    }

}

public class Task11 {

    public static void main (String [] args) {

        int i = 0;

        Book[] book = new Book[] {
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 14.99),
                new Book("To Kill a Mockingbird", "Harper Lee", 1960, 12.99),
                new Book("1984", "George Orwell", 1949, 9.99)
        };

        for (Book b : book) {
            System.out.println("Book " + ++i + ":");
            System.out.println(b.toString());
        }
    }
}
