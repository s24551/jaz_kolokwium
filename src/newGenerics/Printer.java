package newGenerics;

public class Printer <T>{       //definicja wlasnego typu generycznego
    T thingToPrint;         //pole typu generycznego

    public Printer() {
    }

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print(T thingToPrint){          //typ generyczny w parametrze metody
        System.out.println(thingToPrint);
    }
}
