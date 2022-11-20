package collectors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountingSummingAverage {
    public static void run(){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Kamil",33,1.75));
        people.add(new Person("Mariusz",75,1.80));
        people.add(new Person("Dominik",37,1.63));

        Long collect = people.stream()
                .collect(Collectors.counting());        //zlicza ilosc elementow streama
        System.out.println(collect);

        Integer sumowanieWieku = people.stream()
                .collect(Collectors.summingInt(person -> person.getAge()));     //sumowanie podanych elementow
        System.out.println(sumowanieWieku);

        Double sumowanieWzrostu = people.stream()
                .collect(Collectors.summingDouble(person -> person.getHeight()));     //sumowanie podanych elementow
        System.out.println(sumowanieWzrostu);

        Double sredniaWieku = people.stream()
                .collect(Collectors.averagingInt(person -> person.getAge()));       //wyliczanie sredniej podanych elementow
        System.out.println(sredniaWieku);

        Double sredniWzrost = people.stream()
                .collect(Collectors.averagingDouble(person -> person.getHeight()));
        System.out.println(sredniWzrost);

        Optional<Integer> wyswiewtlanieNajmlodszego = people.stream()
                .map(person -> person.getAge())
                .collect(Collectors.minBy(Comparator.naturalOrder()));      //wyciaganie najmniejszej wartosci z podanych elementow
        System.out.println(wyswiewtlanieNajmlodszego.get());



    }

}
