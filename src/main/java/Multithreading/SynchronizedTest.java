package Multithreading;

class CounterSynchronized {
    private int count = 0;
    
    public synchronized void increment() {
        count++;
        System.out.println("Thread " + Thread.currentThread().getName() + " incremented count to: " + count);
    }
    public int getCount() {
        return count;
    }
    public void decrement() {
        synchronized (this) {
            count--;
            System.out.println("Thread " + Thread.currentThread().getName() + " decremented count to: " + count);
        }
        System.out.println("Thread " + Thread.currentThread().getName() + "Hello world");
    }
    public static synchronized void reset() {
        System.out.println("Resetting count to 0");
    }
    public static void greet() {
        synchronized (CounterSynchronized.class) {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }
}

public class SynchronizedTest {
    public static void main(String[] args) {
        CounterSynchronized counter = new CounterSynchronized();
        Thread thread1 = new Thread(() -> {
            // counter.increment();
            // counter.decrement();
            CounterSynchronized.reset();
            CounterSynchronized.greet();
        });
        Thread thread2 = new Thread(() -> {
            // counter.increment();
            // counter.decrement();
            CounterSynchronized.reset();
            CounterSynchronized.greet();
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final count: " + counter.getCount());
    }
}
