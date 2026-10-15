class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat says meow");
    }
}

class Cow extends Animal {
    @Override
    public void sound() {
        System.out.println("Cow says moo");
    }
}

class Duck extends Animal {
    @Override
    public void sound() {
        System.out.println("Duck says quack");
    }
}

public class AnimalTest {
    public static void main(String[] args) {
        Animal[] animals = {
            new Cat(),
            new Cow(),
            new Duck()
        };

        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
