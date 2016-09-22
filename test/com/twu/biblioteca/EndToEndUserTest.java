package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EndToEndUserTest {

    BibliotecaApp app;
    PrintStream outputStream;
    ByteArrayOutputStream byteArrayOutputStream;
    private UserInput mockUserInput;


    @Before
    public void setUp() throws Exception {
        Library library = new Library();
        library.add(new Book("The Book", "Mr Author", "2000"));

        //mockUserInput = mock(UserInput.class);

        byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream("b\nThe Book\nq".getBytes());
        outputStream = new PrintStream(byteArrayOutputStream);
        app = new BibliotecaApp(outputStream, library, new UserInput(inputStream));
    }

    @Test
    public void testVerifyOutputStringWhenBorrowingABook() throws Exception {
        //when(mockUserInput.getString(Mockito.anyString())).thenReturn("b", "The Book", "q");
        app.run();
        String output = byteArrayOutputStream.toString();
        String expectedOutput = UIStrings.welcome + "\n" + UIStrings.successfulBorrow + "\n" + UIStrings.quit + "\n";
        assertEquals(expectedOutput, output);
    }
}
