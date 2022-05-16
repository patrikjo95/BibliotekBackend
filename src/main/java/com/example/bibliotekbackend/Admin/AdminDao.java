package com.example.bibliotekbackend.Admin;


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

    // for ref:
    // int ID_admin, String admin_username, String admin_password


    /**
     * gets one admin from the database by id
     */
    public Admin downloadOneAdminByID(int ID_admin) {

        String query = "SELECT * FROM admin WHERE ID_admin = ?;";

        return this.jdbcTemplate.queryForObject(query, new RowMapper<Admin>() {
            @Override
            public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
                Admin innerAdmin = new Admin(
                        rs.getInt("ID_admin"),
                        rs.getString("admin_username"),
                        rs.getString("admin_password")
                );
                return innerAdmin;
            }
        }, ID_admin);
    }

    /**
     * gets one admin from the database by admin_username
     */
    public String downloadAdminByUsername(String admin_username) {
        Gson gson = new Gson();
        String query = "SELECT * FROM admin WHERE admin_username = ?;";
        Admin temp = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Admin(
                rs.getInt("ID_admin"),
                rs.getString("admin_username"),
                rs.getString("admin_password")), admin_username);
        return gson.toJson(temp);
    }

    /**
     * downloads all admin from the database
     *
     * @return ArrayList<Admin>
     */
    public ArrayList<Admin> downloadAllAdmin() {
        String query = "SELECT * FROM admin;";
        ArrayList<Admin> adminList = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows) {
            Admin admin = new Admin(
                    (int) (long) row.get("ID_admin"),
                    String.valueOf(row.get("admin_username")),
                    String.valueOf(row.get("admin_password")));
            adminList.add(admin);
        }
        adminList.sort(Comparator.comparing(Admin::getAdmin_username));
        return adminList;
    }
}
