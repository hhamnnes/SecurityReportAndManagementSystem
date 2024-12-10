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
public class SecurityOccurrenceTest {

    @Mock
    private SecurityOccurrenceCategory mockSecurityOccurrenceCategory;

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
            LocalDateTime timestamp = LocalDateTime.now();

            when(mockSecurityOccurrenceCategory.getType()).thenReturn("Some category name");

            //Act 
            SecurityOccurrence securityOccurrence = new SecurityOccurrence(name,
                                                                        description, 
                                                                        location,
                                                                        mockSecurityOccurrenceCategory,
                                                                        timestamp);

            //Assert
            assertAll(
                () -> assertNotNull(securityOccurrence, "Should exist, therefore not null"),
                () -> assertEquals(description, securityOccurrence.getDescription(), "Should match"),
                () -> assertEquals(location, securityOccurrence.getLocation(), "Should match"),
                () -> assertEquals(timestamp, securityOccurrence.getTimestamp(),
                 "The time should be 2023-12-12T12:12:12"),
                () -> assertEquals(mockSecurityOccurrenceCategory, securityOccurrence.getCategory(), "Should be the expected mocked version"
                + "of SecurityOccurrenceCategory"),
                () -> assertEquals(mockSecurityOccurrenceCategory.getType(), securityOccurrence.getCategory().getType())
            );
        } catch (Exception e) {
            System.out.println(e);
        }
        


    }


    @Test
    @DisplayName("Test with null values for timestamp and category parameters")
    public void testConstructorWithNullParameters() {
        
        //Arrange
        String name = "Some name";
        String description = "Some description";
        String location = "Some location";

        //Act and assert
        assertThrows(IllegalArgumentException.class, () -> {
            new SecurityOccurrence(name, description, location, null, null);
        });




    }


    
}
