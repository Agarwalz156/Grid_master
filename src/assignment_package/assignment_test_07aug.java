package assignment_package;
import java.io.*;
import java.util.Scanner;

class Counter {
    int count = 0;

    // Unsynchronized increment
    public void incrementUnSync() {
        count++;
    }

    // Synchronized increment
    public synchronized void incrementSync() {
        count++;
    }
}

// Thread class for demonstrating synchronization
class Mythreadjava extends Thread {
    Counter counter;
    boolean useSync;

    public Mythreadjava(Counter counter, boolean useSync) {
        this.counter = counter;
        this.useSync = useSync;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (useSync) {
                counter.incrementSync(); // synchronized version
            } else {
                counter.incrementUnSync(); // unsynchronized version
            }
        }
    }
}

public class assignment_test_07aug {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // PART 1: THREAD EXAMPLE
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        // Without synchronization
        Mythreadjava t1 = new  Mythreadjava(counter1, false);
        Mythreadjava t2 = new  Mythreadjava(counter1, false);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count without synchronization: " + counter1.count);

        // With synchronization
        Mythreadjava t3 = new  Mythreadjava(counter2, true);
        Mythreadjava t4 = new  Mythreadjava(counter2, true);

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count with synchronization: " + counter2.count);


        try {
            System.out.println("\nEnter text to write to file (type 'exit' to finish):");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            FileWriter writer = new FileWriter("user_input.txt");

            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line + "\n");
            }

            writer.close();
            System.out.println("Text written to 'user_input.txt' successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
