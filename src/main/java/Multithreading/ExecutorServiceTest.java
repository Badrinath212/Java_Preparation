package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.xml.catalog.CatalogFeatures.Feature;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i=0; i<5; i++) {
            int taskId = i;
            Future<Integer> future = executorService.submit(() -> {
                System.out.println("Task " + taskId + " is running in thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return taskId;
            });
        }

        executorService.shutdown();

        try {
            boolean isAllTasksCompleted = executorService.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
            if(isAllTasksCompleted) {
                System.out.println("All tasks completed successfully.");
            } else {
                System.out.println("Timeout occurred before all tasks could complete.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=0; i<5; i++) {
            int taskId = i;
            executorService.execute(() -> {
                System.out.println("Task " + taskId + " is running in thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskId + " completed.");
            });
        }
    }
}
