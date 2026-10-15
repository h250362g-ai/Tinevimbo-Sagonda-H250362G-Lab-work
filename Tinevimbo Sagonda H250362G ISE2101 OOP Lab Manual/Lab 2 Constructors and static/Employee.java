public class Employee {
    private static int nextId = 1;

    private int employeeId;
    private String name;
    private String department;
    private double salary;

    // Constructor 1: name only
    public Employee(String name) {
        this(name, "Unassigned", 0.0);
    }

    // Constructor 2: name and department
    public Employee(String name, String department) {
        this(name, department, 0.0);
    }

    // Constructor 3: name, department and salary
    public Employee(String name, String department, double salary) {
        this.employeeId = nextId++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Copy constructor
    public Employee(Employee other) {
        this(other.name, other.department, other.salary);
    }

    public void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println();
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Tariro");
        Employee e2 = new Employee("Tendai", "IT");
        Employee e3 = new Employee("Rudo", "Finance", 1500.0);
        Employee e4 = new Employee(e3);

        e1.display();
        e2.display();
        e3.display();
        e4.display();
    }
}
