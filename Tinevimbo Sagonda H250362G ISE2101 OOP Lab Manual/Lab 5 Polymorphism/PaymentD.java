// Version A: Using instanceof pattern matching

class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    public void processCard() {
        System.out.printf("Processing card payment: $%.2f%n", amount);
    }
}

class MobileMoneyPayment extends Payment {
    public MobileMoneyPayment(double amount) {
        super(amount);
    }

    public void processMobileMoney() {
        System.out.printf("Processing mobile money: $%.2f%n", amount);
    }
}

class PaymentProcessor {
    public void pay(Payment payment) {
        if (payment instanceof CardPayment card) {
            card.processCard();
        } else if (payment instanceof MobileMoneyPayment mobile) {
            mobile.processMobileMoney();
        } else {
            throw new IllegalArgumentException("Unsupported payment type");
        }
    }
}

public class PaymentD {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        processor.pay(new CardPayment(100));
        processor.pay(new MobileMoneyPayment(50));
    }
}

//Version B: Using polymorphism
//Replacement of the payment classes and processor with this implementation.

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract void process();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public void process() {
        System.out.printf("Processing card payment: $%.2f%n", amount);
    }
}

class MobileMoneyPayment extends Payment {
    public MobileMoneyPayment(double amount) {
        super(amount);
    }

    @Override
    public void process() {
        System.out.printf("Processing mobile money: $%.2f%n", amount);
    }
}

class PaymentProcessor {
    public void pay(Payment payment) {
        payment.process();
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        processor.pay(new CardPayment(100));
        processor.pay(new MobileMoneyPayment(50));
    }
}
