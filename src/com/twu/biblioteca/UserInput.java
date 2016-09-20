package com.twu.biblioteca;
import java.io.*;
import java.util.Scanner;

public class UserInput {

    private final InputStream in;

    public UserInput(InputStream in) {
        this.in = in;
    }

    public String getString(String prompt) {
        String inputLine;
        System.out.print(prompt + " ");

        Scanner scanner = new Scanner (in);
        inputLine = scanner.nextLine();
        return inputLine.length() == 0 ? null : inputLine;
    }
}

