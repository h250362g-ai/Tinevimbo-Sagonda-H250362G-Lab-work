class Address {
    String city;

    public Address(String city) {
        this.city = city;
    }
}

public class Person {
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public static void main(String[] args) {
        Person person1 = new Person(
            "Tinevimbo",
            new Address("Harare")
        );

        System.out.println(person1.address.city);

        Person person2 = new Person("Alex", null);

        try {
            System.out.println(person2.address.city);
        } catch (NullPointerException e) {
            System.out.println(
                "Cannot access city because address is null."
            );
        }
    }
}
