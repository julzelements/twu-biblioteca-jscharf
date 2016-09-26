package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class EndToEndUserTest {

    PrintStream outputStream;
    ByteArrayOutputStream byteArrayOutputStream;
    Library library;

    @Before
    public void setUp() throws Exception {
        byteArrayOutputStream = new ByteArrayOutputStream();
        outputStream = new PrintStream(byteArrayOutputStream);
        library = new Library();
        library.add(new Book("The Book", "Mr Author", "2000"));
    }

    @Test
    public void userBorrowsBookSuccessfullyIsToldToEnjoyBook() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("bb\nThe Book\nq".getBytes());
        new BibliotecaApp(outputStream, library, new UserInput(inputStream, outputStream)).run();
        String output = byteArrayOutputStream.toString();
        String  expectedOutput=
                        UIStrings.welcome + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.borrow + "\n" +
                        UIStrings.successfulBorrow + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.quit + "\n";
        assertEquals(expectedOutput, output);
    }

    @Test
    public void userBorrowsBookSuccessfullyAndReturnsBookSuccessfully() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("bb\nThe Book\nr\nThe Book\nq".getBytes());
        new BibliotecaApp(outputStream, library, new UserInput(inputStream, outputStream)).run();
        String output = byteArrayOutputStream.toString();
        String  expectedOutput=
                UIStrings.welcome + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.borrow + "\n" +
                        UIStrings.successfulBorrow + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.returnArticle + "\n" +
                        UIStrings.successfulReturn + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.quit + "\n";
        assertEquals(expectedOutput, output);
    }

    @Test
    public void userBorrowBookThatLibraryDoesNotHaveIsToldBookDoesNotExist() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("bb\nThe Man Who Wasn't There\nq".getBytes());
        new BibliotecaApp(outputStream, library, new UserInput(inputStream, outputStream)).run();
        String output = byteArrayOutputStream.toString();
        String expectedOutput =
                        UIStrings.welcome + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.borrow + "\n" +
                        UIStrings.articleDoesNotExist + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.quit + "\n";
        assertEquals(expectedOutput, output);
    }
    @Test
    public void userBorrowsBookTwiceIsToldThatBookIsAlreadyCheckedOut() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("bb\nThe Book\nbb\nThe Book\nq".getBytes());
        new BibliotecaApp(outputStream, library, new UserInput(inputStream, outputStream)).run();
        String output = byteArrayOutputStream.toString();
        String expectedOutput =
                        UIStrings.welcome + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.borrow + "\n" +
                        UIStrings.successfulBorrow + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.borrow + "\n" +
                        UIStrings.articleIsCheckedOut + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.quit + "\n";
        assertEquals(expectedOutput, output);
    }

    @Test
    public void userTriesToReturnABookThatIsNotInTheLibraryIsToldThatTheBookIsInvalidToReturn() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("r\nThe Man Who Wasn't There\nq".getBytes());
        new BibliotecaApp(outputStream, library, new UserInput(inputStream, outputStream)).run();
        String output = byteArrayOutputStream.toString();
        String expectedOutput =
                        UIStrings.welcome + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.returnArticle + "\n" +
                        UIStrings.invalidArticleToReturn + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.quit + "\n";
        assertEquals(expectedOutput, output);
    }
}
