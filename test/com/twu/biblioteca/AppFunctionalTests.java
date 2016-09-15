package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.SyncFailedException;

import static org.junit.Assert.assertTrue;


public class AppFunctionalTests {
    @Test
    public void shouldGreetUserWhenAppIsStarted() throws Exception {
        Library library = new Constants().library;
        MockUserInput user = new MockUserInput();

        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(consoleOutput);

        PrintStream old = System.out;

        System.setOut(printStream);

        BibliotecaApp app = new BibliotecaApp(user, library);
        app.run();

        assertTrue(consoleOutput.toString().contains("Welcome to Biblioteca"));

        printStream.flush();
        System.setOut(old);
        System.out.println(consoleOutput.toString());
    }
}
