package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

public class SemaphoreTest {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2); // Allow 2 threads to access the resource at a time
        
        List<Person> people = new CopyOnWriteArrayList<>();

        Thread thread1 = new Thread(() -> {
            try {
                semaphore.acquire();
                people.add(new Person("John"));
                Thread.sleep(2000); // Simulate some work with the resource
                System.out.println("size: " + people.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                semaphore.acquire();
                people.add(new Person("Jane"));
                Thread.sleep(2000); // Simulate some work with the resource
                System.out.println("size: " + people.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                semaphore.acquire();
                people.add(new Person("Bob"));
                Thread.sleep(2000); // Simulate some work with the resource
                System.out.println("size: " + people.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
