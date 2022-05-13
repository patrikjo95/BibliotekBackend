package com.example.bibliotekbackend.Admin;

public class Admin {
    private int ID_admin;
    private String admin_username;
    private String admin_password;

    public Admin(int ID_admin, String admin_username, String admin_password) {
        this.ID_admin = ID_admin;
        this.admin_username = admin_username;
        this.admin_password = admin_password;
    }

    public Admin(String admin_username, String admin_password) {
        this.admin_username = admin_username;
        this.admin_password = admin_password;
    }

    public int getID_admin() {
        return ID_admin;
    }

    public void setID_admin(int ID_admin) {
        this.ID_admin = ID_admin;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "ID_admin=" + ID_admin +
                ", admin_username='" + admin_username + '\'' +
                ", admin_password='" + admin_password + '\'' +
                '}';
    }
}
