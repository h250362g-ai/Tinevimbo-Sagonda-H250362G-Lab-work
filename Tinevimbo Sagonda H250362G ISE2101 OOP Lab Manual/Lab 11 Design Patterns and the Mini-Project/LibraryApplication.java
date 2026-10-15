import java.util.Scanner;

public class LibraryApplication {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner input = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. Add item");
            System.out.println("2. Register member");
            System.out.println("3. Borrow item");
            System.out.println("4. Return item");
            System.out.println("5. List overdue items");
            System.out.println("6. Search by title");
            System.out.println("7. List all items");
            System.out.println("8. List all members");
            System.out.println("0. Save and exit");
            System.out.print("Choose an option: ");

            String choice = input.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Book or DVD? ");
                        String type = input.nextLine();

                        System.out.print("ID: ");
                        String id = input.nextLine();

                        System.out.print("Title: ");
                        String title = input.nextLine();

                        if (type.equalsIgnoreCase("book")) {
                            System.out.print("Author: ");
                            String author = input.nextLine();
                            library.addItem(new Book(id, title, author));
                        } else if (type.equalsIgnoreCase("dvd")) {
                            library.addItem(new Dvd(id, title));
                        } else {
                            System.out.println("Invalid item type.");
                            break;
                        }

                        System.out.println("Item added.");
                        break;

                    case "2":
                        System.out.print("Member ID: ");
                        String memberId = input.nextLine();

                        System.out.print("Member name: ");
                        String name = input.nextLine();

                        library.registerMember(
                                new Member(memberId, name));

                        System.out.println("Member registered.");
                        break;

                    case "3":
                        System.out.print("Item ID: ");
                        String borrowId = input.nextLine();

                        System.out.print("Member ID: ");
                        String borrowerId = input.nextLine();

                        library.borrowItem(borrowId, borrowerId);
                        System.out.println("Item borrowed successfully.");
                        break;

                    case "4":
                        System.out.print("Item ID to return: ");
                        library.returnItem(input.nextLine());
                        System.out.println("Item returned.");
                        break;

                    case "5":
                        library.listOverdueItems();
                        break;

                    case "6":
                        System.out.print("Enter title to search: ");
                        library.searchByTitle(input.nextLine());
                        break;

                    case "7":
                        library.listItems();
                        break;

                    case "8":
                        library.listMembers();
                        break;

                    case "0":
                        library.saveData();
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid menu option.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        input.close();
    }
}
