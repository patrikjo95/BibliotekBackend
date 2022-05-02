package com.example.bibliotekbackend.Books;

// 2022 apr 30
// Toros
// added methods

// 2022 may 01
// Toros
// imported Gson

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**
 * Data access object for books table in database
 */
@Repository
public class BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String error;

    public BookDao() {
        this.error = "no";
        this.jdbcTemplate = new JdbcTemplate();
    }

    // for ref:
    // int ID_book, String book_title, int book_qty, String book_author, String book_genre, String book_year, String book_URL

    /**
     * method to insert a new Book into the database
     */
    public void insertBook(String book_title, int book_qty, String book_author, String book_genre, String book_year, String book_URL) {
        String query = "INSERT INTO books VALUES(null,?,?,?,?,?,?);";

        int result = jdbcTemplate.update(query, book_title, book_qty, book_author, book_genre, book_year, book_URL);

        if (result > 0) {
            System.out.println(result + " book added to database");
            this.error = "book added to database";
        }
    }

    /**
     * updates a book in database by ID
     */
    public void updateBook(int ID_book, String book_title, int book_qty, String book_author, String book_genre, String book_year, String book_URL) {

        String query = "UPDATE books SET book_title = ?, book_qty = ?, book_author = ?, book_genre = ?, book_year = ?, book_URL = ? WHERE ID_book = ?;";

        int result = jdbcTemplate.update(query, book_title, book_qty, book_author, book_genre, book_year, book_URL, ID_book);

        if (result > 0) {
            System.out.println(result + " book updated in database");
            this.error = "book updated in database";
        }
    }

    /**
     * method to delete a book from database using ID
     */
    public void deleteBook(int ID_book) {

        String query = "DELETE FROM books WHERE ID_book = ?;";

        int result = jdbcTemplate.update(query, ID_book);

        if (result > 0) {
            System.out.println(result + " book deleted from database");
            this.error = "book deleted from database";
        }
    }

    /**
     * gets one book from the database by id
     */
    public Book downloadOneBookByID(int ID_book) {

        String query = "SELECT * FROM books WHERE ID_book = ?;";

        return this.jdbcTemplate.queryForObject(query, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book innerBook = new Book(
                        rs.getInt("ID_book"),
                        rs.getString("book_title"),
                        rs.getInt("book_qty"),
                        rs.getString("book_author"),
                        rs.getString("book_genre"),
                        rs.getString("book_year"),
                        rs.getString("book_URL")
                );
                return innerBook;
            }
        }, ID_book);
    }

    /**
     * gets one book from the database by title
     */
    public String downloadBookByTitle(String book_title) {
        Gson gson = new Gson();
        String query = "SELECT * FROM books WHERE book_title = ?;";
        Book temp = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Book(
                rs.getInt("ID_book"),
                rs.getString("book_title"),
                rs.getInt("book_qty"),
                rs.getString("book_author"),
                rs.getString("book_genre"),
                rs.getString("book_year"),
                rs.getString("book_URL")), book_title);
        return gson.toJson(temp);
    }

    /**
     * downloads all books from the database
     *
     * @return ArrayList<Book>
     */
    public ArrayList<Book> downloadAllBooks() {
        String query = "SELECT * FROM books;";
        ArrayList<Book> books = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows) {
            Book book = new Book(
                    (int) (long) row.get("ID_book"),
                    String.valueOf(row.get("book_title")),
                    (int) (long) row.get("book_qty"),
                    String.valueOf(row.get("book_author")),
                    String.valueOf(row.get("book_genre")),
                    String.valueOf(row.get("book_year")),
                    String.valueOf(row.get("book_URL")));
            books.add(book);
        }
        books.sort(Comparator.comparing(Book::getBook_title));
        return books;
    }

    /**
     * Method to download the book with the highest id, meaning its new and should be on our frontpage as a recommendation
     */
    public Book newlyAddedBook() {
        String query = "SELECT * FROM books WHERE ID_book = (SELECT MAX(ID_book) FROM books);";
        Book temp = jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
            Book book = new Book(rs.getInt("ID_book"),
                    rs.getString("book_title"),
                    rs.getInt("book_qty"),
                    rs.getString("book_author"),
                    rs.getString("book_genre"),
                    rs.getString("book_year"),
                    rs.getString("book_URL"));
            return book;
        });
        return temp;
    }
}
