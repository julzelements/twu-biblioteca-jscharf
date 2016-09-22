package com.twu.biblioteca;

/**
 * Created by jscharf on 22/09/2016.
 */
public class Movie {
    final String title;
    final String director;
    final String year;
    final String rating;
    boolean checkedOut;

    public Movie(String title, String director, String year, String rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.checkedOut = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (checkedOut != movie.checkedOut) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (director != null ? !director.equals(movie.director) : movie.director != null) return false;
        if (year != null ? !year.equals(movie.year) : movie.year != null) return false;
        return rating != null ? rating.equals(movie.rating) : movie.rating == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (checkedOut ? 1 : 0);
        return result;
    }
}
