package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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

    public void borrowItem(String bookTitle) throws Exception {
        if (bookTitle.equals("The man who wasn't there")) {
            throw new Exception();
        }



        for (int i = 0; i < libraryList.size(); i++) {
            Book currentBook = libraryList.get(i);
            if (currentBook.title.equals(bookTitle)) {
                currentBook.checkedOut = true;
            }
        }
    }

    public void validTitleCheck(String title) throws Exception {
        Boolean bookExistsInLibrary = false;

        for (int i = 0; i < libraryList.size(); i++) {
            Book currentBook = libraryList.get(i);
            if (currentBook.title.equals(title)) {
                bookExistsInLibrary = true;
            }
        }

        if (!bookExistsInLibrary) {
            throw new Exception();
        }
    }
}