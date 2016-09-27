package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

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

    @Test
    public void testBorrowArticleShouldAddArticleToUserStackCountShouldBe1() throws Exception {
        User user = new User(libraryNumber, password, firstName, lastName, email, phoneNumber);
        Set<Article> borrowedArticles;
        borrowedArticles = user.getBorrowedArticles();
        assertTrue(borrowedArticles.size() == 0);
        user.borrowArticle(new Book("The Book", "The Man", "2000"));
        assertTrue(borrowedArticles.size() == 1);
    }

    @Test
    public void testReturnArticleCountShouldBeZero() throws Exception {
        User user = new User(libraryNumber, password, firstName, lastName, email, phoneNumber);
        Set<Article> borrowedArticles;
        borrowedArticles = user.getBorrowedArticles();
        Book theBook = new Book("The Book", "The Man", "2000");
        user.borrowArticle(theBook);
        user.returnArticle(theBook);
        assertTrue(borrowedArticles.size() == 0);
    }
}
