public class ArrayAccess {

    public static void displayElement(int[] numbers, int index) {
        try {
            System.out.println("Element: " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid array index.");
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        displayElement(numbers, 2);
        displayElement(numbers, 8);
    }
}