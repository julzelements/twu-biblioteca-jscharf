package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class AppTests {

    private  String libraryNumber;
    private  String password;
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String phoneNumber;

    private  String adminLibraryNumber;
    private  String adminPassword;
    private  String adminFirstName;
    private  String adminLastName;
    private  String adminEmail;
    private  String adminPhoneNumber;

    public User getTestAdmin() {
        adminLibraryNumber = "000-0000";
        adminPassword = "Word";
        adminFirstName = "Important";
        adminLastName = "Person";
        adminEmail = "importantperson@gmail.com";
        adminPhoneNumber = "33-999-837";
        return new User(adminLibraryNumber, adminPassword, adminFirstName, adminLastName, adminEmail, adminPhoneNumber, true);
    }

    private User getTestUser() {
        libraryNumber = "888-9999";
        password = "password";
        firstName = "Bob";
        lastName = "Belcher";
        email = "bob@gmail.com";
        phoneNumber = "333-999-837";
        return new User(libraryNumber, password, firstName, lastName, email, phoneNumber, false);
    }

    private Library getTestLibrary() {
        library = new Library();
        library.add(new Book("The Book", "Mr Author", "2000"));
        library.add(new Movie("Alien", "Ridley Scott", "1979", "10"));
        return library;
    }

    BibliotecaApp app;
    PrintStream outputStream;
    ByteArrayOutputStream byteArrayOutputStream;
    LoginValidator loginValidator;
    UserInput userInput;
    Library library;


    @Before
    public void setUp() throws Exception {

        library = getTestLibrary();

        UserDatabase database = new UserDatabase();
        database.add(getTestUser());
        database.add(getTestAdmin());

        loginValidator = new LoginValidator(database);

        byteArrayOutputStream = new ByteArrayOutputStream();
        outputStream = new PrintStream(byteArrayOutputStream);
        app = new BibliotecaApp(outputStream, library, userInput, loginValidator);
    }

    @Test
    public void testWelcomePage() throws Exception {
        app = new BibliotecaApp(outputStream, library, userInput, loginValidator);
        app.welcomeMessage();
        String greeting = byteArrayOutputStream.toString();
        assertEquals(greeting, UIStrings.welcome + "\n");
    }

    @Test
    public void testBibiliotecaAppShouldDisplayLibrary() {
        app = new BibliotecaApp(outputStream, library, userInput, loginValidator);
        app.displayAvailableBooks();
        String library = byteArrayOutputStream.toString();
        String testLibrary = "Mr Author, The Book, 2000\n";
        assertEquals(testLibrary, library);
    }


    @Test
    public void testAppShouldDisplayMovies() throws Exception {
        app = new BibliotecaApp(outputStream, library, userInput, loginValidator);
        app.displayAvailableMovies();
        String library = byteArrayOutputStream.toString();
        String testLibrary = "Ridley Scott, Alien, 1979, 10 stars\n";
        assertEquals(testLibrary, library);
    }

    @Test
    public void whenUserSubmitsGibberishErrorStringShouldBeReturned() throws Exception {
        UserInput mockUserInput = mock(UserInput.class);
        when(mockUserInput.getString(anyString())).thenReturn("gibbereish").thenReturn("q");

        app = new BibliotecaApp(outputStream, library, mockUserInput, loginValidator);
        app.userWelcomeOptions();
        String errorMessage = byteArrayOutputStream.toString();
        String expectedErrorMessage = "Incorrect choice, please try again\n" +
        "Thank you, come again!\n";
        assertEquals(errorMessage, expectedErrorMessage);
    }

    @Test
    public void validateCredentialsShouldQuitWhenUserTypesQ() throws Exception {
        UserInput mockUserInput = mock(UserInput.class);
        when(mockUserInput.getString(anyString())).thenReturn("q");

        app = new BibliotecaApp(outputStream, library, mockUserInput, loginValidator);
        app.validateCredentials();
        String output = byteArrayOutputStream.toString();
        String expectedOutput = "Thank you, come again!\n";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void validateCredentialsShouldAcceptUserValidUserCredentials() throws Exception {
        UserInput mockUserInput = mock(UserInput.class);
        when(mockUserInput.getString(anyString())).thenReturn(libraryNumber, password, "q");

        app = new BibliotecaApp(outputStream, library, mockUserInput, loginValidator);
        app.validateCredentials();
        String output = byteArrayOutputStream.toString();
        String expectedOutput = UIStrings.credentialsAccepted + "\n" + UIStrings.quit + "\n";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void loginWithValidUserShouldShowUserMenu() throws Exception {
        UserInput mockUserInput = mock(UserInput.class);
        when(mockUserInput.getString(UIStrings.userMenu)).thenReturn("q");

        app = new BibliotecaApp(outputStream, library, mockUserInput, loginValidator);
        app.login(libraryNumber, password);

        verify(mockUserInput, times(1)).getString(UIStrings.userMenu);
    }

    @Test
    public void loginWithValidAdminShouldShowAdminMenu() throws Exception {
        UserInput mockUserInput = mock(UserInput.class);
        when(mockUserInput.getString(UIStrings.adminMenu)).thenReturn("q");

        app = new BibliotecaApp(outputStream, library, mockUserInput, loginValidator);
        app.login(adminLibraryNumber, adminPassword);

        verify(mockUserInput, times(1)).getString(UIStrings.adminMenu);
    }

    @Test
    public void shouldThrowErrorInvalidUserName() throws Exception {
        UserInput mockUserInput = mock(UserInput.class);
        when(mockUserInput.getString(anyString())).thenReturn("Mr Man", password, "q");

        app = new BibliotecaApp(outputStream, library, mockUserInput, loginValidator);
        app.validateCredentials();
        String output = byteArrayOutputStream.toString();
        String expectedOutput = UIStrings.userNameDoesNotExist + "\n" + UIStrings.quit + "\n";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void shouldThrowErrorInvalidPassword() throws Exception {
        UserInput mockUserInput = mock(UserInput.class);
        when(mockUserInput.getString(anyString())).thenReturn(libraryNumber, "badpassword", "q");

        app = new BibliotecaApp(outputStream, library, mockUserInput, loginValidator);
        app.validateCredentials();
        String output = byteArrayOutputStream.toString();
        String expectedOutput = UIStrings.incorrectPassword + "\n" + UIStrings.quit + "\n";
        assertEquals(output, expectedOutput);
    }

    @Test
    public void displayUserDetailsShouldFormatUserDetails() throws Exception {
        UserInput mockUserInput = mock(UserInput.class);
        when(mockUserInput.getString(anyString())).thenReturn(libraryNumber, password, "ud", "q");

        app = new BibliotecaApp(outputStream, library, mockUserInput, loginValidator);
        app.run();

        String expectedDetails =
                "Library number: " + libraryNumber + "\n" +
                "Name: " + firstName + " " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Phone number: " + phoneNumber;

        assertTrue(byteArrayOutputStream.toString().contains(expectedDetails));
    }

    @Test
    public void getBookDetailsShouldReturnBookIsInLibrary() throws Exception {
        UserInput mockUserInput = mock(UserInput.class);
        when(mockUserInput.getString(anyString())).thenReturn(adminLibraryNumber, adminPassword, "bd", "q");

        app = new BibliotecaApp(outputStream, library, mockUserInput, loginValidator);
        app.run();

        assertTrue(byteArrayOutputStream.toString().contains("book is in library"));
    }

    @Test
    public void getBookDetailsShouldReturnLibraryNumber() throws Exception {
        UserInput mockUserInput = mock(UserInput.class);
        when(mockUserInput.getString(anyString())).thenReturn(adminLibraryNumber, adminPassword, "bd", "q");

        library.borrowBook("The Book", libraryNumber);

        app = new BibliotecaApp(outputStream, library, mockUserInput, loginValidator);
        app.run();

        assertTrue(byteArrayOutputStream.toString().contains(libraryNumber));
    }

    @Test
    public void getMovieDetailsShouldReturnLibraryNumber() throws Exception {
        UserInput mockUserInput = mock(UserInput.class);
        when(mockUserInput.getString(anyString())).thenReturn(adminLibraryNumber, adminPassword, "md", "q");

        library.borrowMovie("Alien", libraryNumber);

        app = new BibliotecaApp(outputStream, library, mockUserInput, loginValidator);
        app.run();

        assertTrue(byteArrayOutputStream.toString().contains(libraryNumber));
    }

    @After
    public void tearDown() throws Exception {
        app = null;
        outputStream = null;
        byteArrayOutputStream = null;
    }
}
