package com.twu.biblioteca;

import static com.twu.biblioteca.SyntaxSugar.*;

public class BibliotecaApp {

    UserInput userInput;
    Library library;

    public BibliotecaApp(UserInput userInput, Library library) {
        this.userInput = userInput;
        this.library = library;
    }

    public void run() {
        welcomeMessage();
        welcomeOptions(userInput);
    }

    public void welcomeMessage() {
        System.out.println(GREETING);
    }

    public void welcomeOptions(UserInput userInput) {

            String choice = userInput.getString(UI_MAIN_MENU);
            if (choice.equals("b")) borrowItem();
            if (choice.equals("r")) returnItem();
            if (choice.equals("d")) showLibraryDetails();
            if (choice.equals("q")) quit();
    }


    public void borrowItem() {
        String requestedBook = userInput.getString(TYPE_BOOK_TITLE_TO_BORROW);
        library.borrowItem(requestedBook);
        System.out.println("User is trying to borrow: " + requestedBook);
        welcomeOptions(userInput);
    }

    public void returnItem() {
        String bookToReturn = userInput.getString(TYPE_BOOK_TITLE_TO_RETURN);
        System.out.println(bookToReturn);
        library.returnItem(bookToReturn);

        welcomeOptions(userInput);

    }

    public void showLibraryDetails() {
        displayLibrary();
        welcomeOptions(userInput);
    }

    public void quit() {
        System.out.println(QUIT_MESSAGE);
    }

    public void displayLibrary() {
        System.out.println("Available Books:\n" + library.getTitleAuthorList());
        welcomeOptions(userInput);
    }

}
