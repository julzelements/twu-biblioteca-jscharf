package com.twu.biblioteca;

public class User {
    String number;
    String password;
    String name;
    boolean isCurrentUser;
    String address;
    String phoneNumber;
    String email;

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public boolean isCurrentUser() {
        return isCurrentUser;
    }

    public void setCurrentUser(boolean currentUser) {
        isCurrentUser = currentUser;
    }

    public String getFormattedDetails() {
        return  "Library number: " + number + "\n" +
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Phone number: " + phoneNumber + "\n" +
                "Email: " + email;
    }

    public User(String number, String password, String name, String address, String phoneNumber, String email, boolean isCurrentUser) {
        this.number = number;
        this.password = password;
        this.name = name;
        this.isCurrentUser = false;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isCurrentUser = isCurrentUser;

    }
}
