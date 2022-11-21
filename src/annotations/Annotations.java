package annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Annotations {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat myCat = new Cat("Stella");

        if (myCat.getClass().isAnnotationPresent(VeryImportant.class)) {      //sprawdzenie czy adnotacja zostala uzyta na klasie
            System.out.println("This thing is very important");
        } else {
            System.out.println("Its not very important");
        }


        Method[] declaredMethods = myCat.getClass().getDeclaredMethods();

        for (Method method : declaredMethods
        ) {
            if (method.isAnnotationPresent(RunImmediately.class)) {   ///sprawdzenie ktora metoda ma adnotacje
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);     //stworzenie obiektu adnotacji
                System.out.println(annotation.times());     //wypisanie wartosci parametru adnotacji

                for (int i = 0; i < annotation.times(); i++) {              //wyciagniecie parametru times z adnotacji
                    method.invoke(myCat);           //wywolanie metody ktora posiada adnotacje
                }
            }
        }

        Field[] declaredFields = myCat.getClass().getDeclaredFields();
        for (Field field:declaredFields
             ) {
            if(field.isAnnotationPresent(ImportantString.class)){
                field.setAccessible(true);          //name jest private wiec trzeba zmienic modyfikator
                Object objectValue = field.get(myCat);//bierzemy wartosc obiektu
                System.out.println();
                System.out.println(objectValue);
                if(objectValue instanceof String stringValue){      //jesli wartosc obiektu jest stringiem to przypisujemy do wartosci stringValue
                    System.out.println(stringValue.toUpperCase());      //wypisanie jako String
                }
            }
        }


    }
}
