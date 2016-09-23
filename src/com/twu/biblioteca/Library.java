package com.twu.biblioteca;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Library {

    HashMap<String, Book> books;
    HashMap<String, Movie> movies;

    public Library() {
        this.books = new HashMap<String, Book>();
        this.movies = new HashMap<String, Movie>();
    }

    public void add(Article article) {
        if (article.getClass().equals(Book.class)){
            Book book = (Book)article;
            books.put(book.title, book);
        } else if (article.getClass().equals(Movie.class)){
            Movie movie = (Movie)article;
            movies.put(movie.title, movie);
        }
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
        if (!articleExists(title)) {
            throw new BookDoesNotExistInLibraryException();
        } else if (books.get(title).checkedOut) {
            throw new BookIsCurrentlyCheckedOutException();
        } else {
            getBook(title).checkOut();
            return true;
        }
    }


    public boolean returnBook(String bookTitle) throws InvalidBookToReturnException, BookIsAlreadyCheckedInException{
        if (!articleExists(bookTitle)) {
            throw new InvalidBookToReturnException();
        } else if (!getBook(bookTitle).checkedOut) {
            throw new BookIsAlreadyCheckedInException();
        } else {
            getBook(bookTitle).checkIn();
            return true;
        }
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


    public boolean articleExists(String article) {
        if (books.containsKey(article)){
            return true;
        } else if (movies.containsKey(article)) {
            return true;
        } else return false;

    }
}