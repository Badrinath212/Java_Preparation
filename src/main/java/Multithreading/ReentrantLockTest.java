package Multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockCounter {
    int count = 0;

    ReentrantLock lock = new ReentrantLock(true);

    public void increment() {
        try {
            if(lock.tryLock(2, TimeUnit.SECONDS)) {
            try {
                count++;
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Could not acquire lock, skipping increment.");
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLockCounter counter = new ReentrantLockCounter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.count);
    }
}
