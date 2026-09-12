package Multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task is running in thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task completed.");
            return 12;
        });
        CompletableFuture<Void> completedFuture = future.thenApply((res) -> {
            return res*2;
        }).thenAccept((result) -> {
            System.out.println("Final result: " + result);
        });


        // try {
        //     // Thread.sleep(5000); // Wait for the CompletableFuture to complete
        //     //Thread.currentThread().join(); // Wait for the main thread to finish
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        completedFuture.join(); // Wait for the CompletableFuture to complete

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("Task 1 is running in thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 1 completed.");
        });
        // future1.join(); // Wait for the second CompletableFuture to complete

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Task 2 is running in thread " + Thread.currentThread().getName());
                Thread.sleep(2000); // Simulate some work
                System.out.println("Task 2 completed.");
            } catch(InterruptedException ex) {
                ex.printStackTrace();
            }
            return 24;
        });

        CompletableFuture<Integer> future3 = future2.thenCompose((Integer res) -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("Task 3 is running in thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5000); // Simulate some work
                    System.out.println("Task 3 completed.");
                } catch(InterruptedException ex) {
                    ex.printStackTrace();
                }
                return res * 2;
            });
        });

        // future3.join(); // Wait for the third CompletableFuture to complete

        // CompletableFuture<Void> future4 = CompletableFuture.allOf(future1, future2, future3);
        CompletableFuture<Object> future4 = CompletableFuture.anyOf(future1, future2, future3);
        future4.join(); // Wait for all CompletableFutures to complete

        CompletableFuture<Void> future5 = future2.thenCombine(future3, (res1, res2) -> {
            System.out.println("Final result: " + (res1 + res2));
            return null;
        });

        future5.join(); // Wait for the fifth CompletableFuture to complete

        CompletableFuture<Void> future6 = future2.handle((res, ex) -> {
            if(ex != null) {
                System.out.println("Exception occurred: " + ex.getMessage());
            } else {
                System.out.println("Task 2 completed successfully with result: " + res);
            }
            return null;
        });
        future6.join(); // Wait for the sixth CompletableFuture to complete

        CompletableFuture<Integer> future8 = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Simulated exception in Task 8");
        });

        CompletableFuture<Integer> future7 = future8.exceptionally((ex) -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return null;
        });
        future7.join(); // Wait for the seventh CompletableFuture to complete
    }
}
