package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.booleanThat;
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
        library.add(new Movie("Alien", "Ridley Scott", "1979", "10"));

        UserInput mockUserInput = mock(UserInput.class);
        when(mockUserInput.getString(anyString())).thenReturn("gibbereish").thenReturn("q");

        byteArrayOutputStream = new ByteArrayOutputStream();
        outputStream = new PrintStream(byteArrayOutputStream);
        app = new BibliotecaApp(outputStream, library, mockUserInput);
    }

    @Test
    public void testWelcomePage() throws Exception {
        app.welcomeMessage();
        String greeting = byteArrayOutputStream.toString();
        assertEquals(greeting, UIStrings.welcome + "\n");
    }

    @Test
    public void testBibiliotecaAppShouldDisplayLibrary() {
        app.displayLibrary();
        String library = byteArrayOutputStream.toString();
        String testLibrary = "Mr Author, The Book, 2000\n";
        assertEquals(testLibrary, library);
    }

    @Test
    public void testAppShouldDisplayMovies() throws Exception {
        app.displayMovies();
        String library = byteArrayOutputStream.toString();
        String testLibrary = "Ridley Scott, Alien, 1979, 10 stars\n";
        assertEquals(testLibrary, library);
    }

    @Test
    public void whenUserSubmitsGibberishErrorStringShouldBeReturned() throws Exception {
        app.welcomeOptions();
        String errorMessage = byteArrayOutputStream.toString();
        String expectedErrorMessage = "Incorrect choice, please try again\n" +
        "Thank you, come again!\n";
        assertEquals(errorMessage, expectedErrorMessage);
    }

    @After
    public void tearDown() throws Exception {
        app = null;
        outputStream = null;
        byteArrayOutputStream = null;
    }
}
