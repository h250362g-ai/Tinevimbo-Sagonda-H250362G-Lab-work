
public class CircleCounter {
    private double radius;
    private static int count = 0;

    public CircleCounter(double radius) {
        this.radius = radius;
        count++;
    }

    public CircleCounter() {
        this(1.0);
    }

    public static int getCount() {
        return count;
    }

    public void display() {
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {
        CircleCounter c1 = new CircleCounter(5.0);
        CircleCounter c2 = new CircleCounter();
        CircleCounter c3 = new CircleCounter(3.0);

        c1.display();
        c2.display();
        c3.display();

        System.out.println("Total circles created: " + CircleCounter.getCount());
    }
}
