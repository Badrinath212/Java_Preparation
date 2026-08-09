import oops.Author;
import oops.Car;
import oops.Remote;
import oops.TV;
import oops.TVInterface;
import oops.Vehicle;
import oops.Employee;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        TVInterface tv = new Remote();
        tv.play();
        tv.pause();
        TVInterface.hello();
        System.out.println(TVInterface.count);
        tv.stop();

        
        
        Car car = new Car("Badri");
        Vehicle vehicle = new Vehicle(car);
        
        // Need to invoke the parant consturctor using super keyword & attributes passing also

        car.startEngine();

        @Author(name = "John", email = "john@gmail.com", version = 2)
        Employee employee = new Employee("John", 30, "IT");
        System.out.println(employee.name());
        System.out.println(employee.age());
        System.out.println(employee.department());
        System.out.println(employee.toString());
        System.out.println(employee.hashCode());
        System.out.println(employee.equals(new Employee("John", 30, "IT")));
    }
    
}
