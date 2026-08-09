package oops;

public class ObjectTest {
    public static void main(String[] args) {
        Object ride = new Ride("Badri", 100);
        System.out.println(ride.toString());
        System.out.println(ride.hashCode());
    }
}
