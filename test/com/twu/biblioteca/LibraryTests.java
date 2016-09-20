package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTests {

    Library library;
    Book theWitches;
    Book theGodOfSmallThings;
    Book leviathanWakes;
    PrintStream outputStream;
    ByteArrayOutputStream byteArrayOutputStream;

    @Before
    public void setUp() throws Exception {
        byteArrayOutputStream = new ByteArrayOutputStream();
        outputStream = new PrintStream(byteArrayOutputStream);

        library = new Library(outputStream);
    }

    @Test
    public void testAddBooksToLibrary() throws Exception {
        String titles = library.getTitleAuthorList();
        String expectedTitles = "The God of Small Things, Arundhati Roy\n" +
                                "The Witches, Roald Dahl\n" +
                                "Leviathan Wakes, James S. A. Corey\n";
        assertEquals(titles, expectedTitles);
    }

    @Test
    public void testRemoveBookFromLibrary() throws Exception {
        library.borrowItem("Leviathan Wakes");
        String titles = library.getTitleAuthorList();
        String expectedTitles = "The God of Small Things, Arundhati Roy\n" +
                "The Witches, Roald Dahl\n";
        assertEquals(titles, expectedTitles);

    }

    @Test
    public void testRemoveTwoBooksFromLibrary() throws Exception {
        library.borrowItem("Leviathan Wakes");
        library.borrowItem("The God of Small Things");
        String titles = library.getTitleAuthorList();
        String expectedTitles = "The Witches, Roald Dahl\n";
        assertEquals(titles, expectedTitles);
    }

    @Test
    public void testRemoveNonExistentBookFromLibrary() throws Exception {
        library.borrowItem("The man who wasn't there");
        String expectedError = byteArrayOutputStream.toString();
        assertEquals(expectedError, "That book is not available.\n");
    }

    @Test
    public void checkThatTitleNotValid() throws Exception {
        Boolean bookExistsInLibrary = library.validTitleCheck("The man who wasn't there");
        assertFalse(bookExistsInLibrary);
    }

    @Test
    public void checkThatTitleIsValid() throws Exception {
        Boolean bookExistsInLibrary = library.validTitleCheck("The Witches");
        assertTrue(bookExistsInLibrary);
    }

    @Test
    public void libraryShouldHaveOnlyTwoBooksAfterBorrowingOneFromTheLibrary() throws Exception {
        assertEquals(library.bookCount(), 3);
        library.borrowItem("Leviathan Wakes");
        assertEquals(library.bookCount(), 2);
    }
}
