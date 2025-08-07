// Custom thread class
class Mythread extends Thread {

    public Mythread(String name) {
        super(name); // Set the thread name using superclass constructor
    }

    @Override
    public void run() {
        System.out.println("Thread.run() executed by: " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000); // simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread task finished by: " + Thread.currentThread().getName());
    }
}

// Main class
public class java_multithreading {
    public static void main(String[] args) throws InterruptedException {

        // Create thread instances with custom names
        Mythread t1 = new Mythread("Thread-A");
        Mythread t2 = new Mythread("Thread-B");

        // Check initial state
        System.out.println("Before start, t1 state: " + t1.getState());
        System.out.println("Before start, t2 state: " + t2.getState());

        // Start threads
        t1.start();
        t2.start();

        // Print state after starting
        System.out.println("After start, t1 state: " + t1.getState());
        System.out.println("After start, t2 state: " + t2.getState());

        // Wait for both threads to complete
        t1.join();
        t2.join();

        // Print final state
        System.out.println("After join, t1 state: " + t1.getState());
        System.out.println("After join, t2 state: " + t2.getState());

        // Call run() directly from main thread
        System.out.println("Calling run() directly from main:");
        t1.run();

        // Print current thread
        System.out.println("Current running thread is: " + Thread.currentThread().getName());
    }
}
