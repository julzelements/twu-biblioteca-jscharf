package com.twu.biblioteca;

public class UIStrings {

    public static final String   menu = "What would you like to do?\n" +
                "Borrow an book? type: 'bb'\n" +
                "Borrow an movie? type: 'mb'\n" +
                "Return a book? type: 'mr'\n" +
                "Return a movie? type: 'br'\n" +
                "See available book details? type: 'bd'\n" +
                "See available movie details? type: 'md'\n" +
                "Quit? type 'q'";
    public static final String  borrow = "Type the title of the article you would like to borrow";
    public static final String welcome = "Hello!\nWelcome to Biblioteca.";
    public static final String quit = "Thank you, come again!";
    public static final String successfulBorrow = "Thank you, enjoy the article!";
    public static final String incorrectChoice = "Incorrect choice, please try again";
    public static final String articleDoesNotExist = "Sorry, that article does not exist in the library";
    public static final String articleIsCheckedOut = "Sorry, that article is currently checked out";
    public static final String returnArticle = "Type the title of article to return";
    public static final String articleIsAlreadyCheckedIn = "That article is already checked in, please notify Librarian.";
    public static final String invalidArticleToReturn = "That is not a valid article to return";
    public static final String successfulReturn = "Thank you for returning the article!";

    public static final String enterLibraryNumber = "What would you like to do?\n" +
            "Login? type your Library Number (xxx-xxxx)\n" +
            "Quit? type 'q'";
    public static final String enterPassword = "Please enter your password";
    public static final String credentialsAccepted = "Credentials accepted";
    public static final String userNameDoesNotExist = "Username does not exist in the system";
    public static final String incorrectPassword = "Incorrect password";
}
