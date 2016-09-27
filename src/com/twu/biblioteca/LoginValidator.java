package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

public class LoginValidator {

    UserInput userInput;
    HashMap<String, String> userLogins;
    public BibliotecaApp app;

    public LoginValidator(UserInput userInput) {
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

    private void bootBibliotecaApp() {
        this.app = new BibliotecaApp(new PrintStream(new ByteArrayOutputStream()), new Library(), userInput);
    }

    public boolean correctPassword(String name, String password) {
        if (!userExists(name))  {
            return false;
        } else if (userLogins.get(name).equals(password)) {
           bootBibliotecaApp();
            return true;
        }
            return false;
    }
}
