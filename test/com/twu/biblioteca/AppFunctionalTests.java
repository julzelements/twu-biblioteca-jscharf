package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;


public class AppFunctionalTests {

    @Test
    public void shouldGreetUserWhenAppIsStarted() throws Exception {
        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(consoleOutput);
        System.setOut(printStream);

        String bookMenuQuery = Constants.getBookMainMenu();
        UserInput spockStub = mock(UserInput.class);
        Mockito.when(spockStub.getString(bookMenuQuery))
                .thenReturn("q");

        BibliotecaApp app = new BibliotecaApp(spockStub, new Library());
        app.run();

        assertTrue(consoleOutput.toString().contains("Welcome to Biblioteca"));
    }

    @Test
    public void shouldOutputEnjoytheBookWhenABookIsBorrowed() throws Exception {
        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(consoleOutput);
        System.setOut(printStream);

        String bookMenuQuery = Constants.getBookMainMenu();
        UserInput spockStub = mock(UserInput.class);
        Mockito.when(spockStub.getString(bookMenuQuery))
                .thenReturn("b")
                .thenReturn("q");
        Mockito.when(spockStub.getString("Type the title of the book you would like to borrow"))
                .thenReturn("The Witches");

        Library library = new Constants().fullLibrary;

        BibliotecaApp app = new BibliotecaApp(spockStub, library);
        app.run();

        assertTrue(consoleOutput.toString().contains("Thank you! Enjoy the book"));
    }


    @Test
    public void shouldOutputThankyouForReturningthebookWhenBookIsReturned() throws Exception {

        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(consoleOutput);
        System.setOut(printStream);

        String bookMenuQuery = Constants.getBookMainMenu();
        UserInput spockStub = mock(UserInput.class);
        Mockito.when(spockStub.getString(bookMenuQuery))
                .thenReturn("r")
                .thenReturn("q");
        Mockito.when(spockStub.getString("Type the title of book to return"))
                .thenReturn("The Witches");

        Library library = new Constants().libraryWithTheWitchesBorrowed;

        BibliotecaApp app = new BibliotecaApp(spockStub, library);
        app.run();

        assertTrue(consoleOutput.toString().contains("Thank you for returning the book"));
    }

    @Test
    public void mockitoLibraryCountShouldBeOneLessWhenABookIsBorrowed() throws Exception {

        String bookMenuQuery = Constants.getBookMainMenu();
        UserInput spockStub = mock(UserInput.class);
        Mockito.when(spockStub.getString(bookMenuQuery))
                .thenReturn("b")
                .thenReturn("q");
        Mockito.when(spockStub.getString("Type the title of the book you would like to borrow"))
                .thenReturn("The Witches");


        Library library = new Constants().fullLibrary;
        int initialBookCount = library.bookCount();

        BibliotecaApp app = new BibliotecaApp(spockStub, library);
        app.run();

        assertTrue(library.bookCount() == (initialBookCount - 1));
    }

}
