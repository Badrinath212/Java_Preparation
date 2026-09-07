package Multithreading;

class CounterRunnable implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        while (count < 1000) {
            count++;
        }
        System.out.println("Thread" + Thread.currentThread().getName() + " finished counting." + " Final count: " + count);
    }
}

public class RunnableTest {
    public static void main(String[] args) {
        CounterRunnable counter = new CounterRunnable();
        Thread thread = new Thread(counter);
        thread.start();
    }
}

