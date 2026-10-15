public class Circle {
    private double radius;

    // Constructor that accepts a radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // No-argument constructor
    public Circle() {
        this(1.0);
    }

    public void display() {
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle();

        c1.display();
        c2.display();
    }
}
