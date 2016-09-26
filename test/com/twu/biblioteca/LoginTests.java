package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginTests {
    UserInput mockUserInput;

    @Before
    public void setUp() throws Exception {
        mockUserInput = mock(UserInput.class);
        when(mockUserInput.getString(anyString())).thenReturn("Tommy").thenReturn("password");

    }

    @Test
    public void testforLoginConstruction() throws Exception {
        Login login = new Login(mockUserInput);
        assertNotNull(login);
    }

    @Test
    public void testThatMokitoMockReturnsTommyThenPassword() throws Exception {
        Login login = new Login(mockUserInput);
        assertTrue(login.userInput.getString("anything").equals("Tommy"));
        assertTrue(login.userInput.getString("anything").equals("password"));

    }
}
