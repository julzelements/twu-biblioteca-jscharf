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
        ByteArrayInputStream inputStream = new ByteArrayInputStream("b\nThe Book\nq".getBytes());
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
        ByteArrayInputStream inputStream = new ByteArrayInputStream("b\nThe Book\nr\nThe Book\nq".getBytes());
        new BibliotecaApp(outputStream, library, new UserInput(inputStream, outputStream)).run();
        String output = byteArrayOutputStream.toString();
        String  expectedOutput=
                UIStrings.welcome + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.borrow + "\n" +
                        UIStrings.successfulBorrow + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.returnBook + "\n" +
                        UIStrings.successfulReturn + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.quit + "\n";
        assertEquals(expectedOutput, output);
    }

    @Test
    public void userBorrowBookThatLibraryDoesNotHaveIsToldBookDoesNotExist() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("b\nThe Man Who Wasn't There\nq".getBytes());
        new BibliotecaApp(outputStream, library, new UserInput(inputStream, outputStream)).run();
        String output = byteArrayOutputStream.toString();
        String expectedOutput =
                        UIStrings.welcome + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.borrow + "\n" +
                        UIStrings.bookDoesNotExist + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.quit + "\n";
        assertEquals(expectedOutput, output);
    }
    @Test
    public void userBorrowsBookTwiceIsToldThatBookIsAlreadyCheckedOut() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("b\nThe Book\nb\nThe Book\nq".getBytes());
        new BibliotecaApp(outputStream, library, new UserInput(inputStream, outputStream)).run();
        String output = byteArrayOutputStream.toString();
        String expectedOutput =
                        UIStrings.welcome + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.borrow + "\n" +
                        UIStrings.successfulBorrow + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.borrow + "\n" +
                        UIStrings.bookIsCheckedOut + "\n" +
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
                        UIStrings.returnBook + "\n" +
                        UIStrings.invalidBookToReturn + "\n" +
                        UIStrings.menu + "\n" +
                        UIStrings.quit + "\n";
        assertEquals(expectedOutput, output);
    }
}
