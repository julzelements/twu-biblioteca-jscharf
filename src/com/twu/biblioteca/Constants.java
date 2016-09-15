package com.twu.biblioteca;

/**
 * Created by jscharf on 14/09/2016.
 */
public class Constants {

    Library library;

    public Constants() {
        library = new Library();
        initializeLibrary();
    }

    public void initializeLibrary() {
        Book theGodOfSmallThings = new Book("The God of Small Things","Arundhati Roy","1997");
        Book theWitches = new Book("The Witches", "Roald Dahl", "1983");
        Book leviathanWakes = new Book("Leviathan Wakes", "James S. A. Corey", "2011");

        library.add(theGodOfSmallThings);
        library.add(theWitches);
        library.add(leviathanWakes);

    }
}
