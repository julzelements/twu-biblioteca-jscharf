package com.twu.biblioteca;

/**
 * Created by jscharf on 19/09/2016.
 */
public class User {
    String userNumber;
    String userPassword;

    public String getUserNumber() {
        return userNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public User(String userNumber, String userPassword) {
        this.userNumber = userNumber;
        this.userPassword = userPassword;
    }
}
