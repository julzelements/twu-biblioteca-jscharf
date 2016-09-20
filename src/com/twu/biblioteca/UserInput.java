package com.twu.biblioteca;
import java.io.*;

public class UserInput {

    public String getString(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);

            BufferedReader is = new BufferedReader (inputStreamReader);

            inputLine = is.readLine();
            if (inputLine.length() == 0 ) return null;
        } catch(IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
}

