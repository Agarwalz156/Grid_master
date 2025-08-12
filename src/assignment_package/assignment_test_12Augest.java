package assignment_package;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;


public class assignment_test_12Augest {

    static class SharedCounter {
        private int count = 0;
        private final ReentrantLock lock = new ReentrantLock();

        public void increment() {
            lock.lock();
            try {
                count++;
                System.out.println(Thread.currentThread().getName() + " incremented count to " + count);
            } finally {
                lock.unlock(); // Lock released
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws Exception {
        SharedCounter counter = new SharedCounter();

        Runnable task1 = () -> {

            System.out.println(Thread.currentThread().getName() + " is running (Runnable via Lambda)");
            for (int i = 0; i < 3; i++) {
                counter.increment();
                try {
                    Thread.sleep(500); // Timed waiting
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        // 2. Callable functional interface (returns value)
        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "Callable task completed by " + Thread.currentThread().getName();
        };

        // 3. Predicate functional interface (returns boolean)
        Predicate<Integer> isEven = num -> num % 2 == 0;

        // Creating and starting threads
        Thread t1 = new Thread(task1, "Worker-1");
        Thread t2 = new Thread(task1, "Worker-2");

        t1.start();
        t2.start();


        t1.join();
        t2.join();

        System.out.println("\n---------------------------------------------------\n");
        // Using Callable
        String result = task2.call();
        System.out.println(result);

        System.out.println("\n---------------------------------------------------\n");
        // Using Predicate
        int numberToCheck = counter.getCount();
        System.out.println("Final Count: " + numberToCheck);
        System.out.println("Is final count even? " + isEven.test(numberToCheck));

        System.out.println("\n---------------------------------------------------\n");
        System.out.println("Batch Processing → Processes a set of all tasks at once in bulk .\n" + "\n" + "Batch Polling → The system periodically checks for available task and processes them in bulk when found.");
    }
}
