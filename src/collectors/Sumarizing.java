package collectors;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Sumarizing {
    public static void run(){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Kamil",33,1.75));
        people.add(new Person("Mariusz",75,1.80));
        people.add(new Person("Dominik",37,1.63));

        IntSummaryStatistics collect = people.stream()
                .collect(Collectors.summarizingInt(person -> person.getAge()));
        System.out.println(collect);                    //wyswietla nam wszystkie statystyki
        System.out.println(collect.getMax());           //wypisanie maksymalnej wartosci ze statysyk
        System.out.println(collect.getMin());           //wypisanie minimanej wartosci ze statysyk
        System.out.println(collect.getSum());           //suma wszystkich podanych ze statystyk
        System.out.println(collect.getAverage());       //wypisanie sredniej z podanej statystyki


    }
}
