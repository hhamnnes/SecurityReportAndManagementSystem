package no.hiof.hmh.domain.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RiskTest {

    @Mock 
    Consequence mockConsequence;

    @Mock 
    Probability mockProbability;

    @Mock 
    Scenario mockScenario;


    @Test
    @DisplayName("Tes of default constructor")
    public void testDefaultConstructor() {

        //Arrange and act
        Risk risk = new Risk();

        //Assert
        assertNotNull(risk, "Should not be a null value");
    }

    @Test
    @DisplayName("Test of constructor with parameters")
    public void testConstructorWithParameters() {
        //Arrange
        String riskID = "1";
        when(mockConsequence.getNumericValue()).thenReturn(3);
        when(mockProbability.getNumericValue()).thenReturn(4);
        
        //Act
        Risk risk = new Risk(mockScenario,
                             mockProbability,
                             mockConsequence);
        
        //Assert
        int expectedNumericRiskValue = 12;
        assertAll(
            () -> assertNotNull(risk, "Risk should not return av null value"),
            () -> assertNotNull(mockProbability, "Probability should not be a null value"),
            () -> assertNotNull(mockConsequence, "Consequence should not be a null value"),
            () -> assertNotNull(mockScenario, "Scenario should not be a null value"),
            () -> assertEquals(expectedNumericRiskValue, risk.getNumericValue, 
            "The numeric risk value should be:" + expectedNumericRiskValue),
            () -> assertEquals("1", risk.getNumericValue),
            () -> assertEquals(anyInt(), risk.getID())
        );
    }

    @Test 
    @DisplayName("Test of constructor with null parameters")
    public void testConstructorWithNullParameters() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Risk(null, null, null);
        });

    }
}
