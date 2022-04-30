package com.example.bibliotekbackend.Books;

// 2022 apr 30
// Toros
// added methods

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public class BooksDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String error;

    public BooksDao() {
        this.error = "no";
        this.jdbcTemplate = new JdbcTemplate();
    }

    // for ref:
    // int ID_book, String book_title, int book_qty, String book_author, String book_genre
    public void insertNewBook(String book_title, int book_qty, String book_author, String book_genre) {
        String query = "INSERT INTO books VALUES(null,?,?,?,?);";

        int result = jdbcTemplate.update(query, book_title, book_qty, book_author, book_genre);

        if (result > 0) {
            System.out.println(result + " book added to database");
            this.error = "book added to database";
        }
    }

    public void updateBook(int ID_book, String book_title, int book_qty, String book_author, String book_genre) {

        String query = "UPDATE books SET book_title = ?, book_qty = ?, book_author = ?, book_genre = ? WHERE ID_book = ?;";

        int result = jdbcTemplate.update(query, book_title, book_qty, book_author, book_genre, ID_book);

        if (result > 0) {
            System.out.println(result + "book updated in database");
            this.error = "book updated in database";
        }
    }

    public void deleteBook(int ID_book){

        String query = "DELETE FROM books WHERE ID_book = ?";

        int result = jdbcTemplate.update(query, ID_book);

        if(result > 0){
            System.out.println(result + " book deleted from database");
            this.error = "book deleted from database";
        }
    }

    // continue with downloadOneBook(int ID_book)
























}
