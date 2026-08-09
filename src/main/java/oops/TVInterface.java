package oops;

public interface TVInterface {
    public void play();
    public void pause();

    public static void hello() {
        System.out.println("Hello World!");
    }

    public static final int count = 10;

    default void stop() {
        privateMethod();
        System.out.println("Stopping TV");
    }

    private void privateMethod() {
        System.out.println("Private method called");
    }
}
