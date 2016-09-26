package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginTests {
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
        Login login = new Login(mockUserInput);
        assertNotNull(login);
    }

    @Test
    public void testThatValidUserMockReturnsTommyThenPassword() throws Exception {
        Login login = new Login(mockUserInput);
        assertTrue(login.userInput.getString("anything").equals("Tommy"));
        assertTrue(login.userInput.getString("anything").equals("password"));
    }

    @Test
    public void testThatInvalidUserMockReturnsBadNameThenBadPassword() throws Exception {
        Login login = new Login(invalidMockUserInput);
        assertTrue(login.userInput.getString("anything").equals("BadName"));
        assertTrue(login.userInput.getString("anything").equals("BadPassword"));
    }

    @Test
    public void testLoginWithValidUsernameReturnsTrue() throws Exception {
        Login login = new Login(mockUserInput);
        assertTrue(login.userExists("Tommy"));
    }

    @Test
    public void testLoginWithInvalidUsernameReturnsFalse() throws Exception {
        Login login = new Login(mockUserInput);
        assertFalse(login.userExists("BadName"));
    }

    @Test
    public void testLoginWithValidUserNameAndPassword() throws Exception {
        Login login = new Login(mockUserInput);
        assertTrue(login.correctPassword("Tommy", "password"));
    }

    @Test
    public void testLoginWithValidUserNameAndInvalidPassword() throws Exception {
        Login login = new Login(mockUserInput);
        assertFalse(login.correctPassword("Tommy", "wrongPassword"));
    }

    @Test
    public void testLoginWithInvalidUserNameAndInvalidPassword() throws Exception {
        Login login = new Login(mockUserInput);
        assertFalse(login.correctPassword("BadName", "wrongPassword"));
    }


}
