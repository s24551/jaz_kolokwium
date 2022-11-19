package lambdaExpressions;

@FunctionalInterface                        //wlasny interfejs ktory mozna uzyc jako lambde
public interface StringConnector {
    Integer connect(String first, String second, String separator);
}