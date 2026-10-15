public class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Subject: " + subject);
    }

    public static void main(String[] args) {
        Student student = new Student(
            "Tinevimbo", 20, "Software Engineering"
        );

        Teacher teacher = new Teacher(
            "Mr. Moyo", 35, "Computer Science"
        );

        System.out.println("STUDENT");
        student.display();

        System.out.println("\nTEACHER");
        teacher.display();
    }
}
