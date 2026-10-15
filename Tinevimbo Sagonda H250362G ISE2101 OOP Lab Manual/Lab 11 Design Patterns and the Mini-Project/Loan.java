import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class Loan {
    private final String itemId;
    private final String memberId;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;

    public Loan(String itemId, String memberId,
                LocalDate borrowDate, LocalDate dueDate) {
        if (itemId == null || itemId.isBlank()
                || memberId == null || memberId.isBlank()) {
            throw new IllegalArgumentException(
                    "Item ID and member ID cannot be empty.");
        }
        if (borrowDate == null || dueDate == null
                || dueDate.isBefore(borrowDate)) {
            throw new IllegalArgumentException(
                    "Invalid borrow or due date.");
        }

        this.itemId = itemId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public String getItemId() {
        return itemId;
    }

    public String getMemberId() {
        return memberId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    public void markReturned() {
        returnDate = LocalDate.now();
    }

    /** Used when reloading a returned loan from CSV. */
    public void markReturnedFromCsv(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException(
                    "Return date cannot be null.");
        }
        returnDate = date;
    }

    public boolean isOverdue() {
        return !isReturned() && dueDate.isBefore(LocalDate.now());
    }

    public String toCsv() {
        return URLEncoder.encode(itemId, StandardCharsets.UTF_8) + ","
                + URLEncoder.encode(memberId, StandardCharsets.UTF_8) + ","
                + borrowDate + "," + dueDate + ","
                + (returnDate == null ? "" : returnDate);
    }

    @Override
    public String toString() {
        return itemId + " borrowed by " + memberId
                + " | Borrowed: " + borrowDate
                + " | Due: " + dueDate
                + (isReturned() ? " | Returned: " + returnDate
                        : (isOverdue() ? " | OVERDUE" : ""));
    }
}