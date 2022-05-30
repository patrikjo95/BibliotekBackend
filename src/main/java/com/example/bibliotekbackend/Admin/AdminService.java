package com.example.bibliotekbackend.Admin;

import com.example.bibliotekbackend.Customer.Customer;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    AdminDao adminDao;

    Admin admin;

    ArrayList<Admin> adminList;

    /**
     * @param ID_admin
     * @return gson String regarding info about one admin, based on ID, sends it to DAO class.
     */
    public String downloadOneAdmin(int ID_admin) {
        Gson gson = new Gson();
        admin = adminDao.downloadOneAdminByID(ID_admin);
        String adminString = gson.toJson(admin);
        return adminString;
    }

    public String downloadAdminByUsername(String admin_username) {
        return adminDao.downloadAdminByUsername(admin_username);
    }

    /**
     * @return gson String with information regarding all admin, sends it to DAO class.
     */
    public String downloadAllAdmin() {
        adminList = adminDao.downloadAllAdmin();
        Gson gson = new Gson();
        String adminListString = gson.toJson(adminList);
        return adminListString;
    }

    public Map scan_mail_and_password_admin(Admin admin) {
        return adminDao.scan_mail_and_password_admin(admin.getAdmin_username(), admin.getAdmin_password());
    }

}
