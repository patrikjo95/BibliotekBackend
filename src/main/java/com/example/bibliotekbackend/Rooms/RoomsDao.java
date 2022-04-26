package com.example.bibliotekbackend.Rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public class RoomsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
}
