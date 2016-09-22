package com.twu.biblioteca;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.add(new Book("The Book", "Mr Author", "2000"));
        BibliotecaApp app = new BibliotecaApp(System.out, library, new UserInput(System.in));
        app.run();
    }
}
