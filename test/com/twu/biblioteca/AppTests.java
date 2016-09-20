package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppTests {
    BibliotecaApp app;
    PrintStream outputStream;
    ByteArrayOutputStream byteArrayOutputStream;

    @Before
    public void setUp() throws Exception {
        Library mockLibrary = mock(Library.class);
        when(mockLibrary.getTitleAuthorList()).thenReturn("Simple Library");


        byteArrayOutputStream = new ByteArrayOutputStream();
        outputStream = new PrintStream(byteArrayOutputStream);
        app = new BibliotecaApp(outputStream, mockLibrary);
    }

    @Test
    public void testWelcomePage() throws Exception {
        app.welcomeMessage();
        String greeting = byteArrayOutputStream.toString();
        assertEquals(greeting, "Hello! \nWelcome to Biblioteca.\n\n");
    }

    @Test
    public void testDisplayLibrary() {
        app.displayLibrary();
        String library = byteArrayOutputStream.toString();
        String testLibrary = "Simple Library\n";
        assertEquals(testLibrary, library);
    }

    @After
    public void tearDown() throws Exception {
        app = null;

    }
}
