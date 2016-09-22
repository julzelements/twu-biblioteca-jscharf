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
        outputStream.println(UIStrings.welcome);
    }

    public void welcomeOptions() {
        while(true) {
            String choice = userInput.getString(UIStrings.menu);
            if (choice.equals("b")) borrowItem();
            else if (choice.equals("r")) returnItem();
            else if (choice.equals("d")) displayLibrary();
            else if (choice.equals("q")) {
                outputStream.println(UIStrings.quit);
                break;
            } else {
                outputStream.println("Incorrect choice, please try again");
            }
        }
    }

    public void borrowItem() {
        boolean success = false;
        try {
            success = library.borrowBook(userInput.getString(UIStrings.borrow));
        } catch(BookDoesNotExistInLibraryException BookDoesNotExistInLibraryEx) {
            outputStream.println("Sorry, that book does not exist in the library");
        }catch (BookIsCurrentlyCheckedOutException bookIsCurrentlyCheckecOurEx) {
            outputStream.print("Sorry, that book is currently checked out");
        } if (success) {
            outputStream.println(UIStrings.successfulBorrow);
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
