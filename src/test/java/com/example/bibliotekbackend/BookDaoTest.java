package com.example.bibliotekbackend;


import com.example.bibliotekbackend.Books.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

@JdbcTest
@Sql({"library.sql", "test-data.sql"})
public class BookDaoTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    void whenInsertBookCorrect_thenReturnSuccess(){
        BookDao bookDao = new BookDao();


    }


}
