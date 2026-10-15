public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        setMarks(marks);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException(
                "Marks must be between 0 and 100."
            );
        }
        this.marks = marks;
    }

    public static void main(String[] args) {
        Student student = new Student("Tinevimbo", 85);

        System.out.println("Name: " + student.getName());
        System.out.println("Marks: " + student.getMarks());

        try {
            student.setMarks(120);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
