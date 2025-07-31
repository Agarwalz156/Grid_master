package assignment_package;
import java.io.*;
import java.util.function.Predicate;
public class assignment_31july {
    // Predicate to check if a number is prime
    static Predicate<Integer> isPrime = (n) -> {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    };

    // Method to compute expression 3x^2 + 2x + 5
    static int computeExpression(int x) {
        return 3 * x * x + 2 * x + 5;
    }

    // File writing and reading about yourself
    static void fileOperations() {
        String filename = "about_me.txt";
        String about = "Hi, I am a B.Tech CSE student who loves coding, building projects, and learning Java!";

        try {
            // Write to file
            FileWriter writer = new FileWriter(filename);
            writer.write(about);
            writer.close();
            System.out.println("✅ File written successfully.");

            // Read from file
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            System.out.println("📄 Reading file contents:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("❌ File error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // 1. Wrapper class, boxing and unboxing
        int primitiveInt = 10;
        Integer boxedInt = primitiveInt; // Auto-boxing
        int unboxedInt = boxedInt;       // Auto-unboxing
        System.out.println("🔁 Wrapper Class Example:");
        System.out.println("Primitive int: " + primitiveInt);
        System.out.println("Boxed Integer: " + boxedInt);
        System.out.println("Unboxed int: " + unboxedInt);

        // 2. Predicate: check if a number is prime
        int testNumber = 17;
        System.out.println("\n🔍 Predicate Function (isPrime):");
        System.out.println("Is " + testNumber + " prime? " + isPrime.test(testNumber));

        // 3. Direct method: compute expression 3x^2 + 2x + 5
        int x = 4;
        int result = computeExpression(x);
        System.out.println("\n🧮 Direct Expression Calculation:");
        System.out.println("Expression 3x^2 + 2x + 5 with x = " + x + " is " + result);

        // 4. File Read/Write
        System.out.println("\n📂 File Operations:");
        fileOperations();
    }
}

