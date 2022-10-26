package guru.springframework.spring5webapp.petclinic.fauxspring;

import guru.springframework.spring5webapp.petclinic.model.PetType;

import java.text.ParseException;
import java.util.Locale;


public interface Formatter<T> {

    String print(PetType petType, Locale locale);

    PetType parse(String text, Locale locale) throws ParseException;
}
