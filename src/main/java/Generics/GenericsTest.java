
package Generics;

import java.util.ArrayList;
import java.util.List;

class Book<T> {
    private T data;
    public Book(T data) {
        this.data = data;
        System.out.println("Generic class called");
    }
    public T getData() {
        return data;
    }

    public <T> void printData(T greet) {
        System.out.println(greet);
    }
}
public class GenericsTest {
    public static void main(String[] args) {
        Book<Integer> book = new Book<>(12);
        System.out.println(book.getData());

        Book<String> book2 = new Book<>("Hello");
        System.out.println(book2.getData());

        book2.printData("Hello world");
        book.printData(21);

        List<Integer> list = List.of(1,2,3,4,5);

        print(list);

        List<? super Number> list2 = new ArrayList<>();

        list2.add(1);
        list2.add(2.0);

        
    }

    public static void print(List<? extends Number> list) {
        for(Object obj : list) {
            System.out.println(obj);
        }
    }
}
