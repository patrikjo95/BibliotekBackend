package com.example.bibliotekbackend.AdminDetails;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AdminDetailsController {

    @Autowired
    AdminDetailsService adminDetailsService;

    public AdminDetailsController(AdminDetailsService adminDetailsService) {
        this.adminDetailsService = adminDetailsService;
    }

    /**
     * Sends request to insert details for one admin to database
     */

    @GetMapping("/insertAdminDetails")
    public String insertAdminDetails(
                    @RequestParam(value = "admin_firstname") String admin_firstname,
                    @RequestParam(value = "admin_lastname") String admin_lastname,
                    @RequestParam(value = "admin_mail") String admin_mail,
                    @RequestParam(value = "admin_phonenumber") String admin_phonenumber,
                    @RequestParam(value = "admin_adress") String admin_adress,
                    @RequestParam(value = "admin_city") String admin_city,
                            @RequestParam(value = "admin_zip_code") String admin_zip_code,
                            @RequestParam(value = "admin_pnr") String admin_pnr,
                            @RequestParam(value = "admin_ID_admin") int admin_ID_admin

    ) {
        AdminDetails adminDetails = new AdminDetails(admin_firstname, admin_lastname, admin_mail, admin_phonenumber, admin_adress, admin_city, admin_zip_code, admin_pnr, admin_ID_admin);

        System.out.println("Controller" + adminDetails);

        Map outParameters = adminDetailsService.insertAdminDetails(adminDetails);

        Gson gson = new Gson();

        return gson.toJson(outParameters);

    }

    /**
     * Sends request to update a admin details in the database, specify ID
     */

    @PostMapping("/updateAdminDetails")
    public void updateAdminDetails(
            @RequestParam(value = "admin_ID_admin", defaultValue = "0" ) int admin_ID_admin,
            @RequestParam(value = "admin_firstname") String admin_firstname,
            @RequestParam(value = "admin_lastname") String admin_lastname,
            @RequestParam(value = "admin_mail") String admin_mail,
            @RequestParam(value = "admin_phonenumber") String admin_phonenumber,
            @RequestParam(value = "admin_adress") String admin_adress,
            @RequestParam(value = "admin_city") String admin_city,
            @RequestParam(value = "admin_zip_code") String admin_zip_code,
            @RequestParam(value = "admin_pnr") String admin_pnr

    ) {
        adminDetailsService.updateAdminDetails(admin_ID_admin, admin_firstname, admin_lastname, admin_mail, admin_phonenumber, admin_adress, admin_city, admin_zip_code, admin_pnr);
    }

    /**
     * Sends request to delete admin details from database by ID
     */

    @DeleteMapping("/deleteAdminDetails")
    public void deleteAdminDetails(
            @RequestParam(value = "Admin_ID_admin", defaultValue = "-1") int Admin_ID_admin) {
        adminDetailsService.deleteAdminDetails(Admin_ID_admin);
    }

    /**
     * Sends request to display details about one admin from database by ID
     */

    @GetMapping("/ShowAdminDetailsByID")
    public String ShowAdminDetailsByID(@RequestParam(value = "admin_ID_admin", defaultValue = "-1") int admin_ID_admin) {
        return adminDetailsService.ShowAdminDetailsByID(admin_ID_admin);
    }

    /**
     * Sends request to display all admin details from database by ID
     */

    @GetMapping("/ShowAllAdminDetails")
    public String ShowAllAdminDetails() {
        return adminDetailsService.showAllAdminDetails();
    }

}
