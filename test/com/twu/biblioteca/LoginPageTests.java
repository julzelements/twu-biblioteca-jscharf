package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.SyntaxSugar.*;
import static org.junit.Assert.assertTrue;


public class LoginPageTests {

    public ByteArrayOutputStream setupPrintStreamForTest() {
        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(consoleOutput);
        System.setOut(printStream);
        return consoleOutput;
    }

    @Test
    public void userShouldBeGreetedWhenReachingTheLoginPage() throws Exception {
        ByteArrayOutputStream consoleOutput = setupPrintStreamForTest();
        LoginPage loginPage = new LoginPage(new Constants().fullLibrary);
        assertTrue(consoleOutput.toString().contains(GREETING));
    }

    @Test
    public void userShouldBeAskedForLibraryNumberAfterBeingGreeted() throws Exception {
        ByteArrayOutputStream consoleOutput = setupPrintStreamForTest();
        LoginPage loginPage = new LoginPage(new Constants().fullLibrary);
        assertTrue(consoleOutput.toString().contains(ENTER_LIBRARY_NUMBER));
    }

    @Test
    public void shouldAskUserToReEnterLibraryNumberIfInvalidLibraryNumber() throws Exception {
        ByteArrayOutputStream consoleOutput = setupPrintStreamForTest();
        LoginPage loginPage = new LoginPage(new Constants().fullLibrary);
        loginPage.loginWithLibraryNumber(INVALID_LIBRARY_NUMBER);
        assertTrue(consoleOutput.toString().contains(ERROR_INVALID_LIBRARY_NUMBER));
    }

    @Test
    public void shouldAskUserToReEnterLibraryNumberIfAnotherInvalidLibraryNumber() throws Exception {
        ByteArrayOutputStream consoleOutput = setupPrintStreamForTest();
        LoginPage loginPage = new LoginPage(new Constants().fullLibrary);
        loginPage.loginWithLibraryNumber(ANOTHER_INVALID_LIBRARY_NUMBER);
        assertTrue(consoleOutput.toString().contains(ERROR_INVALID_LIBRARY_NUMBER));
    }

    @Test
    public void shouldAskUserToEnterPasswordWhenValidLibraryNumberIsSupplied() throws Exception {
        ByteArrayOutputStream consoleOutput = setupPrintStreamForTest();
        LoginPage loginPage = new LoginPage(new Constants().fullLibrary);
        loginPage.loginWithLibraryNumber(VALID_LIBRARY_NUMBER);
        assertTrue(consoleOutput.toString().contains(ENTER_PASSWORD));
    }

    @Test
    public void shouldAskUserToEnterPasswordWhenAnotherValidLibraryNumberIsSupplied() throws Exception {
        ByteArrayOutputStream consoleOutput = setupPrintStreamForTest();
        LoginPage loginPage = new LoginPage(new Constants().fullLibrary);
        loginPage.loginWithLibraryNumber(ANOTHER_VALID_LIBRARY_NUMBER);
        assertTrue(consoleOutput.toString().contains(ENTER_PASSWORD));
    }
}
