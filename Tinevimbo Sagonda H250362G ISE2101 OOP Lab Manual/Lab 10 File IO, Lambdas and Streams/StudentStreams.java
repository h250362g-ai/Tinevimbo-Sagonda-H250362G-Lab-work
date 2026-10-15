import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

record Student(String name, int marks) {}

public class StudentStreams {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Tendai", 65),
            new Student("Tinevimbo", 90),
            new Student("Tanya", 80),
            new Student("Faffy", 50),
            new Student("Tino", 75)
        );

        double average = students.stream()
                .mapToInt(Student::marks)
                .average()
                .orElse(0);

        System.out.printf("Class average: %.2f%n", average);

        System.out.println("Students above average:");

        students.stream()
                .filter(student -> student.marks() > average)
                .sorted(Comparator.comparing(Student::name))
                .forEach(student ->
                    System.out.println(
                        student.name() + " - " + student.marks()
                    )
                );
    }
}
