package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class DatabaseTests {

    @Test
    public void getNewInstanceOfDatabase() throws Exception {
        Database database = new Database();
        assertNotNull(database);
    }
}
