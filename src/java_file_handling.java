import java.io.*;
import java.util.Scanner;
public class java_file_handling {
    public static void main(String[] args) {
        String fileName = "demoFile.txt";

        // 1. Create a file
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("✅ File created: " + file.getName());
            } else {
                System.out.println("ℹ️ File already exists.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error while creating the file.");
            e.printStackTrace();
        }

        // 2. Write to the file
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Hello, this is a demo of file handling in Java.\n");
            writer.write("This is line 2.");
            writer.close();
            System.out.println("✅ Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("❌ Error while writing to the file.");
            e.printStackTrace();
        }

        // 3. Read from the file
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            System.out.println("📄 File content:");
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("❌ File not found.");
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Name: Alice\n");
        sb.append("Course: B.Tech CSE\n");
        sb.append("Topic: File Handling with StringBuilder\n");
        sb.append("Language: Java\n");


          try {
        FileWriter writer = new FileWriter(fileName);
        writer.write(sb.toString());
        writer.close();
        System.out.println("✅ Data written using StringBuilder.");
    } catch (IOException e) {
        System.out.println("❌ Error writing to file.");
        e.printStackTrace();
    }

    // 4. Read and display file content
        try {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        System.out.println("📄 File Content:");
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("❌ Error reading file.");
        e.printStackTrace();
    }
        // 4. Delete the file
        File fileToDelete = new File(fileName);
        if (fileToDelete.delete()) {
            System.out.println("🗑️ File deleted: " + fileToDelete.getName());
        } else {
            System.out.println("❌ Failed to delete the file.");
        }
    }

}