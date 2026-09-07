package Multithreading;

class Test {
    private volatile boolean isRunning = true;
    private int count = 0;

    public void greet() {
        if (isRunning) {
            System.out.println("Hello from " + Thread.currentThread().getName());
            isRunning = false;
        } else {
            System.out.println("Thread " + Thread.currentThread().getName() + " is not running.");
        }
        count++;
        System.out.println("Thread " + Thread.currentThread().getName() + " has greeted " + count + " times.");
    }
}

public class VolatileTest {
    public static void main(String[] args) {
        Test test = new Test();
        Thread thread1 = new Thread(() -> {
            test.greet();
        });
        Thread thread2 = new Thread(() -> {
            test.greet();
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
