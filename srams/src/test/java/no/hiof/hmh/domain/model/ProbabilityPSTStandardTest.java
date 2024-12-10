
package no.hiof.hmh.domain.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;


public class ProbabilityPSTStandardTest {


    @ParameterizedTest
    @CsvSource({
        "1, 2%",
        "2, 15%",
        "3, 45%", 
        "4, 70%",
        "5, 95%"
    })
    @DisplayName("Test constructor with parameters")
    public void testConstructorWithParameters(int numericValue,
                                             String percentage) {

        //Act
        ProbabilityPSTStandard probabilityPSTStandard = new ProbabilityPSTStandard(numericValue, percentage);

        //Assert
        assertAll(
            () -> assertNotNull(probabilityPSTStandard),
            () -> assertEquals(numericValue, probabilityPSTStandard.getNumericValue()),
            () -> assertEquals(percentage, probabilityPSTStandard.getPercentage())
        );

    }








}