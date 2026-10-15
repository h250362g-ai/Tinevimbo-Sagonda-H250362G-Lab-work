import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Tariro");
        names.add("Tendai");
        names.add("Rudo");
        names.add("Tariro");
        names.add("Farai");
        names.add("Rudo");

        Set<String> uniqueNames = new LinkedHashSet<>(names);

        System.out.println("Original names: " + names);
        System.out.println("Unique names: " + uniqueNames);
    }
}
