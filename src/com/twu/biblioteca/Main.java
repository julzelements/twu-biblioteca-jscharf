package com.twu.biblioteca;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.add(new Book("The Book", "Mr Author", "2000"));
        library.add(new Movie("Alien", "Ridley Scott", "1979", "10"));
        BibliotecaApp app = new BibliotecaApp(System.out, library, new UserInput(System.in, System.out));
        app.run();
    }
}
