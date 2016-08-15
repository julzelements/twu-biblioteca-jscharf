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


}
