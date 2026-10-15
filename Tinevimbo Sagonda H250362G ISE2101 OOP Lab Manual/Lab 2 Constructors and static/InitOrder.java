public class InitOrder {

    static {
        System.out.println("First static block");
    }

    {
        System.out.println("First instance block");
    }

    static {
        System.out.println("Second static block");
    }

    {
        System.out.println("Second instance block");
    }

    public InitOrder() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        System.out.println("Main method");

        new InitOrder();

        System.out.println("Creating second object");

        new InitOrder();
    }
}
