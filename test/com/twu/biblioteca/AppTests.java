package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppTests {
    BibliotecaApp app;
    PrintStream outputStream;
    ByteArrayOutputStream byteArrayOutputStream;

    @Before
    public void setUp() throws Exception {
        Library library = new Library();
        library.add(new Book("The Book", "Mr Author", "2000"));



        UserInput mockUserInput = mock(UserInput.class);

        byteArrayOutputStream = new ByteArrayOutputStream();
        outputStream = new PrintStream(byteArrayOutputStream);
        app = new BibliotecaApp(outputStream, library, mockUserInput);
    }

    @Test
    public void testWelcomePage() throws Exception {
        app.welcomeMessage();
        String greeting = byteArrayOutputStream.toString();
        assertEquals(greeting, "Hello! \nWelcome to Biblioteca.\n\n");
    }

    @Test
    public void testBibiliotecaAppShouldDisplayLibrary() {
        app.displayLibrary();
        String library = byteArrayOutputStream.toString();
        String testLibrary = "Mr Author, The Book, 2000\n";
        assertEquals(testLibrary, library);
    }

    @After
    public void tearDown() throws Exception {
        app = null;

    }
}
