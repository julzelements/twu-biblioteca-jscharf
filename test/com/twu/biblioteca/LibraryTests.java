package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTests {

    Library library;
    Book theWitches;
    Book theGodOfSmallThings;
    Book leviathanWakes;

    @Before
    public void setUp() throws Exception {
        library = new Library();
        theGodOfSmallThings = new Book("The God of Small Things","Arundhati Roy","1997");
        theWitches = new Book("The Witches", "Roald Dahl", "1983");
        leviathanWakes = new Book("Leviathan Wakes", "James S. A. Corey", "2011");
        library.add(theGodOfSmallThings);
        library.add(theWitches);
        library.add(leviathanWakes);
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
        ConsoleOutputCapturer capturer = new ConsoleOutputCapturer();
        capturer.start();
        library.borrowItem("The man who wasn't there");
        String expectedError = capturer.stop();
        assertEquals(expectedError, "book does not exist in our library\n");
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
}
