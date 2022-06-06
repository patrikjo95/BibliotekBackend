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
     * scans the mail and password input from the frontend and checks it with the decrypted table in DB
     * @param admin_username
     * @param admin_password
     * @return
     */
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