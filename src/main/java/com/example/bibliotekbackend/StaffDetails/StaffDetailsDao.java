package com.example.bibliotekbackend.StaffDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class StaffDetailsDao {

    /**
     * Data access object for staff Details table in database
     */

    @Autowired
    private JdbcTemplate jdbcTemplate;

    ArrayList<StaffDetails> staffDetailsList;


    /**
    * Method to insert staff details into database
    */

    public Map insertStaffDetails(String staff_firstname, String staff_lastname, String staff_mail, String staff_phonenumber, String staff_adress, String staff_city, String staff_zip_code, String staff_pnr, int staff_ID_staff) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_staffDetails");

        Map<String, String> inParameters = new HashMap<>();

        StaffDetails staffDetails = new StaffDetails(staff_firstname, staff_lastname, staff_mail, staff_phonenumber, staff_adress, staff_city, staff_zip_code, staff_pnr, staff_ID_staff);

        inParameters.put("new_staff_firstname", staff_firstname);
        inParameters.put("new_staff_lastname", staff_lastname);
        inParameters.put("new_staff_mail", staff_mail);
        inParameters.put("new_staff_phonenumber", staff_phonenumber);
        inParameters.put("new_staff_adress", staff_adress);
        inParameters.put("new_staff_city", staff_city);
        inParameters.put("new_staff_zip_code", staff_zip_code);
        inParameters.put("new_staff_pnr", staff_pnr);
        inParameters.put("new_staffDetails_id_staff", String.valueOf(staff_ID_staff));

        System.out.println("Dao" + inParameters);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        System.out.println("in" + in);

        Map<String, Object> outParameters = jdbcCall.execute(in);

        staffDetails.setStaff_firstname(staff_firstname);
        staffDetails.setStaff_lastname(staff_lastname);
        staffDetails.setStaff_mail(staff_lastname);
        staffDetails.setStaff_phonenumber(staff_lastname);
        staffDetails.setStaff_adress(staff_lastname);
        staffDetails.setStaff_city(staff_lastname);
        staffDetails.setStaff_zip_code(staff_zip_code);
        staffDetails.setStaff_pnr(staff_pnr);
        staffDetails.setStaff_ID_staff(staff_ID_staff);


        return outParameters;
    }

    /**
     * Method to update staff details in database
     **/

    public void updateStaffDetails(int staff_ID_staff, String staff_firstname, String staff_lastname, String staff_mail, String staff_phonenumber, String staff_adress, String staff_city, String staff_zip_code, String staff_pnr) {

        String query = "UPDATE staff_details SET staff_firstname = ?, staff_lastname = ?, staff_mail = ?, staff_phonenumber = ?, staff_adress = ?, staff_city = ?, staff_zip_code = ?, staff_pnr = ? WHERE staff_ID_staff = ?;";

        int result = jdbcTemplate.update(query, staff_ID_staff, staff_firstname, staff_lastname, staff_mail, staff_phonenumber, staff_adress, staff_city, staff_zip_code, staff_pnr);

        if (result > 0) {
            System.out.println(result + " staff details updated in database");
        }
    }

    /**
     * Method to delete staff details by ID in database
     **/

    public void deleteStaffDetails(int staff_ID_staff) {

        String query = "DELETE FROM staff_details WHERE staff_ID_staff = ?;";

        int result = jdbcTemplate.update(query, staff_ID_staff);

        if (result > 0) {
            System.out.println(result + " staff details deleted from database");
        }

    }

    /**
     * Method to display staff details by ID from database
     **/

    public StaffDetails ShowStaffDetailsByID (int staff_ID_staff) {

        String query = "SELECT * FROM staff_details WHERE staff_ID_staff = ?;";

        return this.jdbcTemplate.queryForObject(query, new RowMapper<StaffDetails>() {
            @Override
            public StaffDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                StaffDetails innerStaff = new StaffDetails(
                        rs.getString("staff_firstname"),
                        rs.getString("staff_lastname"),
                        rs.getString("staff_mail"),
                        rs.getString("staff_phonenumber"),
                        rs.getString("staff_adress"),
                        rs.getString("staff_city"),
                        rs.getString("staff_zip_code"),
                        rs.getString("staff_pnr"),
                        rs.getInt("staff_ID_staff")
                        );
                return innerStaff;
            }
        }, staff_ID_staff);
    }

    /**
     * Method to display all staff details from database
     **/

    public ArrayList<StaffDetails> showAllStaffDetails() {
        String query = "SELECT * FROM staff_details;";
        ArrayList<StaffDetails> staffDetailsList = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows) {
            StaffDetails staffDetails = new StaffDetails(
                    String.valueOf(row.get("staff_firstname")),
                    String.valueOf(row.get("staff_lastname")),
                    String.valueOf(row.get("staff_mail")),
                    String.valueOf(row.get("staff_phonenumber")),
                    String.valueOf(row.get("staff_adress")),
                    String.valueOf(row.get("staff_city")),
                    String.valueOf(row.get("staff_zip_code")),
                    String.valueOf(row.get("staff_pnr")),
                    (int) (long) row.get("ID_staff"));
                staffDetailsList.add(staffDetails);
        }
        staffDetailsList.sort(Comparator.comparing(StaffDetails::getStaff_firstname));
        return staffDetailsList;
    }
}







