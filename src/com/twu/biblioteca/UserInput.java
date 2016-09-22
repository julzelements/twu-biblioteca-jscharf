package com.twu.biblioteca;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserInput {

    private final InputStream in;
    private final Scanner scanner;

    public UserInput(InputStream in) {
        this.in = in;
        scanner = new Scanner(in);

    }

    public String getString(String prompt) {
        String inputLine;
        System.out.print(prompt + " ");
        try{
            inputLine = scanner.nextLine();
        }catch(NoSuchElementException e){
            inputLine = null;
        }
        return (inputLine == null || inputLine.length() == 0) ? null : inputLine;
    }
}

