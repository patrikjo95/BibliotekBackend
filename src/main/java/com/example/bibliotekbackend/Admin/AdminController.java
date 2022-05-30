package com.example.bibliotekbackend.Admin;

import com.example.bibliotekbackend.Customer.Customer;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * Sends request to download one admin from database by ID
     */
    @GetMapping("/downloadOneAdmin")
    public String downloadOneAdmin(@RequestParam(value = "ID_admin", defaultValue = "-1") int ID_admin) {
        return adminService.downloadOneAdmin(ID_admin);
    }

    /**
     * Sends request to download all admin from database by ID
     */
    @GetMapping("/downloadAllAdmin")
    public String downloadAllAdmin() {
        return adminService.downloadAllAdmin();
    }

    @GetMapping("/downloadAdminByUsername")
    public String downloadAdminByUsername(@RequestParam(value = "new_admin_username") String admin_username) {
        return adminService.downloadAdminByUsername(admin_username);
    }

    @GetMapping("/scan_mail_and_password_admin")
    public String scan_mail_and_password_admin(@RequestParam(value = "test_mail") String admin_username,
                                               @RequestParam(value = "test_password") String admin_password) {
        Admin admin = new Admin(admin_username, admin_password);
        System.out.println("Controller " + admin);
        Map outParameters = adminService.scan_mail_and_password_admin(admin);
        Gson gson = new Gson();
        return gson.toJson(outParameters);
    }
}