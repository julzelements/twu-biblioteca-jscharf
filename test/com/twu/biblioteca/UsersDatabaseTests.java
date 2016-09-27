package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class UsersDatabaseTests {
    UserDatabase database;
    User user;
    String libraryNumber;
    String userName;
    @Before
    public void setUp() throws Exception {
        database = new UserDatabase();
        user = new User(libraryNumber, userName ,"First Name", "Last Name", "email address", "Phone number", false);
        database.add(user);
    }

    @Test
    public void testUsersDatabaseDoesConstruct() throws Exception {
        assertNotNull(database);
    }

    @Test
    public void testGetUser() throws Exception {
        User accessedUser = database.getUser(libraryNumber);
        assertEquals(accessedUser, user);
    }
}
