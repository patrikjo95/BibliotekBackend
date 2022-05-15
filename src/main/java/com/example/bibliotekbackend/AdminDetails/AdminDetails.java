package com.example.bibliotekbackend.AdminDetails;

public class AdminDetails {
    private String admin_firstname;
    private String admin_lastname;
    private String admin_mail;
    private String admin_phonenumber;
    private String admin_adress;
    private String admin_city;
    private String admin_zip_code;
    private String admin_pnr;
    private int admin_ID_admin;

    public AdminDetails(String admin_firstname, String admin_lastname, String admin_mail, String admin_phonenumber, String admin_adress, String admin_city, String admin_zip_code, String admin_pnr, int admin_ID_admin) {
        this.admin_firstname = admin_firstname;
        this.admin_lastname = admin_lastname;
        this.admin_mail = admin_mail;
        this.admin_phonenumber = admin_phonenumber;
        this.admin_adress = admin_adress;
        this.admin_city = admin_city;
        this.admin_zip_code = admin_zip_code;
        this.admin_pnr = admin_pnr;
        this.admin_ID_admin = admin_ID_admin;
    }

    public String getAdmin_firstname() {
        return admin_firstname;
    }

    public void setAdmin_firstname(String admin_firstname) {
        this.admin_firstname = admin_firstname;
    }

    public String getAdmin_lastname() {
        return admin_lastname;
    }

    public void setAdmin_lastname(String admin_lastname) {
        this.admin_lastname = admin_lastname;
    }

    public String getAdmin_mail() {
        return admin_mail;
    }

    public void setAdmin_mail(String admin_mail) {
        this.admin_mail = admin_mail;
    }

    public String getAdmin_phonenumber() {
        return admin_phonenumber;
    }

    public void setAdmin_phonenumber(String admin_phonenumber) {
        this.admin_phonenumber = admin_phonenumber;
    }

    public String getAdmin_adress() {
        return admin_adress;
    }

    public void setAdmin_adress(String admin_adress) {
        this.admin_adress = admin_adress;
    }

    public String getAdmin_city() {
        return admin_city;
    }

    public void setAdmin_city(String admin_city) {
        this.admin_city = admin_city;
    }

    public String getAdmin_zip_code() {
        return admin_zip_code;
    }

    public void setAdmin_zip_code(String admin_zip_code) {
        this.admin_zip_code = admin_zip_code;
    }

    public String getAdmin_pnr() {
        return admin_pnr;
    }

    public void setAdmin_pnr(String admin_pnr) {
        this.admin_pnr = admin_pnr;
    }

    public int getAdmin_ID_admin() {
        return admin_ID_admin;
    }

    public void setAdmin_ID_admin(int admin_ID_admin) {
        this.admin_ID_admin = admin_ID_admin;
    }

    @Override
    public String toString() {
        return "AdminDetails{" +
                "admin_firstname='" + admin_firstname + '\'' +
                ", admin_lastname='" + admin_lastname + '\'' +
                ", admin_mail='" + admin_mail + '\'' +
                ", admin_phonenumber='" + admin_phonenumber + '\'' +
                ", admin_adress='" + admin_adress + '\'' +
                ", admin_city='" + admin_city + '\'' +
                ", admin_zip_code='" + admin_zip_code + '\'' +
                ", admin_pnr='" + admin_pnr + '\'' +
                ", admin_ID_admin=" + admin_ID_admin +
                '}';
    }
}
