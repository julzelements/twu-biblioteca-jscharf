package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;


public class AppFunctionalTests {
    @Test
    public void shouldGreetUserWhenAppIsStarted() throws Exception {
        Library library = new Constants().library;
        MockUserInput user = new MockUserInput();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        BibliotecaApp app = new BibliotecaApp(user, library);
        app.run();

        assertTrue(byteArrayOutputStream.toString().contains("Welcome"));





    }
}
