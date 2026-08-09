package oops;

public class Car extends Engine {
    private String name;
    
    // private constructor
    /* private Car(String str) {
        System.out.println("Car constructor called" + str);
    } */

    // public constructor   
    public Car(String str) {
        super("Toyota");
        this.name = str;
        System.out.println("Car constructor called" + str);
    }

    // default constructor
    /* public Car() {
         System.out.println("Car constructor called");
    }*/

    // copy constructor
    /* public Car(Car car) {
         this.name = car.name;
         System.out.println("Car constructor called");
    } */

    // calling private constructor using the constructor chaining
    /* public Car() {
        this("Badri");
    } */

    // calling private constructor using static method
    /* public static Car callPrivateConstructor(String str) {
        return new Car(str);
    } */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
