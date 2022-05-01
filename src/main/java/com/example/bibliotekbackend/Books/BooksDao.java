package com.example.bibliotekbackend.Books;

// 2022 apr 30
// Toros
// added methods

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson; // Why not working??

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

    public void deleteBook(int ID_book) {

        String query = "DELETE FROM books WHERE ID_book = ?";

        int result = jdbcTemplate.update(query, ID_book);

        if (result > 0) {
            System.out.println(result + " book deleted from database");
            this.error = "book deleted from database";
        }
    }

    public Book downloadOneBookByID(int ID_book) {

        String query = "SELECT * FROM books ID_book = ?;";

        return this.jdbcTemplate.queryForObject(query, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book innerBook = new Book(
                        rs.getInt("ID_book"),
                        rs.getString("book_title"),
                        rs.getInt("book_qty"),
                        rs.getString("book_author"),
                        rs.getString("book_genre")
                );
                return innerBook;
            }
        }, ID_book);
    }

    // Why GSON and JSON not working??
    public String downloadBookByTitle(String book_title){
        Gson gson = new Gson();
        String query = "SELECT * FROM books WHERE book_title = ?";
        Book temp = this.jdcbTemplate.queryForObject(query, (rs, rowNum) -> new Book(
                rs.getInt("ID_book"),
                rs.getString("book_title"),
                rs.getInt("book_qty"),
                rs.getString("book_author"),
                rs.getString("book_genre"),
        ), book_title);
        return gson.toJson(temp);
    }

    public ArrayList<Book> downloadAllBooks(){
        String query = "SELECT * FROM books;";
        ArrayList<Book> books = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for(Map<String, Object> row : rows) {
            Book book = new Book(
                    (int) (long) row.get("ID_book"),
                    String.valueOf(row.get("book_title")),
                    String.valueOf(row.get("book_qty")),
                    String.valueOf(row.get("book_author")),
                    String.valueOf(row.get("book_genre"));
            books.add(book);
        }
        books.sort(Comparator.comparing(Book::getBook_title));
        return books;
    }
























}
