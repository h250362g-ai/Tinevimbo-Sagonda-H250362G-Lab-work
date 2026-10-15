import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return name + " - " + marks;
    }
}

public class StudentSorting {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Tendai", 75));
        students.add(new Student("Tinevimbo", 90));
        students.add(new Student("Faffy", 82));

        // Sorted by name using Comparable
        students.sort(null);
        System.out.println("Sorted by name:");
        students.forEach(System.out::println);

        // Sorted by marks, highest first, using Comparator
        students.sort(
            Comparator.comparingInt(Student::getMarks).reversed()
        );

        System.out.println("\nSorted by marks:");
        students.forEach(System.out::println);
    }
}
