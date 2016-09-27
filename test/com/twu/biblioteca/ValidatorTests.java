package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ValidatorTests {
    UserInput mockUserInput;
    UserInput invalidMockUserInput;

    @Before
    public void setUp() throws Exception {
        mockUserInput = mock(UserInput.class);
        when(mockUserInput.getString(anyString())).thenReturn("Tommy").thenReturn("password");
        invalidMockUserInput = mock(UserInput.class);
        when(invalidMockUserInput.getString(anyString())).thenReturn("BadName").thenReturn("BadPassword");
    }

    @Test
    public void testforLoginConstruction() throws Exception {
        LoginValidator validator = new LoginValidator(mockUserInput);
        assertNotNull(validator);
    }

    @Test
    public void testThatValidUserMockReturnsTommyThenPassword() throws Exception {
        LoginValidator validator = new LoginValidator(mockUserInput);
        assertTrue(validator.userInput.getString("anything").equals("Tommy"));
        assertTrue(validator.userInput.getString("anything").equals("password"));
    }

    @Test
    public void testThatInvalidUserMockReturnsBadNameThenBadPassword() throws Exception {
        LoginValidator validator = new LoginValidator(invalidMockUserInput);
        assertTrue(validator.userInput.getString("anything").equals("BadName"));
        assertTrue(validator.userInput.getString("anything").equals("BadPassword"));
    }

    @Test
    public void testLoginWithValidUsernameReturnsTrue() throws Exception {
        LoginValidator validator = new LoginValidator(mockUserInput);
        assertTrue(validator.userExists("Tommy"));
    }

    @Test
    public void testLoginWithInvalidUsernameReturnsFalse() throws Exception {
        LoginValidator validator = new LoginValidator(mockUserInput);
        assertFalse(validator.userExists("BadName"));
    }

    @Test
    public void testLoginWithValidUserNameAndPassword() throws Exception {
        LoginValidator validator = new LoginValidator(mockUserInput);
        assertTrue(validator.correctPassword("Tommy", "password"));
    }

    @Test
    public void testLoginWithValidUserNameAndInvalidPassword() throws Exception {
        LoginValidator validator = new LoginValidator(mockUserInput);
        assertFalse(validator.correctPassword("Tommy", "wrongPassword"));
    }

    @Test
    public void testLoginWithInvalidUserNameAndInvalidPassword() throws Exception {
        LoginValidator validator = new LoginValidator(mockUserInput);
        assertFalse(validator.correctPassword("BadName", "wrongPassword"));
    }

    @Test
    public void testLoginWithValidUsernameAndPasswordShouldCreateInstanceOfBibliotecaApp() throws Exception {
        LoginValidator validator = new LoginValidator(mockUserInput);
        validator.correctPassword("Tommy", "password");
        assertNotNull(validator.app);
    }
}
