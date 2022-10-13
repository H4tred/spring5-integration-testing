package guru.springframework.spring5webapp.petclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import guru.springframework.spring5webapp.petclinic.exceptions.ValueNotFoundException;
import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", controller.index(), "Wrong view returned!");

    }

    @Test
    @DisplayName("MyTestMethod ☺")
    void oupsHandler() {
        //assertTrue("notimplemented".equals(controller.oupsHandler()), () -> "This is some expensive message to build for my test!");
        assertThrows(ValueNotFoundException.class, () -> {controller.oupsHandler();});
    }

    @Test
    @Disabled("Demo of timeout")
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here");
        });
    }

    @Test
    @Disabled("Demo of timeout - in thread")
    void testTimeoutPreempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here **********");
        });
    }
}