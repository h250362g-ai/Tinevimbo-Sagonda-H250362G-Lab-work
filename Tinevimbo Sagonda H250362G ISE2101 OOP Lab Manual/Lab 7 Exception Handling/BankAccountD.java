class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException(
                "Initial balance cannot be negative."
            );
        }

        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit must be positive."
            );
        }

        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount)
            throws InsufficientFundsException {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal must be positive."
            );
        }

        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient funds. Available balance: $" + balance
            );
        }

        balance -= amount;
        System.out.println("Withdrawn: $" + amount);
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountD {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500);

        try {
            account.deposit(200);
            account.withdraw(300);
            account.withdraw(600);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Final balance: $" + account.getBalance());
    }
}