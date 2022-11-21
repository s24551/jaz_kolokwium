package newGenerics;

public class AnimalsPrinter <E extends Animal>{     //ograniczenie typu dla klas dziedziczacych po Animal
    E thingToPrint;         //pole typu generycznego

    public AnimalsPrinter() {
    }

    public AnimalsPrinter(E thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print(E thing){//typ generyczny w parametrze metody
        thingToPrint.eat();
        System.out.println(thing);
    }
}
