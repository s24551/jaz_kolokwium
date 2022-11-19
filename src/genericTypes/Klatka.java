package genericTypes;

public class Klatka<T> {
    String zwierze;
    T charakterystyka;

    public Klatka(String zwierze, T charakterystyka) {
        this.zwierze = zwierze;
        this.charakterystyka = charakterystyka;
    }
}
