package com.twu.biblioteca;

/**
 * Created by jscharf on 12/08/2016.
 */
public class Main {
    public static void main(String[] args) {

        BibliotecaApp app = new BibliotecaApp(System.out, new Library(), new UserInput(System.in));
        app.run();
    }
}
