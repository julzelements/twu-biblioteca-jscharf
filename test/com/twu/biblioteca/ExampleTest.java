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
        app.welcomeMessage();
        String greeting = capturer.stop();
        assertEquals(greeting, "Hello! \nWelcome to Biblioteca.\n\n");
    }

    @Test
    public void testDisplayLibrary() {
        capturer.start();
        app.displayLibrary();
        String library = capturer.stop();
        String testLibrary = "Bibliotec Book Library\n" +
                "----------------------------------------\n" +
                "Title, Author\n" +
                "----------------------------------------\n" +
                "The Witches, Roald Dahl\n" +
                "The God of Small Things, Arundhati Roy\n" +
                "Leviathan Wakes, James S. A. Corey\n";
        assertEquals(testLibrary, library);
    }

    @Test
    public void testMockUserInput() throws Exception {
        capturer.start();
        MockUserInput mockUser = new MockUserInput();
        mockUser.getString("What is your name", "Julian");
        String consoleOutput = capturer.stop();
        assertEquals(consoleOutput, "What is your name\n" +
                "Julian\n");
    }

    @Test
    public void testLibraryChoice() throws Exception {
        MockUserInput mockInput = new MockUserInput();

    }

    @After
    public void tearDown() throws Exception {
        app = null;
        capturer = null;

    }
}
