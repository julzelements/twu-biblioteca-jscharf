package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static com.twu.biblioteca.SyntaxSugar.*;

public class LibraryTests {

    Library library;
    Book theWitches;
    Book theGodOfSmallThings;
    Book leviathanWakes;

    @Before
    public void setUp() throws Exception {
        library = new Constants().fullLibrary;

    }

    @Test
    public void testAddBookToLibrary() throws Exception {
       assertTrue(library.getTitleAuthorList().contains("The Witches"));
    }

    @Test
    public void testRemoveBookFromLibrary() throws Exception {
        library.borrowItem("Leviathan Wakes");
        assertFalse(library.getTitleAuthorList().contains("Leviathan Wakes"));

    }

    @Test
    public void testRemoveTwoBooksFromLibrary() throws Exception {
        library.borrowItem("Leviathan Wakes");
        library.borrowItem("The God of Small Things");
        String titles = library.getTitleAuthorList();
        String expectedTitles = "The Witches, Roald Dahl\n";
        assertEquals(titles, expectedTitles);
    }

//    @Test
//    public void testRemoveNonExistentBookFromLibrary() throws Exception {
//        fullLibrary.borrowItem("The man who wasn't there");
//
//        assertEquals(expectedError, "That book is not available.\n");
//    }

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

    @Test
    public void libraryShouldReturnTrueWhenValidUserIsChecked() throws Exception {
        assertTrue(library.validLibraryNumberCheck(VALID_LIBRARY_NUMBER));

    }

    @Test
    public void libraryShouldReturnFalseWhenInvalidUserIsChecked() throws Exception {
        assertFalse(library.validLibraryNumberCheck(INVALID_LIBRARY_NUMBER));

    }

}
