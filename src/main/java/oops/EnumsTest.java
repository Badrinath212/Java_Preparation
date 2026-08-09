package oops;

enum Color {
    RED("Hello Red"), GREEN("Hello Green"), BLUE("Hello Blue");

    private final String greeting;

    private Color(String greeting) {
        this.greeting = greeting;
    }

    public void printGreeting() {
        System.out.println(greeting);
    }
}
public class EnumsTest {
    public static void main(String[] args) {
        Color color = Color.RED;
        color = Color.GREEN;
        color = Color.BLUE;
        System.out.println(color);
        color.printGreeting();
    }
}
