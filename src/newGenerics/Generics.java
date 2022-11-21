package newGenerics;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {

        Printer<Integer> printer = new Printer<>();
        printer.print(46);

        Printer<String> stringPrinter = new Printer<>();
        stringPrinter.print("Essa");

        AnimalsPrinter<Cat> catAnimalsPrinter = new AnimalsPrinter<>(new Cat());

        shout(5040,"Marek");
shout("Witam","Essa");

//WildCards

        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(60);
        printList(integerList);


        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        printListOfAnimals(catList);

        //  printListOfAnimals(integerList);    wywala blad bo integerList jest typu integer a ograniczylismy do klas dziedziczacych po Animal
    }
    public static <T,V> void shout(T somethingToShout, V secondThingToShout){    //metoda typu generycznego - zwraca dowolny typ
        System.out.println(somethingToShout + "!!!!!");
        System.out.println(secondThingToShout + "!!!!!");
    }

    //WildCards
    private static void printList(List<?> myList){      //listy wszystkich typow sa akceptowane
        System.out.println(myList);
    }

    private static void printListOfAnimals(List<? extends Animal> myAnimalList){            //ograniczamy liste na typy dziedziczace po Animal
        System.out.println(myAnimalList);
    }
}
