package no.hiof.hmh.domain.model;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SecurityOccurrenceTest {

    @Mock
    private SecurityOccurrenceCategory mockSecurityOccurrenceCategory;

    @Mock
    private LocalDateTime mockLocalDateTime;

    @Test
    @DisplayName("Test the default constructor")
    public void testConstructor() {
        SecurityOccurrence securityOccurrence = new SecurityOccurrence();

        assertNotNull(securityOccurrence);
    }

    @Test 
    @DisplayName("Test the constructor with parameters")
    public void testConstructorWithParameters() {
        
        try {

            //Arrange
            String name = "Some name";
            String description = "Some description";
            String location = "Some location";

            when(mockSecurityOccurrenceCategory.getName()).thenReturn("Some category name");
            when(mockLocalDateTime.toString()).thenReturn("2023-12-12T12:12:12");

            //Act 
            SecurityOccurrence securityOccurrence = new SecurityOccurrence(name,
                                                                        description, 
                                                                        location,
                                                                        mockSecurityOccurrenceCategory,
                                                                        mockLocalDateTime);

            //Assert
            String expectedTime = "2023-12-12T12:12:12";
            assertAll(
                () -> assertNotNull(securityOccurrence, "Should exist, therefore not null"),
                () -> assertEquals(description, securityOccurrence.getDescription(), "Should match"),
                () -> assertEquals(location, securityOccurrence.getLocation(), "Should match"),
                () -> assertEquals(expectedTime, securityOccurrence.getTimestamp(),
                 "The time should be 2023-12-12T12:12:12"),
                () -> assertEquals(mockSecurityOccurrenceCategory, securityOccurrence.getCategory(), "Should be the expected mocked version"
                + "of SecurityOccurrenceCategory")
            );
        } catch (Exception e) {
            System.out.println(e);
        }
        


    }


    
}
