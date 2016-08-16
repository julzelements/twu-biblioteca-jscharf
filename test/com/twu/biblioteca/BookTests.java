package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
