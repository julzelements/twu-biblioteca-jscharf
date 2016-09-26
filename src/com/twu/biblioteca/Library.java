package com.twu.biblioteca;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Library {

    HashMap<String, Book> books;
    HashMap<String, Movie> movies;
    HashMap<String, Article> articles;

    public Library() {
        this.books = new HashMap<String, Book>();
        this.movies = new HashMap<String, Movie>();
        this.articles = new HashMap<String, Article>();

    }

    public void add(Article article) {
        articles.put(article.title, article);
        if (article.getClass().equals(Book.class)){
            Book book = (Book)article;
            books.put(book.title, book);
        } else if (article.getClass().equals(Movie.class)){
            Movie movie = (Movie)article;
            movies.put(movie.title, movie);
        }
    }

    public Collection<Book> getAvailableBooks() {
        Collection<Book> availableBooks = books.values();
        for (Iterator<Book> iterator = availableBooks.iterator(); iterator.hasNext();) {
            Book book = iterator.next();
            if (book.checkedOut) {
                iterator.remove();
            }
        }
        return availableBooks;
    }

    public boolean returnBook(String bookTitle) throws InvalidBookToReturnException, BookIsAlreadyCheckedInException{
        return returnArticle(bookTitle, Book.class);
    }

    public boolean returnArticle(String bookTitle, Class articleType) throws InvalidBookToReturnException, BookIsAlreadyCheckedInException{
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
        if (books.containsKey(article)){
            return true;
        } else if (movies.containsKey(article)) {
            return true;
        } else return false;

    }

    public Collection<Movie> getAvailableMovies() {
        Collection<Movie> availableMovies = movies.values();
        for (Iterator<Movie> iterator = availableMovies.iterator(); iterator.hasNext();) {
            Movie movie = iterator.next();
            if (movie.checkedOut) {
                iterator.remove();
            }
        }
        return availableMovies;
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

    public HashMap<String,Article> getArticlesByType(Class articleType) {
        HashMap<String, Article> articlesByType = new HashMap<String, Article>();
        for (Article article: articles.values()) {
            if (articleType.equals(article.getClass())) {
                articlesByType.put(article.title, article);
            }
        }
        return articlesByType;
    }

}
