package com.twu.biblioteca;

import static com.twu.biblioteca.SyntaxSugar.*;

public class Constants {

    Library fullLibrary;
    Library libraryWithTheWitchesBorrowed;

    public Constants() {
        fullLibrary = new Library();
        addBooks(fullLibrary);
        addUsers(fullLibrary);

        libraryWithTheWitchesBorrowed = new Library();
        addBooks(libraryWithTheWitchesBorrowed);
        libraryWithTheWitchesBorrowed.borrowItem("The Witches");
    }

    public void addBooks(Library libraryToInitialize) {
        Book theGodOfSmallThings = new Book("The God of Small Things","Arundhati Roy","1997");
        Book theWitches = new Book("The Witches", "Roald Dahl", "1983");
        Book leviathanWakes = new Book("Leviathan Wakes", "James S. A. Corey", "2011");

        libraryToInitialize.addBook(theGodOfSmallThings);
        libraryToInitialize.addBook(theWitches);
        libraryToInitialize.addBook(leviathanWakes);

    }

    public void addUsers(Library libraryToInitialize) {
        libraryToInitialize.addUser(new User(VALID_LIBRARY_NUMBER, VALID_PASSWORD));
        libraryToInitialize.addUser(new User(ANOTHER_VALID_LIBRARY_NUMBER, ANOTHER_VALID_PASSWORD));

    }

}
