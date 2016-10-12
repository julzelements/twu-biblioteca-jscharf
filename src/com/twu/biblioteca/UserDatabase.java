package com.twu.biblioteca;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import org.sqlite.SQLiteDataSource;
import org.sqlite.SQLiteJDBCLoader;

public class UserDatabase {
    HashMap<String, User> database;

    public UserDatabase() {
        this.database = new HashMap<String, User>();
    }

    public void add(User user)  {
        database.put(user.getLibraryNumber(), user);
        try {
            connected(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUser(String libraryNumber) {
        if (database.containsKey(libraryNumber)) {
            return database.get(libraryNumber);
        }
        else return null;
    }

    public static boolean connected(User user) throws Exception {
        boolean initialize = SQLiteJDBCLoader.initialize();

        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl("jdbc:sqlite:/Users/jscharf/IdeaProjects/TWU_Biblioteca-master/biblioteca.db");

        try {
            dataSource.getConnection().createStatement().executeQuery("INSERT INTO Users(FirstName) VALUES('57127')");
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
        }
        return initialize;
    }
}
