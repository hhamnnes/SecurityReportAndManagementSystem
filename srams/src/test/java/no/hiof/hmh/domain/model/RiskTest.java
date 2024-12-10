package no.hiof.hmh.domain.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class RiskTest {

    @Mock
    private Scenario mockScenario;

    @Mock
    private Probability mockProbability;

    @Mock
    private Consequence mockConsequence;

    @ParameterizedTest
    @CsvSource({
        "3, 4, 12",
        "2, 5, 10",
        "1, 1, 1"
    })
    @DisplayName("Test constructor with parameters")
    public void testConstructorWithParameters(int consequenceValue, int probabilityValue, int expectedNumericRiskValue) {
        // Arrange
        when(mockConsequence.getNumericValue()).thenReturn(consequenceValue);
        when(mockProbability.getNumericValue()).thenReturn(probabilityValue);

        // Act
        Risk risk = new Risk(mockScenario, mockProbability, mockConsequence);

        // Assert
        assertAll(
            () -> assertNotNull(risk, "Risk should not return a null value"),
            () -> assertNotNull(mockProbability, "Probability should not be a null value"),
            () -> assertNotNull(mockConsequence, "Consequence should not be a null value"),
            () -> assertNotNull(mockScenario, "Scenario should not be a null value"),
            () -> assertEquals(expectedNumericRiskValue, risk.getNumericValue(), "The numeric risk value should be: " + expectedNumericRiskValue)
        );
    }

    @Test
    @DisplayName("Test of constructor with null parameters")
    public void testConstructorWithNullParameters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Risk(null, null, null);
        });
    }

    @ParameterizedTest
    @MethodSource("provideInvalidParameters")
    @DisplayName("Test constructor with invalid parameters")
    public void testConstructorWithInvalidParameters(Scenario scenario, Probability probability, Consequence consequence) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Risk(scenario, probability, consequence);
        });
    }

    private static Stream<Arguments> provideInvalidParameters() {
        return Stream.of(
            Arguments.of(null, mock(Probability.class), mock(Consequence.class)),
            Arguments.of(mock(Scenario.class), null, mock(Consequence.class)),
            Arguments.of(mock(Scenario.class), mock(Probability.class), null),
            Arguments.of(null, null, null)
        );
    }
}
