import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

class Book {
    private String title;
    private String isbn;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Book)) {
            return false;
        }

        Book other = (Book) obj;
        return Objects.equals(this.isbn, other.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return title + " (ISBN: " + isbn + ")";
    }
}

public class BookD {
    public static void main(String[] args) {
        Set<Book> books = new HashSet<>();

        Book book1 = new Book("Java Basics", "9781234567890");
        Book book2 = new Book("Advanced Java", "9781234567890");
        Book book3 = new Book("Python Basics", "9780987654321");

        System.out.println("Added book1: " + books.add(book1));
        System.out.println("Added book2: " + books.add(book2));
        System.out.println("Added book3: " + books.add(book3));

        System.out.println("\nBooks in the set:");
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("\nTotal books: " + books.size());
    }
}