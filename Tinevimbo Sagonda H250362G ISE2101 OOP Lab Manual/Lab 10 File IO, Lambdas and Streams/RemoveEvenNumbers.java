import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class RemoveEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );

        Predicate<Integer> isEven = number -> number % 2 == 0;

        System.out.println("Original list: " + numbers);

        numbers.removeIf(isEven);

        System.out.println("After removing even numbers: " + numbers);
    }
}
