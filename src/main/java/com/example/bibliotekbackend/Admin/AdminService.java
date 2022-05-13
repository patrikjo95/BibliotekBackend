package com.example.bibliotekbackend.Admin;

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
     * Sends information to DAO class for inserting one new admin.
     */
    public Map insertAdmin(Admin admin) {
        return adminDao.insertAdmin(admin.getAdmin_username(), admin.getAdmin_password());
    }

    /**
     * Sends information to DAO class for updating one admin.
     */
    public void updateAdmin(int ID_admin, String admin_username, String admin_password) {
        adminDao.updateAdmin(ID_admin, admin_username, admin_password);
    }

    /**
     * Sends information to DAO class for deleting one admin using ID_admin
     */
    public void deleteAdmin(int ID_admin) {
        adminDao.deleteAdmin(ID_admin);
    }

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

}
