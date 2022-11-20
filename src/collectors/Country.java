package collectors;

public class Country {
    private String name;
    private String capital;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }
}
