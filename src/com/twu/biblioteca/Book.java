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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (year != null ? !year.equals(book.year) : book.year != null) return false;
        return checkedOut != null ? checkedOut.equals(book.checkedOut) : book.checkedOut == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (checkedOut != null ? checkedOut.hashCode() : 0);
        return result;
    }
}
