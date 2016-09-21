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
        boolean success = false;
        try {
            library.borrowBook(userInput.getString("type the title of the book you would like to borrow"));
        } catch(InvalidBookToReturnException InvalidBookToReturnEx) {
            outputStream.println("Sorry, that book does not exist in the library");
        }catch (BookIsCurrentlyCheckedOutException bookIsCurrentlyCheckecOurEx) {
            outputStream.print("Sorry, that book is currently checked out");
        } if (success) {
            outputStream.println("Thank you, enjoy the book!");
        }
    }

    public void returnItem() {
        boolean success = false;
        try {
          success = library.returnBook(userInput.getString("Type the title of book to return"));
        } catch (BookIsAlreadyCheckedInException bookAlreadyCheckedInEx) {
            outputStream.println("That book already exists in the library, please notify Librarian.");
        } catch (InvalidBookToReturnException invalidBookToReturnEx) {
            outputStream.println("That is not a valid book to return");
        } if (success) {
            outputStream.println("Thank you for returning the book!");
        }
    }


    public void displayLibrary() {

        for (Book book: library.getAvailableBooks()) {
            outputStream.println(book.author + ", " + book.title + ", " + book.year);
        }
    }
}
