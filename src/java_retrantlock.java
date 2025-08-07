import java.util.concurrent.locks.ReentrantLock;

public class java_retrantlock {
    public static void main(String[] args) {
        Counter2 countera = new Counter2();

        MyThreadult thread1 = new MyThreadult(countera);
        MyThreadult thread2 = new MyThreadult(countera);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + countera.getCount());
    }
}

class Counter2 {
    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

class MyThreadult extends Thread {
    private Counter2 countera;

    public MyThreadult(Counter2 countera) {
        this.countera = countera;
    }
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            countera.increment();
        }
    }
}
