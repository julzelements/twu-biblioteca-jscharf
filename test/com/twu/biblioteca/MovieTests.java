package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieTests {

    Movie aliens;
    Movie aliens2;
    Movie highlander;

    @Before
    public void setUp() throws Exception {
        highlander = new Movie("Highlander", "Russell Mulcahy", "1986", "2");
        aliens = new Movie("Aliens", "James Cameron", "1986", "9");
        aliens2 = new Movie("Aliens", "James Cameron", "1986", "9");
    }

    @Test
    public void testShouldReturnTrueWhenEqualsIsUsedOnSimilarBooks() throws Exception {
        assertTrue(aliens.equals(aliens2));

    }

    @Test
    public void testShouldReturnFalseWhenEqualsIsUsedOnDifferentBooks() throws Exception {
        assertFalse(aliens.equals(highlander));
    }

    @Test
    public void testWhenBookIsInitializedBookCheckedOutShouldBeFalse() throws Exception {
        assertFalse(aliens.checkedOut);
    }

    @Test
    public void testCheckedOut() throws Exception {
        aliens.checkedOut = true;
        assertTrue(aliens.checkedOut);
    }

    @After
    public void tearDown() throws Exception {
        aliens = null;
        aliens2 = null;
        highlander = null;

    }
}
