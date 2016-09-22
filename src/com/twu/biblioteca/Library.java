package com.twu.biblioteca;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Library {

    HashMap<String, Book> books;

    public Library() {
        this.books = new HashMap<String, Book>();
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

    public boolean borrowBook(String title) throws BookDoesNotExistInLibraryException, BookIsCurrentlyCheckedOutException {
        if (!bookExists(title)) {
            throw new BookDoesNotExistInLibraryException();
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


    public int articleCount() {
        int articleCount = 0;
        for (Article article : getBooks()) {
            if (!article.checkedOut) {
                articleCount++;
            }
        }
        return articleCount;
    }


}