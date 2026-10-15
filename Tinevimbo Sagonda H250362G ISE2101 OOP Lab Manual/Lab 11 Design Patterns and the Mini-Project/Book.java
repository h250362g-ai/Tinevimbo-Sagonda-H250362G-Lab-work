public class Book extends LibraryItem {
    private final String author;

    public Book(String id, String title, String author) {
        super(id, title);

        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException(
                    "Author cannot be empty.");
        }

        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int loanPeriodDays() {
        return 14;
    }

    @Override
    public String toString() {
        return "Book | " + super.toString()
                + " | Author: " + author;
    }
}
