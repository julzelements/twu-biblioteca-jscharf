package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.SyntaxSugar.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;


public class LoginPageTests {

    public ByteArrayOutputStream setupPrintStreamForTest() {
        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(consoleOutput);
        System.setOut(printStream);
        return consoleOutput;
    }




}
