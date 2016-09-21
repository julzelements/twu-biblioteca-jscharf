package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Library {

    HashMap<String, Book> books;

    public Library() {
        this.books = new HashMap<String, Book>();
        initializeLibrary();
    }

    public void add(Book book) {
        books.put(book.title, book);
    }

    public Collection<Book> getAvailableBooks() {
        Collection<Book> availableBooks = getBooks();
        for (Iterator<Book> iterator = availableBooks.iterator(); iterator.hasNext();) {
            Book book = iterator.next();
            if (book.checkedOut) {
                iterator.remove();
            }
        }
        return availableBooks;
    }

    public boolean borrowBook(String title) throws InvalidBookToReturnException, BookIsCurrentlyCheckedOutException {
        if (!bookExists(title)) {
            throw new InvalidBookToReturnException();
        } else if (books.get(title).checkedOut) {
            throw new BookIsCurrentlyCheckedOutException();
        } else {
            getBook(title).checkOut();
            return true;
        }
    }


    public boolean returnBook(String bookTitle) throws InvalidBookToReturnException, BookIsAlreadyCheckedInException{
        if (!bookExists(bookTitle)) {
            throw new InvalidBookToReturnException();
        } else if (!getBook(bookTitle).checkedOut) {
            throw new BookIsAlreadyCheckedInException();
        } else {
            getBook(bookTitle).checkIn();
            return true;
        }
    }

    public Boolean bookExists(String title) {
        return (books.containsKey(title));
    }

    public Book getBook(String title) {
        return books.get(title);
    }

    public Collection<Book> getBooks() {
        return books.values();
    }


    public int bookCount() {
        int bookCount = 0;
        for (Book book : getBooks()) {
            if (!book.checkedOut) {
                bookCount++;
            }
        }
        return bookCount;
    }

    public void initializeLibrary() {
        Book theGodOfSmallThings = new Book("The God of Small Things", "Arundhati Roy", "1997");
        Book theWitches = new Book("The Witches", "Roald Dahl", "1983");
        Book leviathanWakes = new Book("Leviathan Wakes", "James S. A. Corey", "2011");

        add(theGodOfSmallThings);
        add(theWitches);
        add(leviathanWakes);

    }
}