package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LibraryTests {

    Library library;
    Book theWitches;
    Book theGodOfSmallThings;

    @Before
    public void setUp() throws Exception {
        library = new Library();
        theGodOfSmallThings = new Book("The God of Small Things","Arundhati Roy","1997");
        theWitches = new Book("The Witches", "Roald Dahl", "1983");

    }

    @Test
    public void testAddBooksToLibrary() throws Exception {
        library.add(theGodOfSmallThings);
        library.add(theWitches);
        String titles = library.listTitles();
        String expectedTitles = "The God of Small Things, Arundhati Roy\n" +
                                "The Witches, Roald Dahl\n";
        assertEquals(titles, expectedTitles);
    }


}
