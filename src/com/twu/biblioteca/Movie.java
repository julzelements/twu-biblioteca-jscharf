package com.twu.biblioteca;

public class Movie extends Article{
    final String director;
    final String rating;
    private String checkedOutTo;

    public Movie(String title, String director, String year, String rating, String checkedOutTo) {
        super(title, year);
        this.director = director;
        this.rating = rating;
        this.checkedOutTo = checkedOutTo;
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
