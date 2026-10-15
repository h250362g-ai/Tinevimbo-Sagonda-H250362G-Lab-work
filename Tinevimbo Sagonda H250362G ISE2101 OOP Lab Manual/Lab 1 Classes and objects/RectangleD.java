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

public class RectangleD {
    public static void main(String[] args) {
        Rectangle[] rectangles = {
            new Rectangle(4, 5),
            new Rectangle(8, 3),
            new Rectangle(6, 7),
            new Rectangle(2, 9),
            new Rectangle(10, 4)
        };

        Rectangle largest = rectangles[0];

        for (Rectangle rectangle : rectangles) {
            System.out.println(
                "Width: " + rectangle.width
                + ", Height: " + rectangle.height
                + ", Area: " + rectangle.area()
                + ", Perimeter: " + rectangle.perimeter()
            );

            if (rectangle.area() > largest.area()) {
                largest = rectangle;
            }
        }

        System.out.println("Rectangle with largest area:");
        System.out.println("Width: " + largest.width);
        System.out.println("Height: " + largest.height);
        System.out.println("Area: " + largest.area());
    }
}
