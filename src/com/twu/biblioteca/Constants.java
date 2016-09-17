package com.twu.biblioteca;

/**
 * Created by jscharf on 14/09/2016.
 */
public class Constants {

    Library fullLibrary;
    Library libraryWithTheWitchesBorrowed;

    public Constants() {
        fullLibrary = new Library();
        addBooks(fullLibrary);

        libraryWithTheWitchesBorrowed = new Library();
        addBooks(libraryWithTheWitchesBorrowed);
        libraryWithTheWitchesBorrowed.borrowItem("The Witches");
    }

    public void addBooks(Library libraryToInitialize) {
        Book theGodOfSmallThings = new Book("The God of Small Things","Arundhati Roy","1997");
        Book theWitches = new Book("The Witches", "Roald Dahl", "1983");
        Book leviathanWakes = new Book("Leviathan Wakes", "James S. A. Corey", "2011");

        libraryToInitialize.add(theGodOfSmallThings);
        libraryToInitialize.add(theWitches);
        libraryToInitialize.add(leviathanWakes);

    }

    public static String getBookMainMenu() {
        return  "What would you like to do?\n" +
                "Borrow a book? type: 'b'\n" +
                "Return a book? type: 'r'\n" +
                "See book details? type: 'd'\n" +
                "Quit? type q\n";
    }
}
