package com.twu.biblioteca;

public class BibliotecaApp {

    UserInput userInput;


    public void run(){
        userInput = new UserInput();
        welcomeMessage();
    }

    public void welcomeMessage() {
        System.out.println("Hello! \nWelcome to Biblioteca.\n");
    }

    public void displayLibrary() {
        System.out.println("Bibliotec Book Library\n" +
                "----------------------------------------\n" +
                "Title, Author\n" +
                "----------------------------------------\n" +
                "The Witches, Roald Dahl\n" +
                "The God of Small Things, Arundhati Roy\n" +
                "Leviathan Wakes, James S. A. Corey");
    }

//Changes
}
