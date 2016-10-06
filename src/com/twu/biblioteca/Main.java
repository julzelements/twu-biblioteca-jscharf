package com.twu.biblioteca;

import java.io.OutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        Library library = getLibrary();
        PrintStream outputStream = getOutputStream();
        UserInput userInput = getUserInput();
        LoginValidator loginValidator = getLoginValidator();

        LibraryHelper libraryHelper = new LibraryHelper(library, userInput, outputStream);
        BibliotecaApp app = new BibliotecaApp(outputStream, library, userInput, loginValidator, libraryHelper);
        app.run();
    }

    public static PrintStream getOutputStream() {
        return System.out;
    }

    public static Library getLibrary(){
        Library library = new Library();
        library.add(new Book("The Book", "Mr Author", "2000"));
        library.add(new Movie("Alien", "Ridley Scott", "1979", "10", "checked in"));
        return library;
    }

    public static UserInput getUserInput() {
        return new UserInput(System.in, System.out);
    }

    public static LoginValidator getLoginValidator() {
        UserDatabase userDatabase = new UserDatabase();
        User user = new User("000-0000", "password" ,"First Name", "Last Name", "email address", "Phone number", false);
        User admin = new User("999-9999", "admin" ,"Admin Name", "Admin Last Name", "email address", "Phone number", true);

        userDatabase.add(user);
        userDatabase.add(admin);

        LoginValidator loginValidator = new LoginValidator(userDatabase);
        return loginValidator;
    }
}
