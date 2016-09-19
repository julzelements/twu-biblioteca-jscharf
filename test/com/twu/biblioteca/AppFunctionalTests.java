package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.SyntaxSugar.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class AppFunctionalTests {

    @Test
    public void shouldGreetUserWhenAppIsStarted() throws Exception {
        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(consoleOutput);
        System.setOut(printStream);

        UserInput spockStub = mock(UserInput.class);
        Mockito.when(spockStub.getString(UI_MAIN_MENU))
                .thenReturn("q");

        BibliotecaApp app = new BibliotecaApp(spockStub, new Library());
        app.run();
        assertTrue(consoleOutput.toString().contains(GREETING));
    }

    @Test
    public void shouldAskForLoginDetailsWhenAppIsStarted() throws Exception {
        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(consoleOutput);
        System.setOut(printStream);

        UserInput spockStub = mock(UserInput.class);
        Mockito.when(spockStub.getString(UI_MAIN_MENU))
                .thenReturn("q");

        Mockito.when(spockStub.getString(ENTER_LIBRARY_NUMBER))
                .thenReturn(VALID_LIBRARY_NUMBER);

        Mockito.when(spockStub.getString(ENTER_PASSWORD))
                .thenReturn(VALID_PASSWORD);

        BibliotecaApp app = new BibliotecaApp(spockStub, new Library());
        app.run();
        assertTrue(consoleOutput.toString().contains(GREETING));
        assertTrue(consoleOutput.toString().contains(ENTER_LIBRARY_NUMBER));
        assertTrue(consoleOutput.toString().contains(ENTER_PASSWORD));
    }

    @Test
    public void shouldOutputEnjoytheBookWhenABookIsBorrowed() throws Exception {
        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(consoleOutput);
        System.setOut(printStream);

        UserInput spockStub = mock(UserInput.class);
        Mockito.when(spockStub.getString(UI_MAIN_MENU))
                .thenReturn("b")
                .thenReturn("q");
        Mockito.when(spockStub.getString(TYPE_BOOK_TITLE_TO_BORROW))
                .thenReturn("The Witches");

        Library library = new Constants().fullLibrary;
        BibliotecaApp app = new BibliotecaApp(spockStub, library);
        app.run();
        assertTrue(consoleOutput.toString().contains(BORROW_SUCCESS));
    }


    @Test
    public void shouldOutputThankyouForReturningthebookWhenBookIsReturned() throws Exception {

        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(consoleOutput);
        System.setOut(printStream);

        UserInput spockStub = mock(UserInput.class);
        Mockito.when(spockStub.getString(UI_MAIN_MENU))
                .thenReturn("r")
                .thenReturn("q");
        Mockito.when(spockStub.getString(TYPE_BOOK_TITLE_TO_RETURN))
                .thenReturn("The Witches");

        Library library = new Constants().libraryWithTheWitchesBorrowed;
        BibliotecaApp app = new BibliotecaApp(spockStub, library);
        app.run();
        assertTrue(consoleOutput.toString().contains(RETURN_SUCCESS));
    }

    @Test
    public void mockitoLibraryCountShouldBeOneLessWhenABookIsBorrowed() throws Exception {

        UserInput spockStub = mock(UserInput.class);
        Mockito.when(spockStub.getString(UI_MAIN_MENU))
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

    @Test
    public void shouldDisplayUserDetailsWhenuIsSelected() throws Exception {

        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(consoleOutput);
        System.setOut(printStream);

        UserInput spockStub = mock(UserInput.class);
        Mockito.when(spockStub.getString(UI_MAIN_MENU))
                .thenReturn("u")
                .thenReturn("q");

        Library library = new Constants().fullLibrary;
        BibliotecaApp app = new BibliotecaApp(spockStub, library);
        app.run();
        assertTrue(consoleOutput.toString().contains(USER_INFO_FORMATTED));
    }
}