package com.example.bibliotekbackend.Staff;

public class Staff {
    private int ID_staff;
    private String staff_username;
    private String staff_password;

    public Staff(int ID_staff, String staff_username, String staff_password) {
        this.ID_staff = ID_staff;
        this.staff_username = staff_username;
        this.staff_password = staff_password;
    }

    public Staff(String staff_username, String staff_password) {
        this.staff_username = staff_username;
        this.staff_password = staff_password;
    }

    public int getID_staff() {
        return ID_staff;
    }

    public void setID_staff(int ID_staff) {
        this.ID_staff = ID_staff;
    }

    public String getStaff_username() {
        return staff_username;
    }

    public void setStaff_username(String staff_username) {
        this.staff_username = staff_username;
    }

    public String getStaff_password() {
        return staff_password;
    }

    public void setStaff_password(String staff_password) {
        this.staff_password = staff_password;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "ID_staff=" + ID_staff +
                ", staff_username='" + staff_username + '\'' +
                ", staff_password='" + staff_password + '\'' +
                '}';
    }
}
