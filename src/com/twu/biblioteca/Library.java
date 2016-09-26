package com.twu.biblioteca;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Library {
    HashMap<String, Article> books;
    HashMap<String, Article> movies;
    HashMap<String, Article> articles;

    public Library() {
        this.articles = new HashMap<String, Article>();
        this.movies = new HashMap<String, Article>();
        this.books = new HashMap<String, Article>();
    }

    public void add(Article article) {
        if (article.getClass().equals(Book.class)){
            Book book = (Book)article;
            articles.put(book.title, book);
            books.put(book.title, book);
        } else if (article.getClass().equals(Movie.class)){
            Movie movie = (Movie)article;
            articles.put(movie.title, movie);
            movies.put(movie.title, movie);
        }
    }

    private Collection<Article> getAvailableArticles(HashMap<String, Article> collection) {
        Collection<Article> availableBooks = collection.values();
        for (Iterator<Article> iterator = availableBooks.iterator(); iterator.hasNext();) {
            Article book = iterator.next();
            if (book.checkedOut) {
                iterator.remove();
            }
        }
        return availableBooks;
    }
    public Collection<Article> getAvailableBooks() {
        return getAvailableArticles(books);
    }
    public Collection<Article> getAvailableMovies() {
        return getAvailableArticles(movies);
    }


    public boolean returnBook(String title) throws InvalidBookToReturnException, BookIsAlreadyCheckedInException{
        return returnArticle(title, books);
    }
    public boolean returnMovie(String title) throws InvalidBookToReturnException, BookIsAlreadyCheckedInException{
        return returnArticle(title, movies);
    }



    public boolean returnArticle(String bookTitle, HashMap<String, Article> collection) throws InvalidBookToReturnException, BookIsAlreadyCheckedInException{
        if (!articleExists(bookTitle)) {
            throw new InvalidBookToReturnException();
        } else if (!collection.get(bookTitle).checkedOut) {
            throw new BookIsAlreadyCheckedInException();
        } else {
            collection.get(bookTitle).checkIn();
            return true;
        }
    }


    public boolean articleExists(String article) {
        if (getBooks().containsKey(article)){
            return true;
        } else if (getMovies().containsKey(article)) {
            return true;
        } else return false;

    }

    public boolean borrowBook(String title) throws BookDoesNotExistInLibraryException, BookIsCurrentlyCheckedOutException{
        return borrowArticle(title, books);
    }

    public boolean borrowMovie(String title) throws BookDoesNotExistInLibraryException, BookIsCurrentlyCheckedOutException{
        return borrowArticle(title, movies);
    }

    private boolean borrowArticle(String title, HashMap<String, Article> collection) throws BookDoesNotExistInLibraryException, BookIsCurrentlyCheckedOutException{
        if (!articleExists(title)) {
            throw new BookDoesNotExistInLibraryException();
        } else if (collection.get(title).checkedOut) {
            throw new BookIsCurrentlyCheckedOutException();
        } else {
            collection.get(title).checkOut();
            return true;
        }
    }

    public HashMap<String, Article> getBooks() {
        return getArticlesByType(Book.class);
    }
    public HashMap<String, Article> getMovies() {
        return getArticlesByType(Movie.class);
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
