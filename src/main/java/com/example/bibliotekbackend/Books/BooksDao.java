package com.example.bibliotekbackend.Books;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public class BooksDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


}
