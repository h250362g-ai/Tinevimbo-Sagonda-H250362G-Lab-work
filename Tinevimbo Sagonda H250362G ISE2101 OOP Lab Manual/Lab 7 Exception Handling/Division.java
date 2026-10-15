import java.util.Scanner;
import java.util.InputMismatchException;

public class Division {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter the first integer: ");
            int num1 = input.nextInt();

            System.out.print("Enter the second integer: ");
            int num2 = input.nextInt();

            int result = num1 / num2;

            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integers.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            input.close();
        }
    }
}