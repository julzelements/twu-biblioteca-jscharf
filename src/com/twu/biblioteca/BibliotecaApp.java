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
            if (choice.equals("bb")) borrowBook();
            else if (choice.equals("r")) returnItem();
            else if (choice.equals("bd")) displayBooks();
            else if (choice.equals("md")) displayMovies();
            else if (choice.equals("q")) {
                outputStream.println(UIStrings.quit);
                break;
            } else {
                outputStream.println(UIStrings.incorrectChoice);
            }
        }
    }

    public void borrowBook() {
        boolean success = false;
        try {
            success = library.borrowBook(userInput.getString(UIStrings.borrow));
        } catch(BookDoesNotExistInLibraryException BookDoesNotExistInLibraryEx) {
            outputStream.println(UIStrings.bookDoesNotExist);
        }catch (BookIsCurrentlyCheckedOutException bookIsCurrentlyCheckedOutEx) {
            outputStream.println(UIStrings.bookIsCheckedOut);
        } if (success) {
            outputStream.println(UIStrings.successfulBorrow);
        }
    }

    public void returnItem() {
        boolean success = false;
        try {
          success = library.returnBook(userInput.getString(UIStrings.returnBook));
        } catch (BookIsAlreadyCheckedInException bookAlreadyCheckedInEx) {
            outputStream.println(UIStrings.bookAlreadyCheckedIn);
        } catch (InvalidBookToReturnException invalidBookToReturnEx) {
            outputStream.println(UIStrings.invalidBookToReturn);
        } if (success) {
            outputStream.println(UIStrings.successfulReturn);
        }
    }


    public void displayBooks() {
        for (Article article: library.getAvailableBooks()) {
            Book book = (Book)article;
            outputStream.println(book.author + ", " + book.title + ", " + book.year);
        }
    }

    public void displayMovies() {
        for (Article article: library.getAvailableMovies()) {
            Movie movie = (Movie)article;
            outputStream.println(movie.director + ", " + movie.title + ", " + movie.year + ", " + movie.rating + " stars");
        }
    }
}
