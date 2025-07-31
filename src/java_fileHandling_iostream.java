import java.io.*;
public class java_fileHandling_iostream {
    public static void main(String[] args) {
        // 1. Read user input
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter your name: ");
            String name = consoleReader.readLine();
            System.out.println("Hello, " + name + "!");
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }

        // 2. Read from a file "example.txt"
        System.out.println("\nContents of 'example.txt':");
        try (BufferedReader fileReader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading example.txt: " + e.getMessage());
        }

        // 3. Copy content from "Input.txt" to "Output.txt"
        try (
                BufferedReader inputReader = new BufferedReader(new FileReader("Input.txt"));
                BufferedWriter outputWriter = new BufferedWriter(new FileWriter("Output.txt"))
        ) {
            String line;
            while ((line = inputReader.readLine()) != null) {
                outputWriter.write(line);
                outputWriter.newLine(); // Maintain line breaks
            }
            System.out.println("\nContent copied from 'Input.txt' to 'Output.txt' successfully.");
        } catch (IOException e) {
            System.out.println("Error during file copy: " + e.getMessage());
        }
    }
}
