class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculatePay() {
        return salary;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculatePay() {
        return salary + bonus;
    }
}

class Intern extends Employee {
    private double stipend;

    public Intern(String name, double stipend) {
        super(name, 0);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class PayrollD {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Tinevimbo", 1000),
            new Manager("Tendai", 2000, 500),
            new Intern("Faffy", 300)
        };

        double totalPayroll = 0;

        for (Employee employee : employees) {
            totalPayroll += employee.calculatePay();
        }

        System.out.printf("Total payroll: $%.2f%n", totalPayroll);
    }
}
