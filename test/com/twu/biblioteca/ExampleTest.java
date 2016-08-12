package com.twu.biblioteca;

import org.junit.Test;

import java.util.logging.ConsoleHandler;

import static org.junit.Assert.assertEquals;

public class ExampleTest {



    @Test
    public void testWelcomePage() throws Exception {
        BibliotecaApp app = new BibliotecaApp();
        app.run();
        ConsoleOutputCapturer capturer = new ConsoleOutputCapturer();
        capturer.start();
        app.run();
        String greeting = capturer.stop();


        assertEquals(greeting, "Hello! \nWelcome to Biblioteca.\n\n");
    }

    @Test
    public void test() {

        assertEquals(1, 1);
    }
}
