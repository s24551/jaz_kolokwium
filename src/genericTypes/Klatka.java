package genericTypes;

public class Klatka<T> {
    String zwierze;
    T charakterystyka;          // typ pola w klasie

    public Klatka(String zwierze, T charakterystyka) {
        this.zwierze = zwierze;
        this.charakterystyka = charakterystyka;
    }
}
