package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class LibraryTests {

    Library library;

    @Before
    public void setUp() throws Exception {
        library = new Library();
        initializeLibrary();
    }

    @Test
    public void testGetAvailableBooksShouldReturn3Books() throws Exception {
        Collection<Book> books = library.getAvailableBooks();
        assertTrue(books.size() == 3);
    }

    @Test
    public void testRemoveBookFromLibraryShouldReturn2Books() throws Exception {
            library.borrowBook("Leviathan Wakes");
            Collection<Book> books = library.getAvailableBooks();
            assertTrue(books.size() == 2);
        }

    @Test
    public void testRemoveTwoBooksFromLibrary() throws Exception {
        library.borrowBook("Leviathan Wakes");
        library.borrowBook("The God of Small Things");
        Collection<Book> books = library.getAvailableBooks();
        assertTrue(books.size() == 1);
    }

    @Test
    public void testRemoveNonExistentBookFromLibrary() throws Exception {
        boolean exceptionWasThrown = false;
        try {
            library.borrowBook("The man who wasn't there");
        } catch (BookDoesNotExistInLibraryException ex) {
            exceptionWasThrown = true;
        }
        assertTrue(exceptionWasThrown);
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
        assertEquals(library.articleCount(), 3);
        library.borrowBook("Leviathan Wakes");
        assertEquals(library.articleCount(), 2);
    }

    @Test
    public void testWhenUserTriesToReturnInvalidBookShouldGetErrorMessage() throws Exception {
        boolean exceptionWasThrown = false;
        try {
            library.returnBook("Random invalid book");
        } catch (InvalidBookToReturnException ex) {
            exceptionWasThrown = true;
        }
        assertTrue(exceptionWasThrown);
    }

    @Test
    public void testWhenUserTriesToReturnABookThatIsAlreadyInTheLibraryShouldGetErrorMessage() throws Exception {
        boolean exceptionWasThrown = false;
        try {
            library.returnBook("The Witches");
        } catch (BookIsAlreadyCheckedInException ex) {
            exceptionWasThrown = true;
        }
        assertTrue(exceptionWasThrown);
    }

    public void initializeLibrary() {
        Book theGodOfSmallThings = new Book("The God of Small Things", "Arundhati Roy", "1997");
        Book theWitches = new Book("The Witches", "Roald Dahl", "1983");
        Book leviathanWakes = new Book("Leviathan Wakes", "James S. A. Corey", "2011");

        this.library.add(theGodOfSmallThings);
        this.library.add(theWitches);
        this.library.add(leviathanWakes);

    }
}
