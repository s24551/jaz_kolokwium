package reflections;

import java.lang.reflect.*;

public class Reflection {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Cat myCat = new Cat("Stella",6);
        Class<?> catClass = myCat.getClass();


        System.out.println(catClass.getName());                     //nazwa klasy
        System.out.println(catClass.getPackageName());              //nazwa pakietu klasy
        System.out.println(catClass.isInterface());                 //sprawdza czy jest interfejsem



        System.out.println();
        Field[] declaredFields = catClass.getDeclaredFields();  //wyciąganie pól z klasy Cat

        for (Field f: declaredFields
             ) {
            if(f.getName().equals("name")){
                f.setAccessible(true);              //zmiana z private na dostepny
                f.set(myCat,"Jerry");               //zmiana pola name z Stella na Jerry
            }
            System.out.println(f.getName());        //wypisanie nazw pól klasy Cat, wynik: name, age
        }
        System.out.println(myCat.getName());        //wynik: Jerry
        System.out.println();

        Method[] declaredMethods = catClass.getDeclaredMethods();

        for (Method m: declaredMethods
             ) {
            if(m.getName().startsWith("set")){          //wypisanie metod ktore są seterami
                System.out.println(m.getName());
            }
        }


        for (Method m: declaredMethods
        ) {
            if(m.getName().equals("heyThisIsPrivate")){         //wyszukanie metody ktora jest prywatna
                m.setAccessible(true);                          //zmiana modyfikatora dostepu na dostepny
                m.invoke(myCat);                                //wywolanie prywatnej metody
            }
        }


        for (Method m: declaredMethods
        ) {
            if(m.getName().equals("thisIsPrivateStaticMethod")){         //wyszukanie metody ktora jest prywatna i statyczna
                m.setAccessible(true);                          //zmiana modyfikatora dostepu na dostepny
                m.invoke(null);                                //jesli chcemy wywolac metode static to musimy wpisac null
            }
        }
        System.out.println();
        Constructor[] catClassConstructors = catClass.getConstructors();

        for (Constructor c: catClassConstructors
             ) {
            if(c.getParameterCount() == 0){
                System.out.println("brak argumentow");
            }else{
                Parameter[] parameters = c.getParameters();
                for (Parameter param:parameters
                     ) {
                    System.out.println(param.getName() + " " + param.getType());
                }
            }
        }


    }
}

/*
Method stuff:

Nazwa metody
Get a method's name:
method.getName();

Typ zwracany metody
Get a method's return type:
method.getReturnType();

Wywolanie metody
Invoke a method:
method.invoke(anyParameters, listedLikeThis);

Jesli metoda jest prywatna zmien dostepnosc
If it's private or not accessible, put this before it:
method.setAccessible(true);

Sprawdzania czy metoda ma adnotacje
See if a method has an annotation:
method.isAnnotationPresent(NameOfAnnotation.class);

Sciaganie adnotacji z metody
Get an annotation from a method:
method.getAnnotation(NameOfAnnotation.class);

Typ parametru metody        public static blabla(typParametru nazwaParametru
Get a method's parameter types:
method.getParameterTypes();

Uzyskaj adnotacje dotyczące parametrów metody:
Get annotations on a method's parameters:
method.getParameterAnnotations()

Pobierz klasę, która deklaruje tę metodę:
Get the class that declares this method:
method.getDeclaringClass();

Uzyskaj wszystkie wyjątki, które metoda deklaruje, że może rzucić:
Get all exceptions the method declares it can throw:
method.getExceptionTypes();


Field stuff:

Uzyskaj wartość pola:
Get the value of a field:
field.get(objectToGetThisFieldFrom);

Uzyskaj typ pola
Get the type of a field:
Field.getType();

Ustaw wartosc pola:
Set the value of a field:
field.set(objectToSetThisFieldOn, valueToSetTheFieldTo);

Uzyskaj nazwe pola
Get the name of a field:
field.getName();

Sprawdzenie czy pole ma adnotacje
See if a field has an annotation:
field.isAnnotationPresent(NameOfAnnotation.class);

Sciaganie adnotacji z pola
Get an annotation from a field:
field.getAnnotation(NameOfAnnotation.class);

Pobierz klasę, która deklaruje to pole:
Get the class that declares this field:
method.getDeclaringClass();


Class stuff:

Uzyskaj nazwe klasy
Get a class's name:
class.getName();

Sprawdzenie czy klasa ma adnotacje
See if a class has an annotation:
class.isAnnotationPresent(NameOfAnnotation.class);

Uzyskanie adnotacji z klasy
Get an annotation from a class:
class.getAnnotation(NameOfAnnotation.class);

Uzyskanie pól klasy
Get declared fields:
class.getDeclaredFields();

Pobierz wszystkie pola, które będą zawierać pola zadeklarowane w klasach nadrzędnych:
Get all fields, which will include fields declared in parent classes:
class.getFields();

Uzyskanie metod
Get declared methods:
class.getDeclaredMethods();

Pobierz wszystkie metody, które będą zawierać pola zadeklarowane w klasach nadrzędnych:
Get all methods, which will include fields declared in parent classes:
class.getMethods();

awaryjnie:
https://github.com/Michal-Koter/Advanced-JAVA/blob/master/lab-05-Michal-Koter/demo/src/main/java/org/example/simpleMethod/SimpleMethod.java
 */
