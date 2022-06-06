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

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

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
     * method to delete a book from database using ID
     */
    public Map delete_book_ID(String ID_book) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_book_ID");

        Map<String, String> inParameters = new HashMap<>();

        Book book = new Book(ID_book);

        inParameters.put("selected_ID_book", ID_book);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        Map<String, Object> outParameters = jdbcCall.execute(in);

        book.setCheck_book(ID_book);

        return outParameters;

    }

    public Map delete_book_ISBN(String ISBN_book) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_book_ISBN");

        Map<String, String> inParameters = new HashMap<>();

        inParameters.put("selected_ISBN_book", ISBN_book);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        Map<String, Object> outParameters = jdbcCall.execute(in);

        return outParameters;

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

    public Map popular_books(String book_genre) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("show_popular_books_view");

        Map<String, String> inParameters = new HashMap<>();
        Book book = new Book(null, null, null, book_genre, null, null);
        inParameters.put("genre", book_genre);
        System.out.println("Dao" + inParameters);
        SqlParameterSource in = new MapSqlParameterSource(inParameters);
        System.out.println("in" + in);
        Map<String, Object> outParameters = simpleJdbcCall.execute(in);

        System.out.println(outParameters);
        book.setBook_genre(book_genre);
        return outParameters;

    }

    public Map search_for_a_book_qty(String check_book) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("search_for_a_book_qty");

        Map<String, String> inParameters = new HashMap<>();
        Book book = new Book(check_book);
        inParameters.put("check_book", check_book);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);
        System.out.println("in" + in);

        Map<String, Object> outParameters = simpleJdbcCall.execute(in);

        System.out.println(outParameters);

        book.setBook_genre(check_book);

        return outParameters;

    }

    public Map update_book(String ISBN_book, String book_qty){
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_book");

        Map<String, String> inParameters = new HashMap<>();
        Book book = new Book(ISBN_book, book_qty);
        inParameters.put("ISBN_book_live", ISBN_book);
        inParameters.put("qty_book", book_qty);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);
        System.out.println("in" + in);

        Map<String, Object> outParameters = simpleJdbcCall.execute(in);

        System.out.println(outParameters);

        book.setISBN_book(ISBN_book);
        book.setBook_qty(book_qty);

        return outParameters;
    }

    public Map yes_delete(String ISBN_book) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("yes_delete");

        Map<String, String> inParameters = new HashMap<>();

        inParameters.put("ISBN", ISBN_book);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        Map<String, Object> outParameters = jdbcCall.execute(in);

        return outParameters;

    }


}
