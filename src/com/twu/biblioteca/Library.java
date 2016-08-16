package com.twu.biblioteca;

import java.util.ArrayList;

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
            titles = titles + temp.title + ", " + temp.author + "\n";
        }
        return titles;
    }

    public void remove(String bookTitle) {
        for (int i = 0; i < libraryList.size(); i++) {
            Book currentBook = libraryList.get(i);
            if (currentBook.title.equals(bookTitle)) {
                libraryList.remove(i);
            }
        }

    }
}