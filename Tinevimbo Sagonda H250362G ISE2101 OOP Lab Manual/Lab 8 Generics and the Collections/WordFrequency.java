import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a paragraph:");
        String paragraph = input.nextLine().toLowerCase();

        String[] words = paragraph.split("[^\\p{L}\\p{N}]+");

        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
                );
            }
        }

        List<Map.Entry<String, Integer>> entries =
            new ArrayList<>(frequency.entrySet());

        entries.sort(
            Comparator
                .<Map.Entry<String, Integer>>comparingInt(
                    Map.Entry::getValue
                )
                .reversed()
                .thenComparing(Map.Entry::getKey)
        );

        System.out.println("Word frequencies:");

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }

        input.close();
    }
}
