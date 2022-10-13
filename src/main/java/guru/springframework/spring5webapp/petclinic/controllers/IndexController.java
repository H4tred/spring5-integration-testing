package guru.springframework.spring5webapp.petclinic.controllers;

import guru.springframework.spring5webapp.petclinic.exceptions.ValueNotFoundException;

public class IndexController {

    public String index() {
        return "index";
    }

    public String oupsHandler() throws ValueNotFoundException {
        throw new ValueNotFoundException();
    }
}
