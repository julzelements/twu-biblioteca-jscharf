package com.twu.biblioteca;

public class BibliotecaApp {

    UserInput userInput;
    Library library;

    public BibliotecaApp(UserInput userInput, Library library) {
        this.userInput = userInput;
        this.library = library;
    }

    public void run() {

        welcomeMessage();
        welcomeOptions(userInput);
    }

    public void welcomeMessage() {
        System.out.println("Hello! \nWelcome to Biblioteca.\n");
    }

    public void welcomeOptions(UserInput userInput) {

            String choice = userInput.getString(
                            "What would you like to do?\n" +
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
        String requestedBook = userInput.getString("type the title of the book you would like to borrow");
        library.borrowItem(requestedBook);
        welcomeOptions(userInput);
    }

    public void returnItem() {

        System.out.println("User wants to return item");

        library.returnItem(userInput.getString("Type the title of book to return"));
        welcomeOptions(userInput);
    }

    public void showLibraryDetails() {
        displayLibrary();
        welcomeOptions(userInput);
    }

    public void quit() {
        System.out.println("Thank you, come again!");
    }

    public void displayLibrary() {
        System.out.println("Available Books:\n" + library.getTitleAuthorList());
        welcomeOptions(userInput);
    }

}
