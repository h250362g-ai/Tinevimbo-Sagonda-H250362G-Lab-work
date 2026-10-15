interface First {
    default void hello() {
        System.out.println("Hello from First");
    }
}

interface Second {
    default void hello() {
        System.out.println("Hello from Second");
    }
}

class Greeting implements First, Second {
    @Override
    public void hello() {
        First.super.hello();
        Second.super.hello();
        System.out.println("Hello from Greeting");
    }
}

public class DefaultMethod {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        greeting.hello();
    }
}
