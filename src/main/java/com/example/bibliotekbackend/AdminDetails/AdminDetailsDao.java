package com.example.bibliotekbackend.AdminDetails;

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

@Repository
public class AdminDetailsDao {

    /**
     * Data access object for admin Details table in database
     */

    @Autowired
    private JdbcTemplate jdbcTemplate;

    ArrayList<AdminDetails> adminDetailsList;


    /**
    * Method to insert admin details into database
    */

    public Map insertAdminDetails(String admin_firstname, String admin_lastname, String admin_mail, String admin_phonenumber, String admin_adress, String admin_city, String admin_zip_code, String admin_pnr, int admin_ID_admin) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_adminDetails");

        Map<String, String> inParameters = new HashMap<>();

        AdminDetails adminDetails = new AdminDetails(admin_firstname, admin_lastname, admin_mail, admin_phonenumber, admin_adress, admin_city, admin_zip_code, admin_pnr, admin_ID_admin);

        inParameters.put("new_admin_firstname", admin_firstname);
        inParameters.put("new_admin_lastname", admin_lastname);
        inParameters.put("new_admin_mail", admin_mail);
        inParameters.put("new_admin_phonenumber", admin_phonenumber);
        inParameters.put("new_admin_adress", admin_adress);
        inParameters.put("new_admin_city", admin_city);
        inParameters.put("new_admin_zip_code", admin_zip_code);
        inParameters.put("new_admin_pnr", admin_pnr);
        inParameters.put("new_adminDetails_id_admin", String.valueOf(admin_ID_admin));

        System.out.println("Dao" + inParameters);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        System.out.println("in" + in);

        Map<String, Object> outParameters = jdbcCall.execute(in);

        adminDetails.setAdmin_firstname(admin_firstname);
        adminDetails.setAdmin_lastname(admin_lastname);
        adminDetails.setAdmin_mail(admin_lastname);
        adminDetails.setAdmin_phonenumber(admin_lastname);
        adminDetails.setAdmin_adress(admin_lastname);
        adminDetails.setAdmin_city(admin_lastname);
        adminDetails.setAdmin_zip_code(admin_zip_code);
        adminDetails.setAdmin_pnr(admin_pnr);
        adminDetails.setAdmin_ID_admin(admin_ID_admin);


        return outParameters;
    }

    /**
     * Method to update admin details in database
     **/

    public void updateAdminDetails(int admin_ID_admin, String admin_firstname, String admin_lastname, String admin_mail, String admin_phonenumber, String admin_adress, String admin_city, String admin_zip_code, String admin_pnr) {

        String query = "UPDATE admin_details SET admin_firstname = ?, admin_lastname = ?, admin_mail = ?, admin_phonenumber = ?, admin_adress = ?, admin_city = ?, admin_zip_code = ?, admin_pnr = ? WHERE admin_ID_admin = ?;";

        int result = jdbcTemplate.update(query, admin_ID_admin, admin_firstname, admin_lastname, admin_mail, admin_phonenumber, admin_adress, admin_city, admin_zip_code, admin_pnr);

        if (result > 0) {
            System.out.println(result + " admin details updated in database");
        }
    }

    /**
     * Method to delete admin details by ID in database
     **/

    public void deleteAdminDetails(int admin_ID_admin
    ) {

        String query = "DELETE FROM admin_details WHERE admin_ID_admin = ?;";

        int result = jdbcTemplate.update(query, admin_ID_admin);

        if (result > 0) {
            System.out.println(result + " admin details deleted from database");
        }

    }

    /**
     * Method to display admin details by ID from database
     **/

    public AdminDetails ShowAdminDetailsByID(int admin_ID_admin) {

        String query = "SELECT * FROM admin_details WHERE admin_ID_admin = ?;";

        return this.jdbcTemplate.queryForObject(query, new RowMapper<AdminDetails>() {
            @Override
            public AdminDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                AdminDetails innerAdmin = new AdminDetails(
                        rs.getString("admin_firstname"),
                        rs.getString("admin_lastname"),
                        rs.getString("admin_mail"),
                        rs.getString("admin_phonenumber"),
                        rs.getString("admin_adress"),
                        rs.getString("admin_city"),
                        rs.getString("admin_zip_code"),
                        rs.getString("admin_pnr"),
                        rs.getInt("admin_ID_admin")
                        );
                return innerAdmin;
            }
        }, admin_ID_admin);
    }

    /**
     * Method to display all admin details from database
     **/

    public ArrayList<AdminDetails> showAllAdminDetails() {
        String query = "SELECT * FROM admin_details;";
        ArrayList<AdminDetails> adminDetailsList = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows) {
            AdminDetails adminDetails = new AdminDetails(
                    String.valueOf(row.get("admin_firstname")),
                    String.valueOf(row.get("admin_lastname")),
                    String.valueOf(row.get("admin_mail")),
                    String.valueOf(row.get("admin_phonenumber")),
                    String.valueOf(row.get("admin_adress")),
                    String.valueOf(row.get("admin_city")),
                    String.valueOf(row.get("admin_zip_code")),
                    String.valueOf(row.get("admin_pnr")),
                    (int) (long) row.get("ID_admin"));
                adminDetailsList.add(adminDetails);
        }
        adminDetailsList.sort(Comparator.comparing(AdminDetails::getAdmin_firstname));
        return adminDetailsList;
    }
}







