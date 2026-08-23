package Streams;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Iterator;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}


public class StreamsTest {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);

        list.stream().filter(n -> n % 2 == 0).forEach(ele ->
            System.out.print(ele + " ")
        );

        System.out.println();
        System.out.println("Filtered list:");

        list.stream().filter(n -> n % 2 == 0).map(n -> n * 2).forEach(ele ->
            System.out.print(ele + " ")
        );

        System.out.println();
        System.out.println("Flat mapped list:");

        List<List<Integer>> nestedList = List.of(List.of(1,2,3), List.of(4,5,6), List.of(7,8,9));

        nestedList.stream().flatMap(List::stream).forEach(ele ->
            System.out.print(ele + " ")
        );

        System.out.println();
        System.out.println("Sorted list:");


        List<Integer> list2 = List.of(5,3,2,8,1,9,4,7,7,6,6);
        
        list2.stream().sorted().forEach(ele ->
            System.out.print(ele + " ")
        );

        System.out.println();
        System.out.println("Distinct list:");

        list2.stream().distinct().forEach( ele ->
            System.out.print(ele + " ")
        );

        System.out.println();
        System.out.println("Limited list:");
        list2.stream().limit(3).forEach(ele -> 
            System.out.print(ele + " ")
        );

        System.out.println();
        System.out.println("Skipped list:");
        list2.stream().skip(3).forEach(ele -> 
            System.out.print(ele + " ")
        );

        System.out.println();
        List<Integer> resList = list2.stream().map(n -> n*2).collect(Collectors.toList());
        System.out.println(resList);


        System.out.println();
        System.out.println("Group by Department:");

        List<Employee> employees = List.of(new Employee("John", "IT"),
                                            new Employee("Mary", "IT"),
                                            new Employee("Tom", "IT"),
                                            new Employee("John", "HR"),
                                            new Employee("Mary", "HR"),
                                            new Employee("Tom", "HR"),
                                            new Employee("John", "IT"),
                                            new Employee("Mary", "IT"),
                                            new Employee("Tom", "IT"),
                                            new Employee("John", "HR"),
                                            new Employee("Mary", "HR"),
                                            new Employee("Tom", "HR"));
        Map<String, List<Employee>> groupedEmployees = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        Iterator<Map.Entry<String, List<Employee>>> iterator = groupedEmployees.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Employee>> entry = iterator.next();
            System.out.println("Department: " + entry.getKey());
            entry.getValue().forEach(employee -> System.out.println(employee.getName()));
            System.out.println();
        }

        System.out.println();
        System.out.println("partitioning:");

        Map<Boolean, List<Integer>> partitionedList = list2.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        partitionedList.forEach((key, value) -> {
            System.out.println("Partition key: " + key);
            value.forEach(ele -> System.out.print(ele + " "));
            System.out.println();
        });

        System.out.println();
        System.out.println("Reducing:");

        int sum = list2.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);

        int max = list2.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println("Max: " + max);

        int min = list2.stream().reduce(0, (a, b) -> a < b ? a : b);
        System.out.println("Min: " + min);

        double avg = list2.stream().reduce(0, (a, b) -> a + b) / list2.size();
        System.out.println("Average: " + avg);

        System.out.println();
        System.out.println("finding first based on condition:");

        Optional<Employee> firstEmployee = employees.stream().filter(e -> e.getName().equals("John")).findFirst();
        if(firstEmployee.isPresent()) {
            System.out.println("First employee: " + firstEmployee.get().getName());
        }

        System.out.println();
        System.out.println("finding last based on condition:");

        Optional<Employee> lastEmployee = employees.stream().filter(e -> e.getName().equals("Tom")).findFirst();
        if(lastEmployee.isPresent()) {
            System.out.println("Last employee: " + lastEmployee.get().getName());
        }

        System.out.println();
        System.out.println("Checking matching:");

        boolean isMatching = employees.stream().anyMatch(e -> e.getName().equals("John"));
        System.out.println("Is matching: " + isMatching);

        isMatching = employees.stream().allMatch(e -> e.getDepartment().equals("IT"));
        System.out.println("Is matching: " + isMatching);

        System.out.println();
        System.out.println("Checking none matching:");

        boolean isNoneMatching = employees.stream().noneMatch(e -> e.getName().equals("John"));
        System.out.println("Is none matching: " + isNoneMatching);

        isNoneMatching = employees.stream().noneMatch(e -> e.getDepartment().equals("IOT"));
        System.out.println("Is none matching: " + isNoneMatching);

    }
    
}
