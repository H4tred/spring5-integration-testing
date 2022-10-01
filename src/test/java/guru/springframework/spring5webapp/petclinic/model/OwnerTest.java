package guru.springframework.spring5webapp.petclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OwnerTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Budapest");
        owner.setTelephone("123213123123");

        assertAll(
                "Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First Name did not match!"),
                        () -> assertEquals("Buck", owner.getLastName(), "Last Name did not match!")),
                () -> {
                    assertAll(
                            "Owner Properties",
                            () -> assertEquals("Budapest", owner.getCity(), "City did not match!"),
                            () -> assertEquals("123213123123", owner.getTelephone(), "Phone number did not match!")
                    );
                }
        );
    }
}