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


    public Map scan_mail_and_password_admin(Admin admin) {
        return adminDao.scan_mail_and_password_admin(admin.getAdmin_username(), admin.getAdmin_password());
    }

}
