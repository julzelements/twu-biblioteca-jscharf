package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class UserTests {
    private  String libraryNumber;
    private  String password;
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String phoneNumber;

    @Before
    public void setUp() throws Exception {
        libraryNumber = "888-9999";
        password = "password";
        firstName = "Bob";
        lastName = "Belcher";
        email = "bob@gmail.com";
        phoneNumber = "333-999-837";
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = new User("Library Number", "Password" ,"First Name", "Last Name", "email address", "Phone number");
        assertNotNull(user);
    }

    @Test
    public void testUserGetters() throws Exception {
        User user = new User(libraryNumber, password, firstName, lastName, email, phoneNumber);
        assertTrue(user.getLibraryNumber().equals(libraryNumber));
        assertTrue(user.getPassword().equals(password));
        assertTrue(user.getFirstName().equals(firstName));
        assertTrue(user.getLastName().equals(lastName));
        assertTrue(user.getEmail().equals(email));
        assertTrue(user.getPhoneNumber().equals(phoneNumber));
    }


}
