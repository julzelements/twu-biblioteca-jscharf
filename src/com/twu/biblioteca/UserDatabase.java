package com.twu.biblioteca;

import java.util.HashMap;

public class UserDatabase {
    HashMap<String, User> database;

    public UserDatabase() {
        this.database = new HashMap<String, User>();
    }

    public void add(User user) {
        database.put(user.getLibraryNumber(), user);
    }

    public User getUser(String libraryNumber) {
        if (database.containsKey(libraryNumber)) {
            return database.get(libraryNumber);
        }
        else return null;
    }
}
