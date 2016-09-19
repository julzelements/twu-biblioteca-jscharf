package com.twu.biblioteca;

import java.util.ArrayList;
import static com.twu.biblioteca.SyntaxSugar.*;


public class Library {

    ArrayList<Book> libraryCatalog;
    ArrayList<User> users;

    public Library() {
        this.libraryCatalog = new ArrayList<Book>();
        this.users = new ArrayList<User>();
    }

    public void addBook(Book book) {
        libraryCatalog.add(book);
    }

    public String getTitleAuthorList() {
        String titles = new String();
        for (Book temp : libraryCatalog) {
            if (!temp.checkedOut) {
                titles = titles + temp.title + ", " + temp.author + "\n";
            }
        }
        return titles;
    }

    public void borrowItem(String bookTitle){
        if (!validTitleCheck(bookTitle)) {
            System.out.println("That book is not available.");
        }

        for (int i = 0; i < libraryCatalog.size(); i++) {
            Book currentBook = libraryCatalog.get(i);
            if (currentBook.title.equals(bookTitle)) {
                currentBook.checkedOut = true;
                System.out.println(BORROW_SUCCESS);
            }
        }
    }

    public void returnItem(String bookTitle){
        if (!validTitleCheck(bookTitle)) {
            System.out.println("That is not a valid book to return.");
        }

        for (int i = 0; i < libraryCatalog.size(); i++) {
            Book currentBook = libraryCatalog.get(i);
            if (currentBook.title.equals(bookTitle)) {
                if (!currentBook.checkedOut) {
                    System.out.println("The book: " + bookTitle + " is already in the fullLibrary\n" +
                            "please notify librarian");
                } else {
                    currentBook.checkedOut = false;
                    System.out.println(RETURN_SUCCESS);
                }

            }
        }
    }



    public Boolean validTitleCheck(String title) {
        Boolean bookExistsInLibrary = false;

        for (int i = 0; i < libraryCatalog.size(); i++) {
            Book currentBook = libraryCatalog.get(i);
            if (currentBook.title.equals(title)) {
                bookExistsInLibrary = true;
            }
        }
        return bookExistsInLibrary;
    }

    public int bookCount() {
        int bookCount = 0;
        for (int i = 0; i < libraryCatalog.size(); i++) {
            boolean checkedOut = libraryCatalog.get(i).checkedOut;
            if (!checkedOut) {
                bookCount++;
            }
        }

        return bookCount;
    }

    public boolean validLibraryNumberCheck(String userNumber) {
        boolean validUser = false;
        for (int i = 0; i < users.size(); i++) {
            String tempUserNumber = users.get(i).userNumber;
            if (userNumber.equals(tempUserNumber)) {
                validUser = true;
            }
        }
        return validUser;
    }

    public void addUser(User user) {
            users.add(user);
    }
}