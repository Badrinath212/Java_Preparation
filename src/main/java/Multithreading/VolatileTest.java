package Multithreading;

class Test {
    private volatile boolean isRunning = true;
    private volatile long count = 0;

    public void setRunning() {
        isRunning = false;
    }

    public void greet() {
        while(isRunning) {
            count+=1;
        }
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
            Thread.sleep(1000);
            test.setRunning();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
