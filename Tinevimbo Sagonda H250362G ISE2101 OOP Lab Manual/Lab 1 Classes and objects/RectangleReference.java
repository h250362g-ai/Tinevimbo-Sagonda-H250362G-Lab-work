public class RectangleReference {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 10);

        Rectangle r2 = r1;
        r2.width = 20;

        System.out.println("r1.width = " + r1.width);
        System.out.println("r2.width = " + r2.width);
    }
}

class Rectangle {
    double width;
    double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double area() {
        return width * height;
    }

    double perimeter() {
        return 2 * (width + height);
    }
}