package com.example.bibliotekbackend.Staff;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StaffDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


}
