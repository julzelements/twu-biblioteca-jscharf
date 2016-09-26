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
            else if (choice.equals("br")) returnBook();
            else if (choice.equals("mr")) returnMovie();
            else if (choice.equals("mb")) borrowMovie();
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
        } catch(ArticleDoesNotExistInLibraryException BookDoesNotExistInLibraryEx) {
            outputStream.println(UIStrings.articleDoesNotExist);
        }catch (ArticleIsCurrentlyCheckedOutException bookIsCurrentlyCheckedOutEx) {
            outputStream.println(UIStrings.articleIsCheckedOut);
        } if (success) {
            outputStream.println(UIStrings.successfulBorrow);
        }
    }

    public void borrowMovie() {
        boolean success = false;
        try {
            success = library.borrowMovie(userInput.getString(UIStrings.borrow));
        } catch(ArticleDoesNotExistInLibraryException BookDoesNotExistInLibraryEx) {
            outputStream.println(UIStrings.articleDoesNotExist);
        }catch (ArticleIsCurrentlyCheckedOutException bookIsCurrentlyCheckedOutEx) {
            outputStream.println(UIStrings.articleIsCheckedOut);
        } if (success) {
            outputStream.println(UIStrings.successfulBorrow);
        }
    }

    public void returnBook() {
        boolean success = false;
        try {
          success = library.returnBook(userInput.getString(UIStrings.returnArticle));
        } catch (ArticleIsAlreadyCheckedInException bookAlreadyCheckedInEx) {
            outputStream.println(UIStrings.articleIsAlreadyCheckedIn);
        } catch (InvalidArticleToReturnException invalidBookToReturnEx) {
            outputStream.println(UIStrings.invalidArticleToReturn);
        } if (success) {
            outputStream.println(UIStrings.successfulReturn);
        }
    }

    public void returnMovie() {
        boolean success = false;
        try {
          success = library.returnMovie(userInput.getString(UIStrings.returnArticle));
        } catch (ArticleIsAlreadyCheckedInException bookAlreadyCheckedInEx) {
            outputStream.println(UIStrings.articleIsAlreadyCheckedIn);
        } catch (InvalidArticleToReturnException invalidBookToReturnEx) {
            outputStream.println(UIStrings.invalidArticleToReturn);
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
