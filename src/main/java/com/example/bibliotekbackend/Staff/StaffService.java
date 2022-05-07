package com.example.bibliotekbackend.Staff;

import com.example.bibliotekbackend.Books.Book;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class StaffService {

    @Autowired
    StaffDao staffDao;

    Staff staff;

    ArrayList<Staff> staffList;

    /**
     * Sends information to DAO class for inserting one new staff.
     */
    public Map insertStaff(Staff staff) {
        return staffDao.insertStaff(staff.getStaff_username(), staff.getStaff_password());
    }

    /**
     * Sends information to DAO class for updating one staff.
     */
    public void updateStaff(int ID_staff, String staff_username, String staff_password) {
        staffDao.updateStaff(ID_staff, staff_username, staff_password);
    }

    /**
     * Sends information to DAO class for deleting one staff using ID_staff
     */
    public void deleteStaff(int ID_staff) {
        staffDao.deleteStaff(ID_staff);
    }

    /**
     * @param ID_staff
     * @return gson String regarding info about one staff, based on ID, sends it to DAO class.
     */
    public String downloadOneStaff(int ID_staff) {
        Gson gson = new Gson();
        staff = staffDao.downloadOneStaffByID(ID_staff);
        String staffString = gson.toJson(staff);
        return staffString;
    }

    public String downloadStaffByUsername(String staff_username) {
        return staffDao.downloadStaffByUsername(staff_username);
    }

    /**
     * @return gson String with information regarding all staff, sends it to DAO class.
     */
    public String downloadAllStaff() {
        staffList = staffDao.downloadAllStaff();
        Gson gson = new Gson();
        String staffListString = gson.toJson(staffList);
        return staffListString;
    }

}
