package com.twu.biblioteca;

import bibliotecaExceptions.ArticleDoesNotExistInLibraryException;
import bibliotecaExceptions.ArticleIsCurrentlyCheckedOutException;

import java.io.PrintStream;

public class LibraryHelper {

    Library library;
    UserInput userInput;
    PrintStream outputStream;

    public LibraryHelper(Library library, UserInput userInput, PrintStream outputStream) {
        this.library = library;
        this.userInput = userInput;
        this.outputStream = outputStream;
    }

    public void borrowBook(User currentUser) {
        boolean success = false;
        try {
            success = library.borrowBook(userInput.getString(UIStrings.borrow), currentUser.getLibraryNumber());
        } catch (ArticleDoesNotExistInLibraryException BookDoesNotExistInLibraryEx) {
            outputStream.println(UIStrings.articleDoesNotExist);
        } catch (ArticleIsCurrentlyCheckedOutException bookIsCurrentlyCheckedOutEx) {
            outputStream.println(UIStrings.articleIsCheckedOut);
        }
        if (success) {
            outputStream.println(UIStrings.successfulBorrow);
        }
    }

}
