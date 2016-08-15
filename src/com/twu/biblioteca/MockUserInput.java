package com.twu.biblioteca;

public class MockUserInput {

    protected String getString(String prompt, String mockInput) {
        System.out.println(prompt + "\n" + mockInput);
        return mockInput;
    }
}
