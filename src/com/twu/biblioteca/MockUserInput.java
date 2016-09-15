package com.twu.biblioteca;

public class MockUserInput extends UserInput{
    @Override
    public String getString(String prompt) {
        return "q";
    }
}
