package com.example.bibliotekbackend.AdminDetails;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class AdminDetailsService {

    @Autowired
    AdminDetailsDao adminDetailsDao;
    ArrayList<AdminDetails> adminDetailsList;
    AdminDetails adminDetails;


    /**
     * Sends information to DAO class for inserting details for one admin
     */
    public Map insertAdminDetails(AdminDetails adminDetails) {
        return adminDetailsDao.insertAdminDetails(adminDetails.getAdmin_firstname(), adminDetails.getAdmin_lastname(), adminDetails.getAdmin_mail(), adminDetails.getAdmin_phonenumber(), adminDetails.getAdmin_adress(), adminDetails.getAdmin_city(), adminDetails.getAdmin_zip_code(), adminDetails.getAdmin_pnr(), adminDetails.getAdmin_ID_admin());
    }

    /**
     * Sends information to DAO class for updating details for one admin
     */

    public void updateAdminDetails(int admin_ID_admin, String admin_firstname, String admin_lastname, String admin_mail, String admin_phonenumber, String admin_adress, String admin_city, String admin_zip_code, String admin_pnr) {
        adminDetailsDao.updateAdminDetails(admin_ID_admin, admin_firstname, admin_lastname, admin_mail, admin_phonenumber, admin_adress, admin_city, admin_zip_code, admin_pnr);

    }

    /**
     * Sends information to DAO class for deleting details of one admin using admin_ID_admin
     */

    public void deleteAdminDetails(int admin_ID_admin) {
        adminDetailsDao.deleteAdminDetails(admin_ID_admin);
    }

    /**
     * @param admin_ID_admin
     * @return gson String regarding details info about one admin, based on ID, sends it to DAO class.
     */

    public String ShowAdminDetailsByID(int admin_ID_admin) {
        Gson gson = new Gson();
        adminDetails = adminDetailsDao.ShowAdminDetailsByID(admin_ID_admin);
        String adminDetailString = gson.toJson(adminDetails);
        return adminDetailString;


    }

    /**
     * @return gson String with information regarding all admin details, sends it to DAO class.
     */

    public String showAllAdminDetails() {
        Gson gson = new Gson();
        adminDetailsList = adminDetailsDao.showAllAdminDetails();
        String adminDetailString = gson.toJson(adminDetailsList);
        return adminDetailString;
    }


}
