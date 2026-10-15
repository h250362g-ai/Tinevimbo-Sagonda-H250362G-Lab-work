import java.util.ArrayList;
import java.util.Collections;

public class ArrayListD {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(12);
        numbers.add(5);
        numbers.add(30);
        numbers.add(8);
        numbers.add(17);
        numbers.add(42);
        numbers.add(3);
        numbers.add(25);
        numbers.add(10);
        numbers.add(19);

        int sum = 0;
        int maximum = numbers.get(0);

        for (int number : numbers) {
            sum += number;

            if (number > maximum) {
                maximum = number;
            }
        }

        System.out.println("List: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Maximum: " + maximum);

        Collections.reverse(numbers);
        System.out.println("Reverse order: " + numbers);
    }
}
