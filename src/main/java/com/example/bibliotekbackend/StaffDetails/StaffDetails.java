package com.example.bibliotekbackend.StaffDetails;

public class StaffDetails {
    private String staff_firstname;
    private String staff_lastname;
    private String staff_mail;
    private String staff_phonenumber;
    private String staff_adress;
    private String staff_city;
    private String staff_zip_code;
    private String staff_pnr;
    private int staff_ID_staff;

    public StaffDetails(String staff_firstname, String staff_lastname, String staff_mail, String staff_phonenumber, String staff_adress, String staff_city, String staff_zip_code, String staff_pnr, int staff_ID_staff) {
        this.staff_firstname = staff_firstname;
        this.staff_lastname = staff_lastname;
        this.staff_mail = staff_mail;
        this.staff_phonenumber = staff_phonenumber;
        this.staff_adress = staff_adress;
        this.staff_city = staff_city;
        this.staff_zip_code = staff_zip_code;
        this.staff_pnr = staff_pnr;
        this.staff_ID_staff = staff_ID_staff;
    }

    public String getStaff_firstname() {
        return staff_firstname;
    }

    public void setStaff_firstname(String staff_firstname) {
        this.staff_firstname = staff_firstname;
    }

    public String getStaff_lastname() {
        return staff_lastname;
    }

    public void setStaff_lastname(String staff_lastname) {
        this.staff_lastname = staff_lastname;
    }

    public String getStaff_mail() {
        return staff_mail;
    }

    public void setStaff_mail(String staff_mail) {
        this.staff_mail = staff_mail;
    }

    public String getStaff_phonenumber() {
        return staff_phonenumber;
    }

    public void setStaff_phonenumber(String staff_phonenumber) {
        this.staff_phonenumber = staff_phonenumber;
    }

    public String getStaff_adress() {
        return staff_adress;
    }

    public void setStaff_adress(String staff_adress) {
        this.staff_adress = staff_adress;
    }

    public String getStaff_city() {
        return staff_city;
    }

    public void setStaff_city(String staff_city) {
        this.staff_city = staff_city;
    }

    public String getStaff_zip_code() {
        return staff_zip_code;
    }

    public void setStaff_zip_code(String staff_zip_code) {
        this.staff_zip_code = staff_zip_code;
    }

    public String getStaff_pnr() {
        return staff_pnr;
    }

    public void setStaff_pnr(String staff_pnr) {
        this.staff_pnr = staff_pnr;
    }

    public int getStaff_ID_staff() {
        return staff_ID_staff;
    }

    public void setStaff_ID_staff(int staff_ID_staff) {
        this.staff_ID_staff = staff_ID_staff;
    }

    @Override
    public String toString() {
        return "StaffDetails{" +
                "staff_firstname='" + staff_firstname + '\'' +
                ", staff_lastname='" + staff_lastname + '\'' +
                ", staff_mail='" + staff_mail + '\'' +
                ", staff_phonenumber='" + staff_phonenumber + '\'' +
                ", staff_adress='" + staff_adress + '\'' +
                ", staff_city='" + staff_city + '\'' +
                ", staff_zip_code='" + staff_zip_code + '\'' +
                ", staff_pnr='" + staff_pnr + '\'' +
                ", staff_ID_staff=" + staff_ID_staff +
                '}';
    }
}
