import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();

    private final Path itemsFile = Path.of("items.csv");
    private final Path membersFile = Path.of("members.csv");
    private final Path loansFile = Path.of("loans.csv");

    public Library() {
        loadData();
    }

    // ---------- CSV helpers (commas in text are encoded) ----------

    private static String enc(String s) {
        return URLEncoder.encode(s, StandardCharsets.UTF_8);
    }

    private static String dec(String s) {
        return URLDecoder.decode(s, StandardCharsets.UTF_8);
    }

    // ---------- Operations ----------

    public void addItem(LibraryItem item) {
        if (items.putIfAbsent(item.getId(), item) != null) {
            throw new IllegalArgumentException("Item ID already exists.");
        }
    }

    public void registerMember(Member member) {
        if (members.putIfAbsent(member.getId(), member) != null) {
            throw new IllegalArgumentException(
                    "Member ID already exists.");
        }
    }

    public void borrowItem(String itemId, String memberId)
            throws ItemNotAvailableException,
                   MemberLimitExceededException {
        LibraryItem item = items.get(itemId);
        Member member = members.get(memberId);

        if (item == null || member == null) {
            throw new IllegalArgumentException(
                    "Item or member was not found.");
        }

        item.borrow(member);

        loans.add(new Loan(itemId, memberId,
                LocalDate.now(), item.getDueDate()));
    }

    public void returnItem(String itemId) {
        LibraryItem item = items.get(itemId);

        if (item == null) {
            throw new IllegalArgumentException("Item not found.");
        }

        if (item.isAvailable()) {
            throw new IllegalStateException(
                    "Item is not currently borrowed.");
        }

        for (int i = loans.size() - 1; i >= 0; i--) {
            Loan loan = loans.get(i);

            if (loan.getItemId().equals(itemId)
                    && !loan.isReturned()) {
                loan.markReturned();
                break;
            }
        }

        item.giveBack();
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the library.");
            return;
        }
        items.values().stream()
                .sorted(Comparator.comparing(LibraryItem::getId))
                .forEach(System.out::println);
    }

    public void listMembers() {
        if (members.isEmpty()) {
            System.out.println("No registered members.");
            return;
        }
        members.values().stream()
                .sorted(Comparator.comparing(Member::getId))
                .forEach(System.out::println);
    }

    public void listOverdueItems() {
        List<String> overdue = loans.stream()
                .filter(Loan::isOverdue)
                .map(loan -> {
                    LibraryItem item = items.get(loan.getItemId());
                    return (item == null ? loan.getItemId()
                            : item.toString())
                            + " | Member: " + loan.getMemberId();
                })
                .collect(Collectors.toList());

        if (overdue.isEmpty()) {
            System.out.println("No overdue items.");
        } else {
            overdue.forEach(System.out::println);
        }
    }

    public void searchByTitle(String query) {
        String q = query.trim().toLowerCase();

        List<LibraryItem> results = items.values().stream()
                .filter(item -> item.getTitle()
                        .toLowerCase().contains(q))
                .sorted(Comparator.comparing(LibraryItem::getTitle,
                        String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            System.out.println("No matching items found.");
        } else {
            results.forEach(System.out::println);
        }
    }

    // ---------- Persistence ----------

    public void saveData() {
        try {
            List<String> itemLines = new ArrayList<>();

            for (LibraryItem item : items.values()) {
                String borrower = item.getBorrowedBy() == null
                        ? "" : item.getBorrowedBy().getId();
                String due = item.getDueDate() == null
                        ? "" : item.getDueDate().toString();

                if (item instanceof Book book) {
                    itemLines.add("BOOK," + enc(book.getId())
                            + "," + enc(book.getTitle())
                            + "," + enc(book.getAuthor())
                            + "," + book.isAvailable()
                            + "," + enc(borrower)
                            + "," + due);
                } else if (item instanceof Dvd dvd) {
                    itemLines.add("DVD," + enc(dvd.getId())
                            + "," + enc(dvd.getTitle())
                            + "," + dvd.isAvailable()
                            + "," + enc(borrower)
                            + "," + due);
                }
            }

            List<String> memberLines = members.values().stream()
                    .map(m -> enc(m.getId()) + "," + enc(m.getName()))
                    .collect(Collectors.toList());

            List<String> loanLines = loans.stream()
                    .map(Loan::toCsv)
                    .collect(Collectors.toList());

            Files.write(itemsFile, itemLines);
            Files.write(membersFile, memberLines);
            Files.write(loansFile, loanLines);

            System.out.println("Library data saved.");

        } catch (IOException e) {
            System.out.println("Could not save data: "
                    + e.getMessage());
        }
    }

    private void loadData() {
        try {
            if (Files.exists(membersFile)) {
                for (String line : Files.readAllLines(membersFile)) {
                    try {
                        String[] p = line.split(",", -1);
                        if (p.length >= 2) {
                            Member m = new Member(dec(p[0]), dec(p[1]));
                            members.put(m.getId(), m);
                        }
                    } catch (RuntimeException e) {
                        System.out.println("Skipped bad member line: "
                                + e.getMessage());
                    }
                }
            }

            if (Files.exists(itemsFile)) {
                for (String line : Files.readAllLines(itemsFile)) {
                    try {
                        loadItemLine(line);
                    } catch (RuntimeException e) {
                        System.out.println("Skipped bad item line: "
                                + e.getMessage());
                    }
                }
            }

            if (Files.exists(loansFile)) {
                for (String line : Files.readAllLines(loansFile)) {
                    try {
                        String[] p = line.split(",", -1);
                        if (p.length >= 4) {
                            Loan loan = new Loan(
                                    dec(p[0]), dec(p[1]),
                                    LocalDate.parse(p[2]),
                                    LocalDate.parse(p[3]));

                            if (p.length >= 5 && !p[4].isBlank()) {
                                loan.markReturnedFromCsv(
                                        LocalDate.parse(p[4]));
                            }

                            loans.add(loan);
                        }
                    } catch (RuntimeException e) {
                        System.out.println("Skipped bad loan line: "
                                + e.getMessage());
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Could not load library data: "
                    + e.getMessage());
        }
    }

    private void loadItemLine(String line) {
        String[] p = line.split(",", -1);
        if (p.length < 5) {
            return;
        }

        LibraryItem item;
        int availableIndex;

        if (p[0].equals("BOOK") && p.length >= 7) {
            item = new Book(dec(p[1]), dec(p[2]), dec(p[3]));
            availableIndex = 4;
        } else if (p[0].equals("DVD") && p.length >= 6) {
            item = new Dvd(dec(p[1]), dec(p[2]));
            availableIndex = 3;
        } else {
            return;
        }

        items.put(item.getId(), item);

        int memberIndex = availableIndex + 1;
        int dueIndex = availableIndex + 2;

        if (p[availableIndex].equals("false")
                && !p[dueIndex].isBlank()) {
            Member member = members.get(dec(p[memberIndex]));

            if (member != null) {
                item.restoreBorrowed(member,
                        LocalDate.parse(p[dueIndex]));
            }
        }
    }
}