package com.twu.biblioteca;

public class BibliotecaApp {

    UserInput userInput;


    public void run(){
        userInput = new UserInput();
        welcomeMessage();
        welcomeOptions(userInput);

    }

    public void welcomeMessage() {
        System.out.println("Hello! \nWelcome to Biblioteca.\n");
    }

    public void welcomeOptions(UserInput userInput) {
        String choice = userInput.getString("What would you like to do?\n" +
                "Borrow a book? type: 'b'\n" +
                "Return a book? type: 'r'\n" +
                "See book details? type: 'd'\n" +
                "Quit? type q\n");
        if (choice.equals("b")) borrowItem();
        if (choice.equals("r")) returnItem();
        if (choice.equals("d")) showLibraryDetails();
        if (choice.equals("q")) quit();
    }

    public void borrowItem() {
        System.out.println("User wants to borrow");
        //TODO borrow fail or succeed
        //TODO user can quit
    }

    public void returnItem() {
        System.out.println("User wants to return Item");
    }

    public void showLibraryDetails() {
        displayLibrary();
    }

    public void quit() {
        System.out.println("User wants to quit");
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
