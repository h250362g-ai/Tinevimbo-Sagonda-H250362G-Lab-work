import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private double balance;
    private final List<String> transactions;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                "Initial balance cannot be negative."
            );
        }

        balance = initialBalance;
        transactions = new ArrayList<>();
        transactions.add("Account opened: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit must be positive."
            );
        }

        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal must be positive."
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                "Insufficient funds."
            );
        }

        balance -= amount;
        transactions.add("Withdrawn: " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return Collections.unmodifiableList(
            new ArrayList<>(transactions)
        );
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(500);
        account.deposit(200);
        account.withdraw(100);

        System.out.println("Balance: " + account.getBalance());
        System.out.println("Transaction history:");

        for (String transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}
