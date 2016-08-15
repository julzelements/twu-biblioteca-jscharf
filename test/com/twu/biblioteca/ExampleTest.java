package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {
    BibliotecaApp app;
    ConsoleOutputCapturer capturer;

    @Before
    public void setUp() throws Exception {
        app = new BibliotecaApp();
        capturer = new ConsoleOutputCapturer();
    }

    @Test
    public void testWelcomePage() throws Exception {
        capturer.start();
        app.run();
        String greeting = capturer.stop();
        assertEquals(greeting, "Hello! \nWelcome to Biblioteca.\n");
    }

    @Test
    public void testDisplayLibrary() {
        BibliotecaApp app = new BibliotecaApp();
        ConsoleOutputCapturer capturer = new ConsoleOutputCapturer();
        capturer.start();
        app.displayLibrary();
        String library = capturer.stop();
        String testLibrary = "Books Library\n" +
                "Title, Author\n" +
                "The Witches, Roald Dahl\n" +
                "The God of Small Things, Arundhati Roy\n" +
                "Leviathan Wakes, James S. A. Corey\n";
        assertEquals(testLibrary, library);
    }


    @After
    public void tearDown() throws Exception {
        app = null;
        capturer = null;

    }
}
