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
    public void testVerifyOutputStringWhenBorrowingABook() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("b\nThe Book\nq".getBytes());
        new BibliotecaApp(outputStream, library, new UserInput(inputStream, outputStream)).run();
        String output = byteArrayOutputStream.toString();
        String expectedOutput = UIStrings.welcome + "\n" + UIStrings.successfulBorrow + "\n" + UIStrings.quit + "\n";
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testVerifyOutputNonExistentBook() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("b\nThe Man Who Wasn't There\nq".getBytes());
        new BibliotecaApp(outputStream, library, new UserInput(inputStream, outputStream)).run();
        String output = byteArrayOutputStream.toString();
        String expectedOutput = UIStrings.welcome + "\n" + UIStrings.bookDoesNotExist + "\n" + UIStrings.quit + "\n";
        assertEquals(expectedOutput, output);
    }
    @Test
    public void testVerifyOutputBookIsCheckedOutError() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("b\nThe Book\nb\nThe Book\nq".getBytes());
        new BibliotecaApp(outputStream, library, new UserInput(inputStream, outputStream)).run();
        String output = byteArrayOutputStream.toString();
        String expectedOutput = UIStrings.welcome + "\n" + UIStrings.successfulBorrow + "\n" + UIStrings.quit + "\n";
        assertEquals(expectedOutput, output);
    }

}
