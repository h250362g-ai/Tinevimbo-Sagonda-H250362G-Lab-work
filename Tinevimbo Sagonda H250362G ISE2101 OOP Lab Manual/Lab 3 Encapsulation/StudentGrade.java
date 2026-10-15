
public class StudentGrade {
    private String name;
    private int marks;

    public StudentGrade(String name, int marks) {
        this.name = name;
        setMarks(marks);
    }

    public String getName() {
        return name;
    }

    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException(
                "Marks must be between 0 and 100."
            );
        }
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public char getGrade() {
        if (marks >= 80) {
            return 'A';
        } else if (marks >= 70) {
            return 'B';
        } else if (marks >= 50) {
            return 'C';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        StudentGrade s1 = new StudentGrade("Tinevimbo", 85);
        StudentGrade s2 = new StudentGrade("Tendai", 74);
        StudentGrade s3 = new StudentGrade("Tanya", 55);
        StudentGrade s4 = new StudentGrade("Faffy", 35);

        System.out.println(s1.getName() + ": " + s1.getGrade());
        System.out.println(s2.getName() + ": " + s2.getGrade());
        System.out.println(s3.getName() + ": " + s3.getGrade());
        System.out.println(s4.getName() + ": " + s4.getGrade());
    }
}
