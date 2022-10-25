package guru.springframework.spring5webapp.petclinic.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import guru.springframework.spring5webapp.petclinic.fauxspring.Model;
import guru.springframework.spring5webapp.petclinic.fauxspring.ModelImpl;
import guru.springframework.spring5webapp.petclinic.model.Vet;
import guru.springframework.spring5webapp.petclinic.services.SpecialtyService;
import guru.springframework.spring5webapp.petclinic.services.VetService;
import guru.springframework.spring5webapp.petclinic.services.map.SpecialityMapService;
import guru.springframework.spring5webapp.petclinic.services.map.VetMapService;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VetControllerTest {

    VetController controller;
    VetService service;
    SpecialtyService specialtyService;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        service = new VetMapService(specialtyService);
        controller = new VetController(service);

        Vet vet = new Vet(1L, "Frodo", "Baggins", null);
        Vet vet2 = new Vet(2L, "Samwise", "Gamgee", null);
        service.save(vet);
        service.save(vet2);
    }

    @Test
    void listVets() {
        Model myModel = new ModelImpl();

        String view = controller.listVets(myModel);
        assertThat("vets/index").isEqualTo(view);

        Set modeAttribute = (Set) ((ModelImpl)myModel).getMap().get("vets");
        assertThat(modeAttribute.size()).isEqualTo(2);
    }
}