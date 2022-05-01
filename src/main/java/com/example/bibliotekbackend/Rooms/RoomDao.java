package com.example.bibliotekbackend.Rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
}
