package com.example.bibliotekbackend.CustomerDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDetailsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


}
