package com.twu.biblioteca;

import java.util.HashSet;

public class User {
    private final String libraryNumber;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    public final boolean isAdmin;
    private HashSet<Article> borrowedItems;

    public User(String libraryNumber,String password, String firstName, String lastName, String email, String phoneNumber, boolean isAdmin) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
        this.borrowedItems = new HashSet<Article>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (isAdmin != user.isAdmin) return false;
        if (libraryNumber != null ? !libraryNumber.equals(user.libraryNumber) : user.libraryNumber != null)
            return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        return borrowedItems != null ? borrowedItems.equals(user.borrowedItems) : user.borrowedItems == null;

    }

    @Override
    public int hashCode() {
        int result = libraryNumber != null ? libraryNumber.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (isAdmin ? 1 : 0);
        result = 31 * result + (borrowedItems != null ? borrowedItems.hashCode() : 0);
        return result;
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
