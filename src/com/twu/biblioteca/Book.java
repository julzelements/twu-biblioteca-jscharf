package com.twu.biblioteca;

/**
 * Created by jscharf on 16/08/2016.
 */
public class Book {
    String title;
    String author;
    String year;
    Boolean checkedOut;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.checkedOut = false;
    }

    public Boolean compareTitle(String title) {
        if (title.equals(this.title)) return true;
        return false;
    }



}
