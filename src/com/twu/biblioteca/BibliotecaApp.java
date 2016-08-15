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

    public void welcomeOptions(AbstractUserInput userInput) {
        String choice = userInput.getString("What would you like to do?\n" +
                "Borrow a book? type: 'b'\n" +
                "Return a book? type: 'r'\n" +
                "See book details? type: 'd'\n" +
                "Quit? type q", null);
        if (choice.equals("b")) {
            System.out.println("User wants to borrow a book");
        }
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
