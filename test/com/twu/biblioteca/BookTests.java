package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTests {

    @Test
    public void testBook() throws Exception {
        Book book = new Book("The Witches", "Roald Dahl", "1983");
        assertEquals(book.title, "The Witches");
        assertEquals(book.author, "Roald Dahl");
        assertEquals(book.year, "1983");
    }

    @Test
    public void testBookToString() throws Exception {
        Book book = new Book("The Witches", "Roald Dahl", "1983");
        String bookTitle = "Book{title='The Witches'}";
        String bookToString = book.toString();
        assertEquals(bookTitle, bookToString);
    }

    @Test
    public void testCompareSimilarBooks() throws Exception {
        Book theGodOfSmallThings = new Book("The God of Small Things","Arundhati Roy","1997");
        Book theWitches = new Book("The Witches", "Roald Dahl", "1983");
        Book theGodOfSmallThings2 = new Book("The God of Small Things","Arundhati Roy","1997");
        Book theWitches2 = new Book("The Witches", "Roald Dahl", "1983");
        assertTrue(theGodOfSmallThings.compareTitle(theGodOfSmallThings2));
        assertTrue(theWitches.compareTitle(theWitches2));
    }

    @Test
    public void testCompareDifferentBooks() throws Exception {
        Book theGodOfSmallThings = new Book("The God of Small Things","Arundhati Roy","1997");
        Book theWitches = new Book("The Witches", "Roald Dahl", "1983");
        assertFalse(theGodOfSmallThings.compareTitle(theWitches));
    }

}
