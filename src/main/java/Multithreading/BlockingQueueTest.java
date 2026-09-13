package Multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args) {
        try {
            BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

            queue.put("Hello");
            queue.put("World");

            Thread thread1 = new Thread(() -> {
                try {
                    queue.put("Badri");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            Thread thread2 = new Thread(() -> {
                try {
                    queue.take();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            for(String s : queue) {
                System.out.println(s);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
