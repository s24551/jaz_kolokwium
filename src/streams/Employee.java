package streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Employee {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("Jakub","Hoffmann",21,List.of("Java","Python","PHP"));
        Employee employee2 = new Employee("Krystian","Kaźmierczak",36,List.of("C#"));
        Employee employee3 = new Employee("Józef","Szymański",72,List.of("Python","C++"));
        Employee employee4 = new Employee("Pamela","Sawicka",18,List.of("Scala","Java","React","Angular"));
        Employee employee5 = new Employee("Jolanta","Kołodziej",16,List.of("Java","Spring","Hibernate","Java"));
        Employee employee6 = new Employee("Konstanty","Dąbrowski",44,List.of("Rust","Python"));
        Employee employee7 = new Employee("Kamila","Kaczmarczyk",52,List.of("Java","Python","PHP"));
        Employee employee8 = new Employee("Kamil","Urbański",39,List.of("PHP","JavaScript","Haskeel"));
        Employee employee9 = new Employee("Marek","Mostowiak",55,List.of("Swift"));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);
        employees.add(employee9);


        employees.stream()  // definicja streama
                .forEach(employee -> System.out.println(employee));     //wypisanie wszystkich obiektow przekazanych do streama

        System.out.println();

        employees.stream()
                .map(employee -> employee.getFirstName())       //zmiana typu z calego obiektu na Stringa z imieniem
                .forEach(e -> System.out.println(e));

        System.out.println();

        employees.stream()
                .map(employee -> employee.getSkills())
                .collect(Collectors.toList());

    }

    private String firstName;
    private String lastName;
    int age;

    private List<String> skills;

    public Employee(String firstName, String lastName, int age, List<String> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                '}';
    }


}