package com.example.bibliotekbackend.StaffDetails;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class StaffDetailsController {

    @Autowired
    StaffDetailsService staffDetailsService;

    public StaffDetailsController(StaffDetailsService staffDetailsService) {
        this.staffDetailsService = staffDetailsService;
    }


    @GetMapping("/insertStaffDetails")
    public String insertStaffDetails(
                    @RequestParam(value = "new_staff_firstname") String staff_firstname,
                    @RequestParam(value = "new_staff_lastname") String staff_lastname,
                    @RequestParam(value = "new_staff_mail") String staff_mail,
                    @RequestParam(value = "new_staff_phonenumber") String staff_phonenumber,
                    @RequestParam(value = "new_staff_adress") String staff_adress,
                    @RequestParam(value = "new_staff_city") String staff_city,
                            @RequestParam(value = "new_staff_zip_code") String staff_zip_code,
                            @RequestParam(value = "new_staff_pnr") String staff_pnr,
                            @RequestParam(value = "new_staff_ID_staff") int staff_ID_staff

    ) {
        StaffDetails staffDetails = new StaffDetails(staff_firstname, staff_lastname, staff_mail, staff_phonenumber, staff_adress, staff_city, staff_zip_code, staff_pnr, staff_ID_staff);

        System.out.println("Controller" + staffDetails);

        Map outParameters = staffDetailsService.insertStaffDetails(staffDetails);

        Gson gson = new Gson();

        return gson.toJson(outParameters);

    }

    @PostMapping("/updateStaffDetails")
    public void updateStaffDetails(
            @RequestParam(value = "new_staff_ID_staff", defaultValue = "0" ) int staff_ID_staff,
            @RequestParam(value = "new_staff_firstname") String staff_firstname,
            @RequestParam(value = "new_staff_lastname") String staff_lastname,
            @RequestParam(value = "new_staff_mail") String staff_mail,
            @RequestParam(value = "new_staff_phonenumber") String staff_phonenumber,
            @RequestParam(value = "new_staff_adress") String staff_adress,
            @RequestParam(value = "new_staff_city") String staff_city,
            @RequestParam(value = "new_staff_zip_code") String staff_zip_code,
            @RequestParam(value = "new_staff_pnr") String staff_pnr

    ) {
        staffDetailsService.updateStaffDetails(staff_ID_staff, staff_firstname, staff_lastname, staff_mail, staff_phonenumber, staff_adress, staff_city, staff_zip_code, staff_pnr);
    }

    @DeleteMapping("/deleteStaffDetails")
    public void deleteStaffDetails(
            @RequestParam(value = "staff_ID_staff", defaultValue = "-1") int staff_ID_staff) {
        staffDetailsService.deleteStaffDetails(staff_ID_staff);
    }

    @GetMapping("/ShowStaffDetailsByID")
    public String ShowStaffDetailsByID(@RequestParam(value = "staff_ID_staff", defaultValue = "-1") int staff_ID_staff) {
        return staffDetailsService.ShowStaffDetailsByID(staff_ID_staff);
    }

    @GetMapping("/ShowAllStaffDetails")
    public String ShowAllStaffDetails() {
        return staffDetailsService.showAllStaffDetails();
    }

}
