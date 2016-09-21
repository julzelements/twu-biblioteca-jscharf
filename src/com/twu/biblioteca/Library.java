package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Library {

    HashMap<String, Book> books;
    PrintStream outputStream;

    public Library(PrintStream outputStream) {
        this.books = new HashMap<String, Book>();
        this.outputStream = outputStream;
        initializeLibrary();
    }

    public void add(Book book) {
        books.put(book.title, book);
    }

    public String getTitleAuthorList() {
        String titles = new String();
        for (Map.Entry<String, Book> temp : books.entrySet()) {
            Book book = temp.getValue();
            if (!book.checkedOut) {
                titles = titles + book.title + ", " + book.author + "\n";
            }
        }
        return titles;
    }

    public void borrowBook(String title){
        if (!bookExists(title)){
            outputStream.println("That book is not available.");
        } else {
            getBook(title).checkOut();
            outputStream.println("Thank you! Enjoy the book");
        }
    }


    public void returnBook(String bookTitle) {
        if (!bookExists(bookTitle)) {
            outputStream.println("That is not a valid book to return.");
        } else if (!getBook(bookTitle).checkedOut) {
            outputStream.println("The book: " + bookTitle + " is already in the library\n" +
                    "please notify librarian");
        } else {
            getBook(bookTitle).checkIn();
            outputStream.println("Thank you for returning the book.");
        }
    }

    public Boolean bookExists(String title) {
        return (books.containsKey(title));
    }

    public Book getBook(String title) {
        return books.get(title);
    }

    public int bookCount() {
        int bookCount = 0;
        for (Map.Entry<String, Book> book : books.entrySet()) {
            if (!book.getValue().checkedOut) {
                bookCount ++;
            }
        }
        return bookCount;
    }

    public void initializeLibrary() {
        Book theGodOfSmallThings = new Book("The God of Small Things","Arundhati Roy","1997");
        Book theWitches = new Book("The Witches", "Roald Dahl", "1983");
        Book leviathanWakes = new Book("Leviathan Wakes", "James S. A. Corey", "2011");

        add(theGodOfSmallThings);
        add(theWitches);
        add(leviathanWakes);

    }
}