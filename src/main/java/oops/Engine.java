package oops;

public class Engine {
    private String engineType;

    public Engine(String engineType) {
        this.engineType = engineType;
    }
    public void startEngine() {
        System.out.println("Engine started");
        System.out.println("Engine type: " + engineType);
    }
}
