package collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ToListSetMap {
    public static void run() {
        //toSet toList
        List<String> teams = new ArrayList<>();

        teams.add("Poland");
        teams.add("Slovakia");
        teams.add("Spain");
        teams.add("Sweden");
        teams.add("Sweden");

        List<String> listOfTeams = teams.stream()
                .filter(team -> team.startsWith("S"))   //filtrujemy te ktore zaczynaja sie na S
                .collect(Collectors.toUnmodifiableList());       //przypisujemy do Set(unikalne) albo do Listy(wszystkie)
        //i blokujemy mozliwosc edytowania tej listy
//listOfTeams.add("Scotland");
        System.out.println(listOfTeams);

        Set<String> setOfTeams = teams.stream()
                .filter(team -> team.startsWith("S"))   //filtrujemy te ktore zaczynaja sie na S
                .collect(Collectors.toSet());       //przypisujemy do Set(unikalne) albo do Listy(wszystkie)

        System.out.println(setOfTeams);

//toMap
        Country polandCountry = new Country("Poland", "Warsaw");
        Country polandCountry2 = new Country("Poland", "Gdansk");
        Country spainCountry = new Country("Spain", "Madrid");
        List<Country> countries = new ArrayList<>();
        countries.add(polandCountry);
        countries.add(polandCountry2);
        countries.add(spainCountry);

        Map<String, String> countriesWithCapitals = countries.stream()  //mapa = Poland = Warsaw, Spain=Madrid
                //mozna dodac filter, wtedy stworzy sie mapa tylko dla wyfiltrowanych
                .collect(Collectors.toMap(country -> country.getName(), country -> country.getCapital(),(cap1,cap2) -> cap1 + "," + cap2));
        //(cap1,cap2) -> cap1 + "," + cap2)); jesli chcemy dodac dwie rzeczy do jednego klucza
        System.out.println(countriesWithCapitals );
    }
}
