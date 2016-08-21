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
    public void testCompareSimilarBooks() throws Exception {
        assertTrue(theGodOfSmallThings.compareTitle(theGodOfSmallThings2.title));
        assertTrue(theWitches.compareTitle(theWitches2.title));
    }

    @Test
    public void testOverrideEquals() throws Exception {
        assertTrue(theGodOfSmallThings.equals(theGodOfSmallThings2));
        assertFalse(theGodOfSmallThings.equals(theWitches));
    }

    @Test
    public void testCompareDifferentBooks() throws Exception {
        assertFalse(theGodOfSmallThings.compareTitle(theWitches.title));
    }

    @Test
    public void testCheckedOut() throws Exception {
        theWitches.checkedOut = true;
        assertTrue(theWitches.checkedOut);
    }

    @After
    public void tearDown() throws Exception {
        theWitches = null;
        theGodOfSmallThings = null;
        theWitches2 = null;
        theGodOfSmallThings2 = null;

    }
}
