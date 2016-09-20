package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class Library {

    ArrayList<Book> libraryList;
    PrintStream outputStream;

    public Library(PrintStream outputStream) {
        this.libraryList = new ArrayList<Book>();
        this.outputStream = outputStream;
    }

    public void add(Book book) {
        libraryList.add(book);
    }

    public String getTitleAuthorList() {
        String titles = new String();
        for (Book temp : libraryList) {
            if (!temp.checkedOut) {
                titles = titles + temp.title + ", " + temp.author + "\n";
            }
        }
        return titles;
    }

    public void borrowItem(String bookTitle){
        if (!validTitleCheck(bookTitle)) {
            outputStream.println("That book is not available.");
        }

        for (int i = 0; i < libraryList.size(); i++) {
            Book currentBook = libraryList.get(i);
            if (currentBook.title.equals(bookTitle)) {
                currentBook.checkedOut = true;
                outputStream.println("Thank you! Enjoy the book");
            }
        }
    }

    public void returnItem(String bookTitle){
        if (!validTitleCheck(bookTitle)) {
            outputStream.println("That is not a valid book to return.");
        }

        for (int i = 0; i < libraryList.size(); i++) {
            Book currentBook = libraryList.get(i);
            if (currentBook.title.equals(bookTitle)) {
                if (!currentBook.checkedOut) {
                    outputStream.println("The book: " + bookTitle + " is already in the library\n" +
                            "please notify librarian");
                } else {
                    currentBook.checkedOut = false;
                    outputStream.println("Thank you for returning the book.");
                }

            }
        }
    }



    public Boolean validTitleCheck(String title) {
        Boolean bookExistsInLibrary = false;

        for (int i = 0; i < libraryList.size(); i++) {
            Book currentBook = libraryList.get(i);
            if (currentBook.title.equals(title)) {
                bookExistsInLibrary = true;
            }
        }
        return bookExistsInLibrary;
    }

    public int bookCount() {
        int bookCount = 0;
        for (int i = 0; i < libraryList.size(); i++) {
            boolean checkedOut = libraryList.get(i).checkedOut;
            if (!checkedOut) {
                bookCount++;
            }
        }

        return bookCount;
    }
}