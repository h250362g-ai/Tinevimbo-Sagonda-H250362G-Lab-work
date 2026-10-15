public class Member {
    public static final int MAX_LOANS = 3;

    private final String id;
    private final String name;
    private int activeLoans;

    public Member(String id, String name) {
        if (id == null || id.isBlank()
                || name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Member ID and name cannot be empty.");
        }

        this.id = id.trim();
        this.name = name.trim();
        this.activeLoans = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getActiveLoans() {
        return activeLoans;
    }

    public boolean canBorrow() {
        return activeLoans < MAX_LOANS;
    }

    public void addLoan() {
        if (!canBorrow()) {
            throw new IllegalStateException("Loan limit reached.");
        }
        activeLoans++;
    }

    public void removeLoan() {
        if (activeLoans > 0) {
            activeLoans--;
        }
    }

    @Override
    public String toString() {
        return id + " | " + name
                + " | Active loans: " + activeLoans;
    }
}