package lambdaExpressions;

import genericTypes.Klatka;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        User u = new User(){};

//lambda na podstawie wlasnego interfejsu
        StringConnector sc = (first, second, separator) -> (first.concat(separator).concat(second)).length();

        System.out.println(sc.connect("essa","wariacie",","));

        //klasa anonimowa
        Predicate<Student> predicateTest = new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                if(student.getAge()>30){
                return true;
            }else {
                    return false;
                }
        }
        };

        System.out.println(predicateTest.test(new Student("Borys",40,"123123123")));//true

        Function<String, File> xxx = s -> new File(s);
        Function<String, Integer> f = String::length;
        Consumer<String> c = (s) -> System.out.println(s);
        ABC abc = () -> System.out.println("calling");

        List<Integer> integers = List.of(1, 2, 3, 4, 5);
//        integers.forEach(i -> System.out.println(i));
        integers.stream()
                        .filter(integer -> integer>3)
                        .forEach(integer -> System.out.println(integer));






        String text;
        text = "Przykladowy tekst";

        Predicate<String> predicateExample = s -> s.length()>10;            //lambda jako zmienna
        System.out.println();
        aaa(predicateExample,text);     //lambda w konstruktorze  s -> s.length()>10,text
        System.out.println();
/************************************************************************************
 *
 *
 *
 *
 */
        //Supplier - nie przyjmuje żadnego obiektu na wejściu, ale zwraca obiekt (dostawca)
        Supplier<Integer> descriptionSupplier = () -> 12566;
        useSupplier(descriptionSupplier);

        //Consumer - przyjmuje obiekt na wejściu, ale niczego nie zwraca (konsumer)
        //wykonuje operacje na obiekcie nic nie zwracajac
        Integer initialId = 2;

        Consumer<Integer> printConsumer = id -> {

            Integer idNumberShift = 5;
            System.out.println(initialId + idNumberShift + id);
        };
        useConsumer(printConsumer);

        Consumer<String> printConsumer2 = s -> System.out.println(s);
        printConsumer2.accept("SIEMANDERO");                            //wkladamy stringa do consumera i nam go wypluwa


        //Predicate - przyjmuje obiekt na wejściu i zwraca wartość PRAWDA lub FAŁSZ (predykat)
        //na podstawie jakiegos obiektu zwraca nam true lub false
        Predicate<String> testPredicate = name -> name.length() > 3;
        usePredicate(testPredicate);


        Predicate<String> testPredicate2 = name -> name.length() > 3;
        System.out.println(testPredicate2.test("ea"));      //zwraca false

        //Function - przyjmuje obiekt na wejściu i zwraca obiekt na wyjściu (funkcja)
        Function<String, Integer> functionApplier = s -> s.length();        //dajemy stringa otrzymujemy integer
        System.out.println(functionApplier.apply("Witam serdecznie"));      //wynik 16

        //******************************************
        System.out.println("");
        Predicate<Student> over30 = student -> student.getAge()>30;         //jesli wiek jest wiekszy niz 30 to true
    Consumer<String> print = t -> System.out.println(t);                    //wypisz to co otrzymales
    Supplier<List<Student>> supplyPredefinedStudents = () -> createData();
    Function<Student,String> getStudentName = student -> student.getName(); //z obiektu Studenta bierzemy tylko imiona


    consumeStudents(filterStudents(supplyPredefinedStudents, over30),getStudentName,print);
    //(przefiltrujStudentow(zPodanejListy,tylkoTychPowyzej30lat),wyciagnijJegoImie,wypisz
    }


    public static void aaa(Predicate<String> p, String text) {
        if (p.test(text)) {
            System.out.println("jest dluzsze niz 10 znakow");
        }
    }



    public static void useSupplier(Supplier<Integer> descriptionSupplier) {
        System.out.println(descriptionSupplier.get());
    }

    static void useConsumer(Consumer<Integer> consumer) {
        consumer.accept(10);
    }

    static void usePredicate(Predicate<String> predicate) {
        System.out.println(predicate.test("JavaAplikacja"));
    }


//******************************************

    private static void consumeStudents(List<Student> students, Function<Student,String> function, Consumer<String> consumer) {
        for(Student s : students) {
            consumer.accept(function.apply(s));
        }
    }

    private static List<Student> filterStudents(Supplier<List<Student>> supplier, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();

        List<Student> students = supplier.get();

        for(Student s : students) {
            if(predicate.test(s)) {
                result.add(s);
            }
        }

        return result;
    }


    private static List<Student> createData() {
        List<Student> result = new ArrayList<>();

        result.add(new Student("Pawel", 31, "123456"));
        result.add(new Student("John", 29, "67890"));
        result.add(new Student("Billy", 32, "45678"));

        return result;
    }
}


//

