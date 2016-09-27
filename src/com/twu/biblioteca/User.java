package com.twu.biblioteca;

import java.util.HashSet;

public class User {
    private final String libraryNumber;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private HashSet<Article> borrowedItems;

    public User( String libraryNumber,String password, String firstName, String lastName, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new HashSet<Article>();
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void borrowArticle(Article article) {
        borrowedItems.add(article);
    }

    public HashSet<Article> getBorrowedArticles() {
        return borrowedItems;
    }

    public void returnArticle(Article article) {
        borrowedItems.remove(article);
    }
}
