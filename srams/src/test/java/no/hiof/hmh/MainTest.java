package no.hiof.hmh;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {

    @Test
    public void testMain() {
        // Set up a stream to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Call the main method
        Main.main(new String[]{});

        // Restore the original System.out
        System.setOut(originalOut);

        // Check the output
        String expectedOutput = "Hello world!" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}
