package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)               //gdzie adnotacja moze byc przypisana type - klasa
// @Target({ElementType.TYPE, ElementType.METHOD) jesli chcemy dla wiekszej ilosci
@Retention(RetentionPolicy.RUNTIME)
public @interface VeryImportant {



}
