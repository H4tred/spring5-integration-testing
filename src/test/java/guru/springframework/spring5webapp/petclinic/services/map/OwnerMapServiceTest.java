package guru.springframework.spring5webapp.petclinic.services.map;

import static org.assertj.core.api.Assertions.assertThat;
import guru.springframework.spring5webapp.petclinic.model.Owner;
import guru.springframework.spring5webapp.petclinic.model.PetType;
import guru.springframework.spring5webapp.petclinic.services.PetService;
import guru.springframework.spring5webapp.petclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("OwnerMapService Test:")
class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);
    }

    @DisplayName("Verify Zero Owners")
    @Test
    void ownersAreZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }

    /* #1 Nested Class*/
    @DisplayName("Pet Type:")
    @Nested
    class TestCreatePetTypes {

        @BeforeEach
        void setUp() {
            PetType petType = new PetType(1L, "Dragon");
            PetType petType2 = new PetType(2L, "Shark");
            petTypeService.save(petType);
            petTypeService.save(petType2);
        }

        @DisplayName("Test Pet Count")
        @Test
        void testPetCount() {
            int petTypeCount = petTypeService.findAll().size();
            assertThat(petTypeCount).isNotZero().isEqualTo(2);
        }

        /* #2 Nested Class*/
        @DisplayName("SaveOwnersTest:")
        @Nested
        class SaveOwnersTest {

            @BeforeEach
            void setup() {
                ownerMapService.save(new Owner(1L, "Before", "Each"));
            }

            @DisplayName("SaveOwner")
            @Test
            void saveOwner() {
                Owner owner = new Owner(2L, "Frodo", "Baggins");
                Owner savedOwner = ownerMapService.save(owner);
                assertThat(savedOwner).isNotNull();
            }

            /* #3 Nested Class*/
            @DisplayName("Save Owners Tests:")
            @Nested
            class findOwnersTests {

                @DisplayName("Find Owner")
                @Test
                void findOwner() {
                    Owner foundOwner = ownerMapService.findById(1L);
                    assertThat(foundOwner).isNotNull();
                }

                @DisplayName("Find Owner Not Found")
                @Test
                void findOwnerNotFound() {
                    Owner foundOwner = ownerMapService.findById(2L);
                    assertThat(foundOwner).isNull();
                }
            }
        }
    }

    @DisplayName("Verify Still Zero Owners")
    @Test
    void ownersAreStillZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }
}