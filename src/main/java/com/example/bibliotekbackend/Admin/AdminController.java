package com.example.bibliotekbackend.Admin;

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
     * Sends request to insert a new admin to database
     */
    @GetMapping("/insertAdmin")
    public String insertAdmin(
            @RequestParam(value = "new_admin_username") String admin_username,
            @RequestParam(value = "new_admin_password") String admin_password
    ) {
        Admin admin = new Admin(admin_username, admin_password);

        System.out.println("Controller" + admin); // ??

        Map outParameters = adminService.insertAdmin(admin);

        Gson gson = new Gson();

        return gson.toJson(outParameters);

        //bookService.insertBook(book_title, book_qty, book_author, book_genre, book_year, book_URL);
    }

    /**
     * Sends request to update a new admin in the database, specify ID
     */
    @PostMapping("/updateAdmin")
    public void updateAdmin(@RequestParam(value = "ID_admin", defaultValue = "0") int ID_admin,
                            @RequestParam(value = "new_admin_username") String admin_username,
                            @RequestParam(value = "new_admin_password") String admin_password
    ) {
        adminService.updateAdmin(ID_admin, admin_username, admin_password);
    }

    /**
     * Sends request to delete a admin from database by ID
     */
    @DeleteMapping("/deleteAdminByID")
    public void deleteAdmin(@RequestParam(value = "ID_admin", defaultValue = "-1") int ID_admin) {
        adminService.deleteAdmin(ID_admin);
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

}
