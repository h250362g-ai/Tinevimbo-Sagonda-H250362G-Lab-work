//Incorrect version

public class Dog extends Animal {
    public Dog() {
        // Java tries to call super() automatically
    }
}

//Why it fails: Animal does not have a no-argument constructor. 
// Java tries to call super(), but only Animal(String name) exists, so compilation fails.

//Correct version:

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        System.out.println("Dog created successfully");
    }
}

//If the parent class has no no-argument constructor, 
// the child constructor must explicitly call an available parent constructor using super(arguments)