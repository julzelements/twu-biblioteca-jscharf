package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.Queue;

public class MockUserInput extends UserInput {

    Queue<String> userCommands;

    public MockUserInput() {
    userCommands = new LinkedList<String>();
    }

    public void addUserInput(String userInput) {
        if (userCommands.contains("q")) {
            userCommands.remove("q");
            userCommands.add(userInput);
        } else {
            userCommands.add(userInput);
        }
        userCommands.add("q");
    }

    @Override
    public String getString(String prompt) {
        return userCommands.remove();
    }
}

