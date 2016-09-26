package com.twu.biblioteca;

import java.util.HashMap;

public class Login {

    UserInput userInput;
    HashMap<String, String> userLogins;

    public Login(UserInput userInput) {
        this.userInput = userInput;
        this.userLogins = new HashMap<String, String>();
        userLogins.put("Tommy", "password");
    }

    public boolean userExists(String loginName) {
        if (userLogins.keySet().contains(loginName)) {
            return true;
        }
    return false;
    }

    public boolean correctPassword(String name, String password) {
        if (!userExists(name)) return false; {
        } return userLogins.get(name).equals(password);
    }
}
