package guru.springframework.spring5webapp.petclinic.model;

import guru.springframework.spring5webapp.petclinic.services.ModelRepeatedTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class PersonRepeatedTests implements ModelRepeatedTests {

    @Test
    @RepeatedTest(value = 10)
    @DisplayName("repeatedtest")
    void myRepeatedTest() {
        //todo
    }

    /* dependency injection */
    @RepeatedTest(value = 5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    @Test
    @RepeatedTest(value = 5)
    @DisplayName("My Assignment Repeated Test")
    void myAssignmentRepeated() {
        //todo impl
    }

}
