package genericTypes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        Klatka<Integer> doubleKlatka = new Klatka<>();
    }



    private static <T> T printArray(List<T> arr) {
        T element = arr.get(0);
        arr.forEach(System.out::println);
        return arr.get(0);
    }

    // ograniczenia typu generycznego:
//    do list: <? extends T> && <? super T>
//    do innych: <T extends nazwaKlasy <--- moze byc typem dzieci klasy / najlepiej interfejsu

}
