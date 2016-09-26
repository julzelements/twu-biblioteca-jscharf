package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class LibraryTests {

    Library library;

    @Before
    public void setUp() throws Exception {
        library = new Library();
        initializeLibrary();
    }

    @Test
    public void testGetAvailableBooksShouldReturn3Books() throws Exception {
        assertTrue(library.getAvailableBooks().size() == 3);
    }

    @Test
    public void testGetAvailableMoviesShouldReturn3Movies() throws Exception {
        assertTrue(library.getAvailableMovies().size() == 2);
    }

    @Test
    public void testRemoveBookFromLibraryShouldReturn2Books() throws Exception {
            library.borrowBook("Leviathan Wakes");
            assertTrue(library.getAvailableBooks().size() == 2);
    }


    @Test
    public void testRemoveTwoBooksFromLibrary() throws Exception {
        library.borrowBook("Leviathan Wakes");
        library.borrowBook("The God of Small Things");
        Collection<Article> books = library.getAvailableBooks();
        assertTrue(books.size() == 1);
    }

    @Test
    public void testRemoveNonExistentBookFromLibrary() throws Exception {
        boolean exceptionWasThrown = false;
        try {
            library.borrowBook("The man who wasn't there");
        } catch (BookDoesNotExistInLibraryException ex) {
            exceptionWasThrown = true;
        }
        assertTrue(exceptionWasThrown);
    }

//    @Test
//    public void borrowBookWithMovieTitleShouldOnlyBorrowBook() throws Exception {
//        library.borrowBook("The Witches");
//        assertTrue(library.getAvailableBooks().size()==2);
//        assertTrue(library.getAvailableMovies().size()==3);
//    }

    @Test
    public void checkThatTitleNotValid() throws Exception {
        Boolean bookExistsInLibrary = library.articleExists("The man who wasn't there");
        assertFalse(bookExistsInLibrary);
    }

    @Test
    public void checkThatTitleIsValid() throws Exception {
        Boolean bookExistsInLibrary = library.articleExists("The Witches");
        assertTrue(bookExistsInLibrary);
    }

    @Test
    public void libraryShouldHaveOnlyTwoBooksAfterBorrowingOneFromTheLibrary() throws Exception {
        assertEquals(library.articleCount(), 3);
        library.borrowBook("Leviathan Wakes");
        assertEquals(library.articleCount(), 2);
    }

    @Test
    public void testWhenUserTriesToReturnInvalidBookShouldGetErrorMessage() throws Exception {
        boolean exceptionWasThrown = false;
        try {
            library.returnBook("Random invalid book");
        } catch (InvalidBookToReturnException ex) {
            exceptionWasThrown = true;
        }
        assertTrue(exceptionWasThrown);
    }

    @Test
    public void testWhenUserTriesToReturnABookThatIsAlreadyInTheLibraryShouldGetErrorMessage() throws Exception {
        boolean exceptionWasThrown = false;
        try {
            library.returnBook("The Witches");
        } catch (BookIsAlreadyCheckedInException ex) {
            exceptionWasThrown = true;
        }
        assertTrue(exceptionWasThrown);
    }

    @Test
    public void testAddShouldAddABookExpectBookToBeAdded() throws Exception {
        library.add(new Book("The Book", "Mr Man", "1996"));
        assertTrue(library.articleExists("The Book"));
    }

        @Test
    public void testAddShouldAddAMovieExpectMovieToBeAdded() throws Exception {
            library.add(new Movie("Alien", "Ridley Scott", "1979", "10"));
            assertTrue(library.articleExists("Alien"));
    }

    @Test
    public void testArticleExistsShouldBeFalseWhenNonExistetItemIsQueried() throws Exception {
        assertFalse(library.articleExists("The Vanishing"));
    }

    @Test
    public void tempTestGetArticlesByType() throws Exception {
        assertTrue(library.getArticlesByType(Book.class).size() == 3 );
    }

    @Test
    public void tempTest2GetMoviesByType() throws Exception {
        assertTrue(library.getArticlesByType(Movie.class).size() == 2 );
    }

    public void initializeLibrary() {
        Book theGodOfSmallThings = new Book("The God of Small Things", "Arundhati Roy", "1997");
        Book theWitches = new Book("The Witches", "Roald Dahl", "1983");
        Book leviathanWakes = new Book("Leviathan Wakes", "James S. A. Corey", "2011");

        this.library.add(theGodOfSmallThings);
        this.library.add(theWitches);
        this.library.add(leviathanWakes);

        Movie highlander = new Movie("Highlander", "Russell Mulcahy", "1986", "2");
        Movie aliens = new Movie("Aliens", "James Cameron", "1986", "9");
//        Movie theWitchesMovie = new Movie("The Witches", "Nicholas Roeg", "1990", "7");

        this.library.add(highlander);
        this.library.add(aliens);
//        this.library.add(theWitchesMovie);

    }
}
