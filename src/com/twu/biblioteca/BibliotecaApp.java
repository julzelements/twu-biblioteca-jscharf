package com.twu.biblioteca;

public class BibliotecaApp {

    UserInput userInput;


    public void run(){
        userInput = new UserInput();
        welcomeMessage();
    }

    public void welcomeMessage() {
        System.out.println("Hello! \nWelcome to Biblioteca.\n");
//        String begin = userInput.getString("press any key to begin");
//
//        if (begin != null) {
//            System.out.println("user has begun");
//
//        } else {
//            welcomeMessage();
//        }
    }


}
