package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
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


}
