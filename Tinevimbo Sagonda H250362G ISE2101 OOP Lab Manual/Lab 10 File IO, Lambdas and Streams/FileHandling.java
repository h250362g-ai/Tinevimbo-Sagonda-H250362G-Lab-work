import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            FileWriter writer = new FileWriter("lines.txt");

            System.out.println("Enter five lines:");

            for (int i = 1; i <= 5; i++) {
                System.out.print("Line " + i + ": ");
                writer.write(input.nextLine() + System.lineSeparator());
            }

            writer.close();

            System.out.println("\nContents of the file:");

            BufferedReader reader =
                    new BufferedReader(new FileReader("lines.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        input.close();
    }
}
