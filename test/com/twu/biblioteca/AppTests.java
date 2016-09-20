package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class AppTests {
    BibliotecaApp app;
    PrintStream outputStream;
    ByteArrayOutputStream byteArrayOutputStream;

    @Before
    public void setUp() throws Exception {
        byteArrayOutputStream = new ByteArrayOutputStream();
        outputStream = new PrintStream(byteArrayOutputStream);
        app = new BibliotecaApp(outputStream);
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
        String testLibrary =
                "Available Books:\n" +
                        "The God of Small Things, Arundhati Roy\n" +
                        "The Witches, Roald Dahl\n" +
                        "Leviathan Wakes, James S. A. Corey\n\n";
        assertEquals(testLibrary, library);
    }

    @After
    public void tearDown() throws Exception {
        app = null;

    }
}
