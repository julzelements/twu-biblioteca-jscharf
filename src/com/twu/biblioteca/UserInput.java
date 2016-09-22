package com.twu.biblioteca;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserInput {

    private final InputStream in;
    private final Scanner scanner;
    private final PrintStream out;

    public UserInput(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
        scanner = new Scanner(in);

    }

    public String getString(String prompt) {
        String inputLine;
        out.println(prompt);
        try{
            inputLine = scanner.nextLine();
        }catch(NoSuchElementException e){
            inputLine = null;
        }
        return (inputLine == null || inputLine.length() == 0) ? null : inputLine;
    }
}

