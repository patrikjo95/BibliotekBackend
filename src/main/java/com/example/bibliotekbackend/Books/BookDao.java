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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
    public Map insertBook(String book_title, String book_qty, String book_author, String book_genre, String book_year, String book_URL) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_book");

        Map<String, String> inParameters = new HashMap<>();

        Book book = new Book(book_title, book_qty, book_author, book_genre, book_year, book_URL);


        inParameters.put("new_book_title", book_title);
        inParameters.put("new_book_qty", book_qty);
        inParameters.put("new_book_author", book_author);
        inParameters.put("new_book_genre", book_genre);
        inParameters.put("new_book_year", book_year);
        inParameters.put("new_book_URL", book_URL);

        System.out.println("Dao" + inParameters);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        System.out.println("in" + in);

        Map<String, Object> outParameters = jdbcCall.execute(in);

        book.setBook_title(book_title);
        book.setBook_qty(book_qty);
        book.setBook_author(book_author);
        book.setBook_genre(book_genre);
        book.setBook_year(book_year);
        book.setBook_URL(book_URL);

        return outParameters;
    }

    public Map search_for_a_book_everyone(String check_book) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("search_for_a_book_everyone");

        Map<String, String> inParameters = new HashMap<>();

        Book book = new Book(check_book);

        inParameters.put("check_book", check_book);

        //System.out.println("Dao" + inParameters);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        //System.out.println("in" + in);

        Map<String, Object> outParameters = jdbcCall.execute(in);

        book.setCheck_book(check_book);

        return outParameters;
    }


    public Map search_for_a_book_admin(String check_book) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("search_for_a_book_admin");

        Map<String, String> inParameters = new HashMap<>();

        Book book = new Book(check_book);

        inParameters.put("check_book", check_book);

        //System.out.println("Dao" + inParameters);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        //System.out.println("in" + in);

        Map<String, Object> outParameters = jdbcCall.execute(in);

        book.setCheck_book(check_book);

        return outParameters;
    }

    public Map search_for_a_book_borrow(String check_book) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("search_for_a_book_borrow");

        Map<String, String> inParameters = new HashMap<>();

        Book book = new Book(check_book);

        inParameters.put("check_book", check_book);

        System.out.println("Dao" + inParameters);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        System.out.println("in" + in);

        Map<String, Object> outParameters = jdbcCall.execute(in);

        book.setCheck_book(check_book);

        return outParameters;
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
    public Map delete_book_ID(String ID_book) {
        /*
        String query = "DELETE FROM books WHERE ID_book = ?;";

        int result = jdbcTemplate.update(query, ID_book);

        if (result > 0) {
            System.out.println(result + " book deleted from database");
            this.error = "book deleted from database";
        }

         */

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_book_ID");

        Map<String, String> inParameters = new HashMap<>();

        Book book = new Book(ID_book);

        inParameters.put("selected_ID_book", ID_book);

        //System.out.println("Dao" + inParameters);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        //System.out.println("in" + in);

        Map<String, Object> outParameters = jdbcCall.execute(in);

        book.setCheck_book(ID_book);

        return outParameters;

    }

    public Map delete_book_ISBN(String ISBN_book) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_book_ISBN");

        Map<String, String> inParameters = new HashMap<>();

        // Book book = new Book(ISBN_book);

        inParameters.put("selected_ISBN_book", ISBN_book);

        //System.out.println("Dao" + inParameters);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        //System.out.println("in" + in);

        Map<String, Object> outParameters = jdbcCall.execute(in);

        // book.setCheck_book(ID_book);

        return outParameters;

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
                        rs.getString("ID_book"),
                        rs.getString("book_title"),
                        rs.getString("book_qty"),
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
                rs.getString("ID_book"),
                rs.getString("book_title"),
                rs.getString("book_qty"),
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
                    String.valueOf(row.get("ID_book")),
                    String.valueOf(row.get("book_title")),
                    String.valueOf(row.get("book_qty")),
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
            Book book = new Book(
                    rs.getString("ID_book"),
                    rs.getString("book_title"),
                    rs.getString("book_qty"),
                    rs.getString("book_author"),
                    rs.getString("book_genre"),
                    rs.getString("book_year"),
                    rs.getString("book_URL"));
            return book;
        });
        return temp;
    }

    public Map return_book(String book_id) {
        System.out.println("Toros" + book_id);
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("return_book");

        Map<String, String> inParameters = new HashMap<>();

        inParameters.put("book_id", book_id);

        System.out.println("Dao" + inParameters);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);
        System.out.println("in" + in);

        Map<String, Object> outParameters = simpleJdbcCall.execute(in);
        System.out.println(outParameters);

        System.out.println("Toros" + book_id);
        return outParameters;
    }

    public Map select_all_borrowed_books() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("select_all_borrowed_books");


        Map<String, Object> outParameters = simpleJdbcCall.execute();

        System.out.println(outParameters);

        return outParameters;
    }

}
