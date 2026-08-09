package oops;

public class Ride extends Object {
    private String name;
    private int distance;

    public Ride(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }

    @Override
    public int hashCode() {
        return 2;
    }

}
