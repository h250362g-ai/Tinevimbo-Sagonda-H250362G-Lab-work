import java.time.LocalDate;

public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;
    private Member borrowedBy;
    private LocalDate dueDate;

    public LibraryItem(String id, String title) {
        if (id == null || id.isBlank()
                || title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "ID and title cannot be empty.");
        }

        this.id = id.trim();
        this.title = title.trim();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public Member getBorrowedBy() {
        return borrowedBy;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public abstract int loanPeriodDays();

    @Override
    public void borrow(Member member)
            throws ItemNotAvailableException,
                   MemberLimitExceededException {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }

        if (!available) {
            throw new ItemNotAvailableException(
                    "Item is already borrowed.");
        }

        if (!member.canBorrow()) {
            throw new MemberLimitExceededException(
                    "A member cannot borrow more than "
                            + Member.MAX_LOANS + " items.");
        }

        member.addLoan();
        available = false;
        borrowedBy = member;
        dueDate = LocalDate.now().plusDays(loanPeriodDays());
    }

    /**
     * Restores a borrowed state from saved data, keeping the
     * original due date instead of calculating a new one.
     */
    public void restoreBorrowed(Member member, LocalDate originalDueDate) {
        if (member == null || originalDueDate == null) {
            throw new IllegalArgumentException(
                    "Member and due date are required.");
        }

        member.addLoan();
        available = false;
        borrowedBy = member;
        dueDate = originalDueDate;
    }

    @Override
    public void giveBack() {
        if (available) {
            throw new IllegalStateException(
                    "This item has not been borrowed.");
        }

        borrowedBy.removeLoan();
        borrowedBy = null;
        dueDate = null;
        available = true;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | "
                + (available ? "Available" : "Borrowed")
                + (dueDate == null ? "" : " | Due: " + dueDate);
    }
}