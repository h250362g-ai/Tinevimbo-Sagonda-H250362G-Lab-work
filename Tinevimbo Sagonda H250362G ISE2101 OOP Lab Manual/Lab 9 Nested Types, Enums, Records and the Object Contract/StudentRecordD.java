record Student(String name, int age) {}

public class StudentRecordD {
    public static void main(String[] args) {
        Student student1 = new Student("Tino", 20);
        Student student2 = new Student("Tino", 20);
        Student student3 = new Student("Mary", 21);

        System.out.println(student1);

        System.out.println("Are student1 and student2 equal? "
                + student1.equals(student2));

        System.out.println("Are student1 and student3 equal? "
                + student1.equals(student3));

        System.out.println("Student name: " + student1.name());
        System.out.println("Student age: " + student1.age());
    }
}