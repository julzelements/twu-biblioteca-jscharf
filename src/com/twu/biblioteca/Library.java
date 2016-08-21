package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.PriorityBlockingQueue;

public class Library {

    ArrayList<Book> libraryList;

    public Library() {
        this.libraryList = new ArrayList<Book>();
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
            System.out.println("book does not exist in our library");
        }

        for (int i = 0; i < libraryList.size(); i++) {
            Book currentBook = libraryList.get(i);
            if (currentBook.title.equals(bookTitle)) {
                currentBook.checkedOut = true;
            }
        }
    }

    public Boolean validTitleCheck(String title) {
        Boolean bookExistsInLibrary = false;

        for (int i = 0; i < libraryList.size(); i++) {
            Book currentBook = libraryList.get(i);
            if (currentBook.title.equals(title)) {
                bookExistsInLibrary = true;
                System.out.println("The book: " + title + " has been borrowed");
            }
        }
        return bookExistsInLibrary;
    }
}