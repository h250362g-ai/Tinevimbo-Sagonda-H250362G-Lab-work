class Parent {
    String message = "Parent field";

    public void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    String message = "Child field";

    @Override
    public void display() {
        System.out.println("Child method");
    }
}

public class ReferenceD {
    public static void main(String[] args) {
        Parent reference = new Child();

        System.out.println(reference.message);
        reference.display();
    }
}
