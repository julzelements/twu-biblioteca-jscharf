package com.twu.biblioteca;

public abstract class Article {
    final String title;
    final String year;
    boolean checkedOut;
    public String borrower;

    public Article(String title, String year) {
        this.title = title;
        this.year = year;
        this.checkedOut = false;
        this.borrower = "book is in library";
    }

    public void checkOut(String userLibraryNumber) {
        checkedOut = true;
        borrower = userLibraryNumber;

    }

    public void checkIn() {
        checkedOut = false;
        borrower = "book is in library";
    }

    public String getborrower() {
        return borrower;
    }
}
