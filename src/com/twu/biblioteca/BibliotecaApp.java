package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

    UserInput userInput;
    Library library;
    PrintStream outputStream;

    public BibliotecaApp(PrintStream outputStream, Library library, UserInput userInput) {
        this.library = library;
        this.outputStream = outputStream;
        this.userInput = userInput;
    }

    public void run() {
        welcomeMessage();
        welcomeOptions();
    }

    public void welcomeMessage() {
        outputStream.println("Hello! \nWelcome to Biblioteca.\n");
    }

    public void welcomeOptions() {

        while(true) {
            String choice = userInput.getString(
                    "What would you like to do?\n" +
                            "Borrow a book? type: 'b'\n" +
                            "Return a book? type: 'r'\n" +
                            "See book details? type: 'd'\n" +
                            "Quit? type q\n");
            if (choice.equals("b")) borrowItem();
            if (choice.equals("r")) returnItem();
            if (choice.equals("d")) displayLibrary();
            if (choice.equals("q")) {
                outputStream.println("Thank you, come again!");
                break;
            }
        }
    }

    public void borrowItem() {
        String requestedBook = userInput.getString("type the title of the book you would like to borrowBook");
        library.borrowBook(requestedBook);
    }

    public void returnItem() {
        outputStream.println("User wants to return item");
        library.returnBook(userInput.getString("Type the title of book to return"));
    }


    public void displayLibrary() {
        outputStream.println(library.getTitleAuthorList());
    }
}
