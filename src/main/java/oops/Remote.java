package oops;

public class Remote implements TVInterface {
    @Override
    public void play() {
        System.out.println("Playing TV");
    }
    @Override
    public void pause() {
        System.out.println("Pausing TV");
    }

    @Override
    public void stop() {
        System.out.println("Stopping TV");
    }

    public static void hello() {
        System.out.println("Hello World! from remote");
    }
}
