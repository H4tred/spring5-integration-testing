package guru.springframework.spring5webapp.petclinic.controllers;

import guru.springframework.spring5webapp.petclinic.fauxspring.Model;
import guru.springframework.spring5webapp.petclinic.services.VetService;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
