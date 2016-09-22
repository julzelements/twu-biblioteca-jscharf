package com.twu.biblioteca;

/**
 * Created by jscharf on 16/08/2016.
 */
public class Book extends Article {

    final String author;

    public Book(String title, String author, String year) {
        super(title, year);
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (checkedOut != book.checkedOut) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return year != null ? year.equals(book.year) : book.year == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (checkedOut ? 1 : 0);
        return result;
    }
}
