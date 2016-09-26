package com.twu.biblioteca;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Library {

    HashMap<String, Article> articles;

    public Library() {

        this.articles = new HashMap<String, Article>();

    }

    public void add(Article article) {
        if (article.getClass().equals(Book.class)){
            Book book = (Book)article;
            articles.put(book.title, book);
        } else if (article.getClass().equals(Movie.class)){
            Movie movie = (Movie)article;
            articles.put(movie.title, movie);
        }
    }

    public Collection<Article> getAvailableBooks() {
        Collection<Article> availableBooks = getBooks().values();
        for (Iterator<Article> iterator = availableBooks.iterator(); iterator.hasNext();) {
            Article book = iterator.next();
            if (book.checkedOut) {
                iterator.remove();
            }
        }
        return availableBooks;
    }

    public boolean returnBook(String title) throws InvalidBookToReturnException, BookIsAlreadyCheckedInException{
        return returnArticle(title, Book.class);
    }
    public boolean returnMovie(String title) throws InvalidBookToReturnException, BookIsAlreadyCheckedInException{
        return returnArticle(title, Movie.class);
    }



    public boolean returnArticle(String bookTitle, Class articleType) throws InvalidBookToReturnException, BookIsAlreadyCheckedInException{
        if (!articleExists(bookTitle)) {
            throw new InvalidBookToReturnException();
        } else if (!getBooks().get(bookTitle).checkedOut) {
            throw new BookIsAlreadyCheckedInException();
        } else {
            getBooks().get(bookTitle).checkIn();
            return true;
        }
    }

    public int articleCount() {
        int articleCount = 0;
        for (Article article : getBooks().values()) {
            if (!article.checkedOut) {
                articleCount++;
            }
        }
        return articleCount;
    }

    public boolean articleExists(String article) {
        if (getBooks().containsKey(article)){
            return true;
        } else if (getMovies().containsKey(article)) {
            return true;
        } else return false;

    }

    public Collection<Article> getAvailableMovies() {
        Collection<Article> availableMovies = getMovies().values();
        for (Iterator<Article> iterator = availableMovies.iterator(); iterator.hasNext();) {
            Article movie = iterator.next();
            if (movie.checkedOut) {
                iterator.remove();
            }
        }
        return availableMovies;
    }

    public boolean borrowBook(String title) throws BookDoesNotExistInLibraryException, BookIsCurrentlyCheckedOutException{
        return borrowArticle(title, Book.class);
    }

    private boolean borrowArticle(String title, Class articleType) throws BookDoesNotExistInLibraryException, BookIsCurrentlyCheckedOutException{
        HashMap<String, Article> booksCollection = getArticlesByType(articleType);
        if (!articleExists(title)) {
            throw new BookDoesNotExistInLibraryException();
        } else if (booksCollection.get(title).checkedOut) {
            throw new BookIsCurrentlyCheckedOutException();
        } else {
            booksCollection.get(title).checkOut();
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
