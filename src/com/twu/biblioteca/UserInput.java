package com.twu.biblioteca;
import java.io.*;

public class UserInput extends AbstractUserInput {



    public String getString(String prompt, String userInput) {
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
}

