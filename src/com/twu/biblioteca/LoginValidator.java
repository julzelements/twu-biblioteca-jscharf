package com.twu.biblioteca;

public class LoginValidator {

    private UserDatabase userDatabase;

    LoginValidator(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public boolean validateCredentials(String libraryNumber, String password) throws UserNameDoesNotExistException, IncorrectPasswordException {
        if (!userExists(libraryNumber)) {
            throw new UserNameDoesNotExistException();
        }
        String databasePassword = userDatabase.getUser(libraryNumber).getPassword();
        if (password != databasePassword) {
            throw new IncorrectPasswordException();
        }
        return true;
    }

    private boolean userExists(String libraryNumber) {
        if (userDatabase.getUser(libraryNumber)!= null) {
            return true;
        }
        return false;
    }



}
