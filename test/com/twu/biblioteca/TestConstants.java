package com.twu.biblioteca;

public class TestConstants {

    Library library;

    public TestConstants() {
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
