class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidation {

    public static void validateAge(int age)
            throws InvalidAgeException {

        if (age < 0 || age > 120) {
            throw new InvalidAgeException(
                "Age must be between 0 and 120."
            );
        }

        System.out.println("Valid age: " + age);
    }

    public static void main(String[] args) {
        try {
            validateAge(20);
            validateAge(150);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}