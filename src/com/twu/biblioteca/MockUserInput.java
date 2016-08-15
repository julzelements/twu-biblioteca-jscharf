package com.twu.biblioteca;

public class MockUserInput extends AbstractUserInput{

    @Override
    protected String getString(String prompt, String mockInput) {
        System.out.println(prompt + "\n" + mockInput);
        return mockInput;
    }
}
