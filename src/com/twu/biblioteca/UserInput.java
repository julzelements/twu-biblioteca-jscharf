package com.twu.biblioteca;
import java.io.*;

public class UserInput {
    public String getString(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader (new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0 ) return null;
        } catch(IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
    public String mainMenu() {
       return getString("This is the main menu\nWould you like to:\nBorrow a book: b\nReturn a book:r\nQuit:q");
    }
}

