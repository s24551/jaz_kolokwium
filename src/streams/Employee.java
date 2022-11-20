package streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

        List<List<String>> collect = employees.stream() //ctrl + alt + v && option + cmd + v tworzenie zmiennej
                .map(employee -> employee.getSkills())  //zmieniamy z calego obiektu na umiejetnosci
                .collect(Collectors.toList());  //tworzymy jedna liste ze wszystkimi listami umiejetnosciami (listy w liscie)
        System.out.println(collect);
        System.out.println();

        List<String> collect1 = employees.stream()
                .map(employee -> employee.getSkills())
                .flatMap(list -> list.stream())     //tworzymy liste z pojedynczymi umiejetnosciami (jedna lista)
                .distinct()            //usuwa duplikaty z listy
                .collect(Collectors.toList());      //przypisanie do listy
        System.out.println(collect1);
        System.out.println();
         employees.stream()
                .filter(employee -> employee.getAge() > 20)                     //jesli wiek jest wiekszy niz 20 to dodaj do strumienia
                 .filter(employee -> employee.getFirstName().startsWith("J"))   //jesli imie zaczyna sie na J to dodaj do strumienia
                 .forEach(employee -> System.out.println(employee));            //wypisz obiekty ktore przeszly filtrowanie
        System.out.println();

        List<String> collect2 = employees.stream()
                .sorted(Comparator.comparing(employee -> employee.getAge()))    //sortujemy wszystkie obiekty rosnaco
                .map(employee -> employee.getAge() + " " + employee.firstName)                //wyciagamy tylko wiek i wiek osoby
                .collect(Collectors.toList());                      //przypisujemy do listy
        System.out.println(collect2);
        System.out.println();

        employees.stream()
                .sorted(Comparator.comparing(employee -> employee.getAge()))            //sortujemy rosnaco
                .limit(2)                           //bierzemy tylko pierwsze dwa
                .map(employee -> employee.getAge() + " " + employee.getFirstName())     //bierzemy wiek i imie dwoch pierwszych obiektow
                .forEach(employee -> System.out.println(employee));
        System.out.println();
        List<String> strings = employees.stream()
                .sorted(Comparator.comparing(employee -> employee.getAge()))            //sortujemy rosnaco
                .skip(2)                           //pomijamy pierwsze dwa i bierzemy wszystkie po
                .map(employee -> employee.getAge() + " " + employee.getFirstName())     //bierzemy wiek i imie wszystkich oprocz pierwszych dwoch
                .toList();
        System.out.println(strings);
        System.out.println();

        long count = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("K"))
                .count();       //zlicza ilosc elementow w strumieniu
        System.out.println(count);
        System.out.println();

        Employee youngestEmployee = employees.stream()
                .min(Comparator.comparing(employee -> employee.getAge())).get();                //najmniejszy wiek
        System.out.println(youngestEmployee.getAge() + youngestEmployee.getFirstName());
        System.out.println();
        Employee oldestEmployee = employees.stream()
                .max(Comparator.comparing(employee -> employee.getAge())).get();                //najwiekszy wiek
        System.out.println(oldestEmployee.getAge() + oldestEmployee.getFirstName());
        System.out.println();

        Employee firstEmployerWithNameStartsWithJ = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("J"))        //najpierw filtrujemy
                .findFirst().get();                                                 //przesylamy tylko pierwszy obiekt spelniajacy filtracje
                                    //opcjonalnie mozna zmienic na findAny wtedy bierze losoy obiekt spelniajacy warunek filtracji
        System.out.println(firstEmployerWithNameStartsWithJ.firstName);
        System.out.println();
        boolean allMatch = employees.stream()
                .allMatch(employee -> employee.getAge() > 30);//sprawdzamy czy wszystkie obiekty spelniaja warunek >30
        System.out.println(allMatch);
        System.out.println();
        boolean anyMatch = employees.stream()
                .anyMatch(employee -> employee.getAge() > 30);      //sprawdzamy czy jakikolwiek obiekt spelnia warunek >30
        System.out.println(anyMatch);
        System.out.println();

        Integer sumOfAllAges = employees.stream()
                .map(employee -> employee.getAge())         //musimy zmapowac na typ ktorego potrzebujemy
                .reduce((age1, age2) -> age1 + age2)    //wypisujemy logike
                .get();                                 //sciagamy wynik logiki
        System.out.println(sumOfAllAges);
        System.out.println();

        Integer sumOfAllAges2 = employees.stream()
                .map(employee -> employee.getAge())                         //musimy zmapowac na typ ktorego potrzebujemy
                .reduce(10,(age1, age2) -> age1 + age2);            //nadajemy wartosc poczatkowa a nastepnie logike do niej
        System.out.println(sumOfAllAges2);
        System.out.println();

        String namesWithPrzecinek = employees.stream()
                .map(employee -> employee.getFirstName())
                .reduce((name1, name2) -> name1 + ", " + name2) //dodanie przecinka miedzy imionami
                .get();
        System.out.println(namesWithPrzecinek);

        employees.stream()
                .sorted(Comparator.comparing(employee -> employee.getAge()))
                .takeWhile(employee -> employee.getAge() < 30)                  //wykonuj dopoki nie przekroczy 30
                .forEach(employee -> System.out.println(employee));




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