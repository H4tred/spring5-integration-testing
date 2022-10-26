package guru.springframework.spring5webapp.petclinic.repositories;

import guru.springframework.spring5webapp.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
