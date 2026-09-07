package Multithreading;

class Counter extends Thread {
    private int count = 0;

    @Override
    public void run() {
        while (count < 1000) {
            count++;
        }
        System.out.println("Thread" + Thread.currentThread().getName() + " finished counting." + " Final count: " + count);
    }
}

public class ThreadTest {
    public static void main(String[] args) {

        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        counter1.start();

        try {
            counter1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter1 has finished counting. Starting Counter2...");
        counter2.start();
    }
}
