package guru.springframework.spring5webapp.petclinic.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import guru.springframework.spring5webapp.petclinic.exceptions.ValueNotFoundException;
import java.time.Duration;
import org.hibernate.cfg.Environment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
@Tag("controllers")
class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", controller.index(), "Wrong view returned!");

        //assetJ
        assertThat(controller.index()).isEqualTo("index");
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

    @Test
    void testAssumptionTrue() {
        assumeTrue("MILAN".equalsIgnoreCase(System.getenv("MILAN_RUNTIME")));
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void runOnlyIfJdk11() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void runOnlyOnWindows() {

    }

    @EnabledOnOs(OS.MAC)
    @Test
    void runOnlyOnMac() {

    }

    @EnabledIfSystemProperty(named = "user.name", matches = "milan")
    @Test
    void runOnlyIfUserName() {
        System.out.println(System.getProperty("user.name"));
    }
}