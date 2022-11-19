package lambdaExpressions;

import genericTypes.Klatka;

import java.io.File;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        User u = new User(){};

        int x = 5;
        DoubleToIntFunction doubleToIntFunction = cx -> x * x;
        DoubleToIntFunction doubleToIntFunction1 = z -> {
            if (x == 5) {
                return 10;
            }
            return 0;
        };
        Function<String, File> xxx = s -> new File(s);
        Function<String, Integer> f = String::length;
        Consumer<String> c = (s) -> System.out.println(s);
        ABC abc = () -> System.out.println("calling");

        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        integers.forEach(i -> System.out.println(i));
        integers.stream()
                        .filter()

        aaa(s -> s.length() > 10);

    }

    public static void aaa(Predicate<String> p) {
        if (p.test("cleb")) {
            System.out.println();
        }
    }
}
