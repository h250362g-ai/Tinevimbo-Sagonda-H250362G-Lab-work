abstract class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit must be positive."
            );
        }

        balance += amount;
    }

    public abstract double monthlyFee();

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public double monthlyFee() {
        return 2.50;
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    public double monthlyFee() {
        return 5.00;
    }
}

public class AccountD {
    public static void main(String[] args) {
        Account savings = new SavingsAccount(500);
        Account current = new CurrentAccount(1000);

        savings.deposit(100);
        current.deposit(200);

        System.out.printf(
            "Savings balance: %.2f, monthly fee: %.2f%n",
            savings.getBalance(), savings.monthlyFee()
        );

        System.out.printf(
            "Current balance: %.2f, monthly fee: %.2f%n",
            current.getBalance(), current.monthlyFee()
        );
    }
}
