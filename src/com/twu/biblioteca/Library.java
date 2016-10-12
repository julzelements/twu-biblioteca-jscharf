package com.twu.biblioteca;

import Exceptions.ArticleDoesNotExistInLibraryException;
import Exceptions.ArticleIsAlreadyCheckedInException;
import Exceptions.ArticleIsCurrentlyCheckedOutException;
import Exceptions.InvalidArticleToReturnException;

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

    private Collection<Article> getCheckedInArticles(HashMap<String, Article> collection) {
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
        return getCheckedInArticles(books);
    }
    public Collection<Article> getAvailableMovies() {
        return getCheckedInArticles(movies);
    }


    public boolean returnBook(String title) throws InvalidArticleToReturnException, ArticleIsAlreadyCheckedInException {
        return returnArticle(title, books);
    }
    public boolean returnMovie(String title) throws InvalidArticleToReturnException, ArticleIsAlreadyCheckedInException {
        return returnArticle(title, movies);
    }



    public boolean returnArticle(String bookTitle, HashMap<String, Article> collection) throws InvalidArticleToReturnException, ArticleIsAlreadyCheckedInException {
        if (!articleExistsInCatalog(bookTitle)) {
            throw new InvalidArticleToReturnException();
        } else if (!collection.get(bookTitle).checkedOut) {
            throw new ArticleIsAlreadyCheckedInException();
        } else {
            collection.get(bookTitle).checkIn();
            return true;
        }
    }

    public boolean articleExistsInCatalog(String article) {
        if (books.containsKey(article)){
            return true;
        } else if (movies.containsKey(article)) {
            return true;
        } else return false;

    }

    public boolean borrowBook(String title, String userLibraryNumber) throws ArticleDoesNotExistInLibraryException, ArticleIsCurrentlyCheckedOutException {
        return borrowArticle(title, books, userLibraryNumber);
    }

    public boolean borrowMovie(String title, String userLibraryNumber) throws ArticleDoesNotExistInLibraryException, ArticleIsCurrentlyCheckedOutException {
        return borrowArticle(title, movies, userLibraryNumber);
    }

    private boolean borrowArticle(String title, HashMap<String, Article> collection, String userLibraryNumber) throws ArticleDoesNotExistInLibraryException, ArticleIsCurrentlyCheckedOutException {
        if (!articleExistsInCatalog(title)) {
            throw new ArticleDoesNotExistInLibraryException();
        } else if (collection.get(title).checkedOut) {
            throw new ArticleIsCurrentlyCheckedOutException();
        } else {
            collection.get(title).checkOut(userLibraryNumber);
            return true;
        }
    }

    public Book getBook(String title) throws ArticleDoesNotExistInLibraryException{
        if (articleExistsInCatalog(title)) {
            return (Book) books.get(title);
        } else {
            throw new ArticleDoesNotExistInLibraryException();
        }
    }
}
