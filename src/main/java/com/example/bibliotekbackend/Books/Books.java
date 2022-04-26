package com.example.bibliotekbackend.Books;

public class Books {
    private int ID_book;
    private String book_title;
    private int book_qty;
    private String book_author;
    private String book_genre;

    public Books(int ID_book, String book_title, int book_qty, String book_author, String book_genre) {
        this.ID_book = ID_book;
        this.book_title = book_title;
        this.book_qty = book_qty;
        this.book_author = book_author;
        this.book_genre = book_genre;
    }

    public int getID_book() {
        return ID_book;
    }

    public void setID_book(int ID_book) {
        this.ID_book = ID_book;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public int getBook_qty() {
        return book_qty;
    }

    public void setBook_qty(int book_qty) {
        this.book_qty = book_qty;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_genre() {
        return book_genre;
    }

    public void setBook_genre(String book_genre) {
        this.book_genre = book_genre;
    }
}

