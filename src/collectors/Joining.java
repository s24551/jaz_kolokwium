package collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Joining {
    public static void run(){
        List<String> names = new ArrayList<>();
        names.add("Kamil");
        names.add("Mariusz");
        names.add("Dominik");


        String joinedNames = names.stream()
                .collect(Collectors.joining(" "));      //łączy nam wszystkie stringi i dodaje pomiedzy spacje
        System.out.println(joinedNames);
    }
}
