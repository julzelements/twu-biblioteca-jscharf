package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTests {

    Library library;
    PrintStream outputStream;
    ByteArrayOutputStream byteArrayOutputStream;

    @Before
    public void setUp() throws Exception {
        byteArrayOutputStream = new ByteArrayOutputStream();
        outputStream = new PrintStream(byteArrayOutputStream);

        library = new Library(outputStream);
    }

    @Test
    public void testGetTitleAuthorListShouldContainTitlesOf3TestBooks() throws Exception {
        String titles = library.getTitleAuthorList();
        String book1 = "The God of Small Things, Arundhati Roy";
        String book2 = "The Witches, Roald Dahl";
        String book3 = "Leviathan Wakes, James S. A. Corey";
        assertTrue(titles.contains(book1) && titles.contains(book2) && titles.contains(book3));
    }

    @Test
    public void testRemoveBookFromLibrary() throws Exception {
        library.borrowBook("Leviathan Wakes");
        String titles = library.getTitleAuthorList();
        assertFalse(titles.contains("Leviathan Wakes"));
    }

    @Test
    public void testRemoveTwoBooksFromLibrary() throws Exception {
        library.borrowBook("Leviathan Wakes");
        library.borrowBook("The God of Small Things");
        String titles = library.getTitleAuthorList();
        String expectedTitles = "The Witches, Roald Dahl\n";
        assertEquals(titles, expectedTitles);
    }

    @Test
    public void testRemoveNonExistentBookFromLibrary() throws Exception {
        library.borrowBook("The man who wasn't there");
        String expectedError = byteArrayOutputStream.toString();
        assertEquals(expectedError, "That book is not available.\n");
    }

    @Test
    public void checkThatTitleNotValid() throws Exception {
        Boolean bookExistsInLibrary = library.bookExists("The man who wasn't there");
        assertFalse(bookExistsInLibrary);
    }

    @Test
    public void checkThatTitleIsValid() throws Exception {
        Boolean bookExistsInLibrary = library.bookExists("The Witches");
        assertTrue(bookExistsInLibrary);
    }

    @Test
    public void libraryShouldHaveOnlyTwoBooksAfterBorrowingOneFromTheLibrary() throws Exception {
        assertEquals(library.bookCount(), 3);
        library.borrowBook("Leviathan Wakes");
        assertEquals(library.bookCount(), 2);
    }

    @Test
    public void testWhenUserTriesToReturnInvalidBookShouldGetErrorMessage() throws Exception {
        library.returnBook("Random invalid book");
        String expectedError = byteArrayOutputStream.toString();
        assertEquals("That is not a valid book to return.\n", expectedError);
    }

    @Test
    public void testWhenUserTriesToReturnABookThatIsAlreadyInTheLibraryShouldGetErrorMessage() throws Exception {
        library.returnBook("The Witches");
        String expectedError = byteArrayOutputStream.toString();
        assertEquals("The book: The Witches is already in the library\n" +
                "please notify librarian\n", expectedError);
    }
}
