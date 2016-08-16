package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by jscharf on 16/08/2016.
 */
public class LibraryTests {

    Library library;
    Book theWitches;
    Book theGodOfSmallThings;

    @Before
    public void setUp() throws Exception {
        library = new Library();
        theWitches = new Book("The Witches", "Roald Dahl", "1983");
        theGodOfSmallThings = new Book("The God of Small Things","Arundhati Roy","1997");

    }

//    @Test
//    public void testAddBooksToLibrary() throws Exception {
//        Library.add(theGodOfSmallThings);
//        Library.add(theWitches);
//    }
}
