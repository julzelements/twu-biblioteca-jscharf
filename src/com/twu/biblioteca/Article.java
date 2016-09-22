package com.twu.biblioteca;

public abstract class Article {
    final String title;
    final String year;
    boolean checkedOut;

    public Article(String title, String year) {
        this.title = title;
        this.year = year;
        this.checkedOut = false;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void checkIn() {
        checkedOut = false;
    }
}
