package com.example.bibliotekbackend.Customers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


}
