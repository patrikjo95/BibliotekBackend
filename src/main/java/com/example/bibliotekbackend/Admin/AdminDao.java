package com.example.bibliotekbackend.Admin;


import com.example.bibliotekbackend.Customer.Customer;
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

/**
 * Data access object for admin table in database
 */
@Repository
public class AdminDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String error;

    public AdminDao() {
        this.error = "no";
        this.jdbcTemplate = new JdbcTemplate();
    }

    /**
     * scans the mail and password input from the frontend and checks it with the decrypted table in DB
     * @param test_mail
     * @param test_password
     * @return
     */
    public Map scan_mail_and_password_admin(String test_mail, String test_password){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("scan_mail_and_password_admin");

        Map<String, String> inParameters = new HashMap<>();

        Admin admin = new Admin(test_mail, test_password);

        inParameters.put("test_mail", test_mail);
        inParameters.put("test_password", test_password);

        System.out.println("Dao" + inParameters);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);
        System.out.println("in" + in);

        Map<String, Object> outParameters = jdbcCall.execute(in);


        admin.setAdmin_username(test_mail);
        admin.setAdmin_password(test_password);

        return outParameters;
    }
}
