package com.example.bibliotekbackend.Staff;


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

/**
 * Data access object for staff table in database
 */
@Repository
public class StaffDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String error;

    public StaffDao() {
        this.error = "no";
        this.jdbcTemplate = new JdbcTemplate();
    }

    // for ref:
    // int ID_staff, String staff_username, String staff_password

    /**
     * method to insert a new Staff into the database
     */
    public Map insertStaff(String staff_username, String staff_password) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_staff");

        Map<String, String> inParameters = new HashMap<>();

        Staff staff = new Staff(staff_username, staff_password);


        inParameters.put("new_staff_username", staff_username);
        inParameters.put("new_staff_password", staff_password);

        System.out.println("Dao" + inParameters); // ??

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        System.out.println("in" + in); // ??

        Map<String, Object> outParameters = jdbcCall.execute(in);

        staff.setStaff_username(staff_username);
        staff.setStaff_password(staff_password);

        return outParameters;

        /*String query = "INSERT INTO books VALUES(null,?,?,?,?,?,?);";

        int result = jdbcTemplate.update(query, book_title, book_qty, book_author, book_genre, book_year, book_URL);

        if (result > 0) {
            System.out.println(result + " book added to database");
            this.error = "book added to database";
        }*/
    }

    /**
     * updates a staff in database by ID
     */
    public void updateStaff(int ID_staff, String staff_username, String staff_password) {

        String query = "UPDATE staff SET staff_username = ?, staff_password = ? WHERE ID_staff = ?;";

        int result = jdbcTemplate.update(query, staff_username, staff_password, ID_staff);

        if (result > 0) {
            System.out.println(result + " staff updated in database");
            this.error = "staff updated in database";
        }
    }

    /**
     * method to delete a staff from database using ID
     */
    public void deleteStaff(int ID_staff) {

        String query = "DELETE FROM staff WHERE ID_staff = ?;";

        int result = jdbcTemplate.update(query, ID_staff);

        if (result > 0) {
            System.out.println(result + " staff deleted from database");
            this.error = "staff deleted from database";
        }
    }

    /**
     * gets one staff from the database by id
     */
    public Staff downloadOneStaffByID(int ID_staff) {

        String query = "SELECT * FROM staff WHERE ID_staff = ?;";

        return this.jdbcTemplate.queryForObject(query, new RowMapper<Staff>() {
            @Override
            public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
                Staff innerStaff = new Staff(
                        rs.getInt("ID_staff"),
                        rs.getString("staff_username"),
                        rs.getString("staff_password")
                );
                return innerStaff;
            }
        }, ID_staff);
    }

    /**
     * gets one staff from the database by staff_username
     */
    public String downloadStaffByUsername(String staff_username) {
        Gson gson = new Gson();
        String query = "SELECT * FROM staff WHERE staff_username = ?;";
        Staff temp = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Staff(
                rs.getInt("ID_staff"),
                rs.getString("staff_username"),
                rs.getString("staff_password")), staff_username);
        return gson.toJson(temp);
    }

    /**
     * downloads all staff from the database
     *
     * @return ArrayList<Staff>
     */
    public ArrayList<Staff> downloadAllStaff() {
        String query = "SELECT * FROM staff;";
        ArrayList<Staff> staffList = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows) {
            Staff staff = new Staff(
                    (int) (long) row.get("ID_staff"),
                    String.valueOf(row.get("staff_username")),
                    String.valueOf(row.get("staff_password")));
            staffList.add(staff);
        }
        staffList.sort(Comparator.comparing(Staff::getStaff_username));
        return staffList;
    }
}
