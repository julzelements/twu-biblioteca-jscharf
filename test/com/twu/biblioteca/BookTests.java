package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTests {

    Book theWitches;
    Book theGodOfSmallThings;
    Book theWitches2;
    Book theGodOfSmallThings2;

    @Before
    public void setUp() throws Exception {
        theGodOfSmallThings = new Book("The God of Small Things","Arundhati Roy","1997");
        theWitches = new Book("The Witches", "Roald Dahl", "1983");
        theGodOfSmallThings2 = new Book("The God of Small Things","Arundhati Roy","1997");
        theWitches2 = new Book("The Witches", "Roald Dahl", "1983");

    }

    @Test
    public void testBook() throws Exception {
        Book book = new Book("The Witches", "Roald Dahl", "1983");
        assertEquals(book.title, "The Witches");
        assertEquals(book.author, "Roald Dahl");
        assertEquals(book.year, "1983");
    }

    @Test
    public void testShouldReturnTrueWhenEqualsIsUsedOnSimilarBooks() throws Exception {
        assertTrue(theGodOfSmallThings.equals(theGodOfSmallThings2));

    }

    @Test
    public void testShouldReturnFalseWhenEqualsIsUsedOnDifferentBooks() throws Exception {
        assertFalse(theGodOfSmallThings.equals(theWitches));
    }

    @Test
    public void testWhenBookIsInitializedBookCheckedOutShouldBeFalse() throws Exception {
        assertFalse(theWitches.checkedOut);
    }

    @Test
    public void testCheckedOut() throws Exception {
        theWitches.checkedOut = true;
        assertTrue(theWitches.checkedOut);
    }

    @Test
    public void borrowerOfBookShouldBeBookIsInTheLibrary() throws Exception {
        assertEquals(theGodOfSmallThings.getborrower(), "book is in library");
    }
    @Test
    public void borrowerOfBookShouldBeBookIsInTheLibraryAfterBookIsReturned() throws Exception {
        theGodOfSmallThings.checkOut("000-0000");
        theGodOfSmallThings.checkIn();
        assertEquals(theGodOfSmallThings.getborrower(), "book is in library");
    }

    @Test
    public void checkOutBookToUserShouldWriteLibraryIDToBook() throws Exception {
        theGodOfSmallThings.checkOut("000-0000");
        assertEquals(theGodOfSmallThings.getborrower(), "000-0000");
    }

    @After
    public void tearDown() throws Exception {
        theWitches = null;
        theGodOfSmallThings = null;
        theWitches2 = null;
        theGodOfSmallThings2 = null;

    }
}
