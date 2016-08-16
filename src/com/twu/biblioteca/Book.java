package com.twu.biblioteca;

/**
 * Created by jscharf on 16/08/2016.
 */
public class Book {
    String title;
    String author;
    String year;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }

    public Boolean compareTitle(Book book) {
        if (book.title.equals(this.title)) return true;
        return false;
    }

}
