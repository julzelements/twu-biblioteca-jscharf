package com.twu.biblioteca;

/**
 * Created by jscharf on 19/09/2016.
 */
public class SyntaxSugar {

    public static final String GREETING = "Hello! \nWelcome to Biblioteca.\n";
    public static final String ENTER_LIBRARY_NUMBER = "Please enter your Library Number (xxx-xxxx)";
    public static final String ENTER_PASSWORD = "Please enter your password";
    public static final String TYPE_BOOK_TITLE_TO_BORROW = "Type the title of the book you would like to borrow";
    public static final String ERROR_BORROW_FAILED = "Failed to borrow book";
    public static final String BORROW_SUCCESS = "Thank you! Enjoy the book";
    public static final String TYPE_BOOK_TITLE_TO_RETURN = "Type the title of book to return";
    public static final String ERROR_RETURN_FAILED = "Failed to return book";
    public static final String RETURN_SUCCESS = "Thank you! Book successfully returned";
    public static final String ERROR_INVALID_LIBRARY_NUMBER = "Library Number is not valid";

    public static final String VALID_LIBRARY_NUMBER = "123-1234";
    public static final String VALID_PASSWORD = "V3ryS3c3t!";
    public static final String NAME = "John Lennon";
    public static final String ADDRESS = "3 Abbey Road, St John's Wood";
    public static final String PHONE_NUMBER = "1234-1234";
    public static final String EMAIL = "john@whitepiano.com";
    public static final String USER_INFO_FORMATTED =
            "Library number: 123-1234\n" +
            "Name: John Lennon\n" +
            "Address: 3 Abbey Road, St John's Wood\n" +
            "Phone number: 1234-1234\n" +
            "Email: john@whitepiano.com";

    public static final String ANOTHER_VALID_LIBRARY_NUMBER = "223-1234";
    public static final String ANOTHER_VALID_PASSWORD = "V3rerhcyS3c3t!";

    public static final String INVALID_LIBRARY_NUMBER = "asdlgjhnoine";
    public static final String ANOTHER_INVALID_PASSWORD = "NOTSesdfret!";
    public static final String ANOTHER_INVALID_LIBRARY_NUMBER = "123453452346";
    public static final String INVALID_PASSWORD = "NOTSecret!";

    public static final String QUIT_MESSAGE = "Thank you, come again!";

    public static final String UI_MAIN_MENU = "What would you like to do?\n" +
            "Borrow a book? type: 'b'\n" +
            "Return a book? type: 'r'\n" +
            "See book details? type: 'd'\n" +
            "See your user details? type 'u'\n" +
            "Quit? type q\n";
}
