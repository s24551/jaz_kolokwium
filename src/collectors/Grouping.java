package collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
    public static void run(){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Kamil",33,1.75));
        people.add(new Person("Mariusz",75,1.80));
        people.add(new Person("Dominik",37,1.63));

        Map<Integer, List<Person>> collect = people.stream()
                .collect(Collectors.groupingBy(person -> person.getAge()));
        System.out.println(collect);

        List<String> teams = new ArrayList<>();

        teams.add("Poland");
        teams.add("Slovakia");
        teams.add("Spain");
        teams.add("Sweden");

        Map<Integer, List<String>> poDlugosci = teams.stream()
                .collect(Collectors.groupingBy(String -> String.length())); //zlicza ilosc liter i grupuje
                                                                        //{5=[Spain], 6=[Poland, Sweden], 8=[Slovakia]}
        System.out.println(poDlugosci);

        Map<Boolean, List<String>> ktoreZaczynajaSieNaS = teams.stream()
                .collect(Collectors.partitioningBy(s -> s.startsWith("S")));//grupuje wartosci na te ktore zaczynaja sien a S i na te ktore nie
        System.out.println(ktoreZaczynajaSieNaS);   //{false=[Poland], true=[Slovakia, Spain, Sweden]}

        Map<Boolean, List<String>> tylkoTeCoZaczynajaSieNaS = teams.stream()
                .collect(Collectors.partitioningBy(s -> s.startsWith("S")));//grupuje wartosci na te ktore zaczynaja sien a S i na te ktore nie
        System.out.println(tylkoTeCoZaczynajaSieNaS.get(true));   //[Slovakia, Spain, Sweden]

        Map<Boolean, List<Person>> ktorzyMajaWiecejNiz38 = people.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() > 38));//grupuje wartosci na te ktore maja wiecej niz 38 i na te ktore nie
        System.out.println(ktorzyMajaWiecejNiz38);
        //{false=[Person{name='Kamil', age=33, height=1.75}, Person{name='Dominik', age=37, height=1.63}], true=[Person{name='Mariusz', age=75, height=1.8}]}
    }
}
