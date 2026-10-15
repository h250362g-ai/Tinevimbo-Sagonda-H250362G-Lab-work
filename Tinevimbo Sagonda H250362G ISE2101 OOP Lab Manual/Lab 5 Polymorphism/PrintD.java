public class PrintD {

    public void print(int value) {
        System.out.println("Integer: " + value);
    }

    public void print(double value) {
        System.out.println("Double: " + value);
    }

    public void print(String value) {
        System.out.println("String: " + value);
    }

    public void print(int[] values) {
        System.out.print("Integer array: ");

        for (int value : values) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        PrintD demo = new PrintD();

        demo.print(10);
        demo.print(12.5);
        demo.print("Hello Java");
        demo.print(new int[]{1, 2, 3, 4});
    }
}
