package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Library {
    HashMap<String, Article> articles;
    HashMap<String, Book> books;
    HashMap<String, Movie> movies;
    ArrayList<HashMap> catalog;

    public Library() {
        this.books = new HashMap<String, Book>();
        this.movies = new HashMap<String, Movie>();
        this.catalog = new ArrayList<HashMap>();
        this.articles = new HashMap<String, Article>();
        catalog.add(books);
        catalog.add(movies);
    }

    public void add(Article article) {
        articles.put(article.title, article);

        //All this should be removed
        if (article.getClass().equals(Book.class)) {
            Book book = (Book) article;
            books.put(book.title, book);
        } else if (article.getClass().equals(Movie.class)) {
            Movie movie = (Movie) article;
            movies.put(movie.title, movie);
        }
    }

    public Collection<Book> getAvailableBooks() {
        Collection<Book> availableBooks = books.values();
        for (Iterator<Book> iterator = availableBooks.iterator(); iterator.hasNext(); ) {
            Book book = iterator.next();
            if (book.checkedOut) {
                iterator.remove();
            }
        }
        return availableBooks;
    }

    public boolean returnBook(String bookTitle) throws InvalidBookToReturnException, BookIsAlreadyCheckedInException {
        if (!articleExists(bookTitle)) {
            throw new InvalidBookToReturnException();
        } else if (!books.get(bookTitle).checkedOut) {
            throw new BookIsAlreadyCheckedInException();
        } else {
            books.get(bookTitle).checkIn();
            return true;
        }
    }

    public int articleCount() {
        int articleCount = 0;
        for (Article article : books.values()) {
            if (!article.checkedOut) {
                articleCount++;
            }
        }
        return articleCount;
    }

    public boolean articleExists(String article) {
        if (books.containsKey(article)) {
            return true;
        } else if (movies.containsKey(article)) {
            return true;
        } else return false;

    }

    public Collection<Movie> getAvailableMovies() {
        Collection<Movie> availableMovies = movies.values();
        for (Iterator<Movie> iterator = availableMovies.iterator(); iterator.hasNext(); ) {
            Movie movie = iterator.next();
            if (movie.checkedOut) {
                iterator.remove();
            }
        }
        return availableMovies;
    }

    public boolean borrowArticle(String title) throws BookDoesNotExistInLibraryException, BookIsCurrentlyCheckedOutException {
        Article article = getArticleFromCollections(title);
        if (article == null) {
            throw new BookDoesNotExistInLibraryException();
        } else if (article.checkedOut) {
            throw new BookIsCurrentlyCheckedOutException();
        } else {
            article.checkOut();
            return true;
        }
    }

    public boolean borrowBook(String title) throws BookDoesNotExistInLibraryException, BookIsCurrentlyCheckedOutException {
        if (!articleExists(title)) {
            throw new BookDoesNotExistInLibraryException();
        } else if (books.get(title).checkedOut) {
            throw new BookIsCurrentlyCheckedOutException();
        } else {
            books.get(title).checkOut();
            return true;
        }
    }

    private Article getArticleFromCollections(String title) throws BookDoesNotExistInLibraryException {
        for (HashMap<String, Article> collection : catalog) {
            if (collection.containsKey(title)) {
                return collection.get(title);
            }
        }
        throw new BookDoesNotExistInLibraryException();
    }
}
