package com.twu.biblioteca;

import Exceptions.IncorrectPasswordException;
import Exceptions.UserNameDoesNotExistException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class ValidatorTests {
    UserDatabase database;

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


        database = new UserDatabase();
        User user = new User(libraryNumber, password, firstName, lastName, email, phoneNumber, false);
        database.add(user);
        
    }

    @Test
    public void testforLoginConstruction() throws Exception {
        LoginValidator validator = new LoginValidator(database);
        assertNotNull(validator);
    }

    @Test
    public void testLoginWithValidUserNameAndPassword() throws Exception {
        LoginValidator validator = new LoginValidator(database);
        assertTrue(validator.validateCredentials(libraryNumber, password));
    }

    @Test
    public void testLoginWithIncorrectUserNameThrowsUserNameDoesNotExist() throws Exception {
        boolean exceptionWasThrown = false;
        LoginValidator validator = new LoginValidator(database);
            try {
                validator.validateCredentials("BadLibraryNumber", "wrongPassword");
            } catch (UserNameDoesNotExistException ex) {
                exceptionWasThrown = true;
        }
        assertTrue(exceptionWasThrown);
    }

    @Test
    public void testLoginWithCorrectUserNameIncorrectPasswordThrowsInvalidPasswordException() throws Exception {
        boolean exceptionWasThrown = false;
        LoginValidator validator = new LoginValidator(database);
            try {
                validator.validateCredentials(libraryNumber, "wrongPassword");
            } catch (IncorrectPasswordException ex) {
                exceptionWasThrown = true;
        }
        assertTrue(exceptionWasThrown);
    }

    @Test
    public void getUserShouldReturnUser() throws Exception {
        User user = new User(libraryNumber, password, firstName, lastName, email, phoneNumber, false);
        LoginValidator validator = new LoginValidator(database);
        User accessedUser = validator.getUser(libraryNumber);
        assertTrue(user.equals(accessedUser));
    }

    @Test
    public void getUserShouldReturnNullIfUserDoesNotExist() throws Exception {
        LoginValidator validator = new LoginValidator(database);
        User accessedUser = validator.getUser("random Wrong Number");
        assertTrue(accessedUser == null);
    }
}
