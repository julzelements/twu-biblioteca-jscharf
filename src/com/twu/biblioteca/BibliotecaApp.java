package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

    UserInput userInput;
    Library library;
    PrintStream outputStream;

    public BibliotecaApp(PrintStream outputStream, Library library) {
        //refactor out the library to be injected
        this.library = library;
        this.outputStream = outputStream;
        userInput = new UserInput();
    }


    public void run() {



        welcomeMessage();
        welcomeOptions(userInput);
    }

    public void welcomeMessage() {
        outputStream.println("Hello! \nWelcome to Biblioteca.\n");
    }

    public void welcomeOptions(UserInput userInput) {

            String choice = userInput.getString(
                    "What would you like to do?\n" +
                            "Borrow a book? type: 'b'\n" +
                            "Return a book? type: 'r'\n" +
                            "See book details? type: 'd'\n" +
                            "Quit? type q\n");
            if (choice.equals("b")) borrowItem();
            if (choice.equals("r")) returnItem();
            if (choice.equals("d")) showLibraryDetails();
            if (choice.equals("q")) quit();
    }


    public void borrowItem() {
        String requestedBook = userInput.getString("type the title of the book you would like to borrow");
        library.borrowItem(requestedBook);
        welcomeOptions(userInput);
    }

    public void returnItem() {

        outputStream.println("User wants to return item");

        library.returnItem(userInput.getString("Type the title of book to return"));
        welcomeOptions(userInput);
    }

    public void showLibraryDetails() {
        displayLibrary();
        welcomeOptions(userInput);
    }

    public void quit() {
        outputStream.println("Thank you, come again!");
        welcomeOptions(userInput);
    }

    public void displayLibrary() {
        outputStream.println(library.getTitleAuthorList());
    }




}
