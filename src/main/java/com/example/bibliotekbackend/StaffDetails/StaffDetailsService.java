package com.example.bibliotekbackend.StaffDetails;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class StaffDetailsService {

    @Autowired
    StaffDetailsDao staffDetailsDao;
    ArrayList<StaffDetails> staffDetailsList;
    StaffDetails staffDetails;



    public Map insertStaffDetails(StaffDetails staffDetails) {
        return staffDetailsDao.insertStaffDetails(staffDetails.getStaff_firstname(), staffDetails.getStaff_lastname(), staffDetails.getStaff_mail(), staffDetails.getStaff_phonenumber(), staffDetails.getStaff_adress(), staffDetails.getStaff_city(), staffDetails.getStaff_zip_code(), staffDetails.getStaff_pnr(), staffDetails.getStaff_ID_staff());
    }

    public void updateStaffDetails(int staff_ID_staff, String staff_firstname, String staff_lastname, String staff_mail, String staff_phonenumber, String staff_adress, String staff_city, String staff_zip_code, String staff_pnr) {
        staffDetailsDao.updateStaffDetails(staff_ID_staff, staff_firstname, staff_lastname, staff_mail, staff_phonenumber, staff_adress, staff_city, staff_zip_code, staff_pnr);

    }

    public void deleteStaffDetails(int staff_ID_staff) {
        staffDetailsDao.deleteStaffDetails(staff_ID_staff);
    }

    public String ShowStaffDetailsByID(int staff_ID_staff) {
        Gson gson = new Gson();
        staffDetails = staffDetailsDao.ShowStaffDetailsByID(staff_ID_staff);
        String staffDetailString = gson.toJson(staffDetails);
        return staffDetailString;


    }

    public String showAllStaffDetails() {
        Gson gson = new Gson();
        staffDetailsList = staffDetailsDao.showAllStaffDetails();
        String staffDetailString = gson.toJson(staffDetailsList);
        return staffDetailString;
    }


}
