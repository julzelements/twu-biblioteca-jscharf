package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MockUserInput extends UserInput {

    Queue<String> userCommands;

    public MockUserInput() {
    userCommands = new LinkedList<String>();
        userCommands.add("b");
        userCommands.add("The Witches");
        userCommands.add("r");
        userCommands.add("The Witches");
        userCommands.add("q");
    }

    @Override
    public String getString(String prompt) {
        return userCommands.remove();
    }
}

