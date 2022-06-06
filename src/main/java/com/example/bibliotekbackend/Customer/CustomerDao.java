package com.example.bibliotekbackend.Customer;


import com.example.bibliotekbackend.Books.Book;
import com.google.gson.Gson;
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

import static com.example.bibliotekbackend.Customer.Customer.createCustomer;

/**
 * Data access object for customer table in database
 */
@Repository
public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String error;

    public CustomerDao() {
        this.error = "no";
        this.jdbcTemplate = new JdbcTemplate();

    }

    /**
     * method to insert a new customer into the database
     */
    public Map add_customer(String customer_pnr, String customer_pin) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_customer");

        Map<String, String> inParameters = new HashMap<>();

        Customer customer = new Customer(customer_pnr, customer_pin);

        inParameters.put("pnr", customer_pnr);
        inParameters.put("pin", customer_pin);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        Map<String, Object> outParameters = jdbcCall.execute(in);

        customer.setCustomer_pnr(customer_pnr);
        customer.setCustomer_pin(customer_pin);

        return outParameters;
    }


    public Map login_customer(String customer_pnr, String customer_pin) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("login_customer");

        Map<String, String> inParameters = new HashMap<>();

        Customer customer = new Customer(customer_pnr, customer_pin);

        inParameters.put("test_pnr", customer_pnr);
        inParameters.put("test_pin", customer_pin);

        System.out.println("Dao" + inParameters);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);
        System.out.println("in" + in);

        Map<String, Object> outParameters = jdbcCall.execute(in);


        customer.setCustomer_pnr(customer_pnr);
        customer.setCustomer_pin(customer_pin);

        return outParameters;
    }

    public Map borrow_book(String customer_pnr, String ISBN_book) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("borrow_book");

        Map<String, String> inParameters = new HashMap<>();


        inParameters.put("customer_pnr_live", customer_pnr);
        inParameters.put("ISBN_book_live", ISBN_book);

        System.out.println("Dao" + inParameters);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);
        System.out.println("in" + in);


        Map<String, Object> outParameters = jdbcCall.execute(in);
        System.out.println(outParameters);

        return outParameters;
    }

    public Map which_books_are_borrowed(String customer_pnr_live) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("which_books_are_borrowed");

        Map<String, String> inParameters = new HashMap<>();

        inParameters.put("customer_pnr_live", customer_pnr_live);

        System.out.println("Dao" + inParameters);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);
        System.out.println("in" + in);

        Map<String, Object> outParameters = simpleJdbcCall.execute(in);
        System.out.println(outParameters);

        return outParameters;
    }

}












