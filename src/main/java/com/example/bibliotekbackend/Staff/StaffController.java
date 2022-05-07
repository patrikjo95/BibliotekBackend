package com.example.bibliotekbackend.Staff;

import com.example.bibliotekbackend.Books.Book;
import com.example.bibliotekbackend.Books.BookService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class StaffController {

    @Autowired
    StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    /**
     * Sends request to insert a new staff to database
     */
    @GetMapping("/insertStaff")
    public String insertStaff(
            @RequestParam(value = "new_staff_username") String staff_username,
            @RequestParam(value = "new_staff_password") String staff_password
    ) {
        Staff staff = new Staff(staff_username, staff_password);

        System.out.println("Controller" + staff); // ??

        Map outParameters = staffService.insertStaff(staff);

        Gson gson = new Gson();

        return gson.toJson(outParameters);

        //bookService.insertBook(book_title, book_qty, book_author, book_genre, book_year, book_URL);
    }

    /**
     * Sends request to update a new staff in the database, specify ID
     */
    @PostMapping("/updateStaff")
    public void updateStaff(@RequestParam(value = "ID_staff", defaultValue = "0") int ID_staff,
                            @RequestParam(value = "new_staff_username") String staff_username,
                            @RequestParam(value = "new_staff_password") String staff_password
    ) {
        staffService.updateStaff(ID_staff, staff_username, staff_password);
    }

    /**
     * Sends request to delete a staff from database by ID
     */
    @DeleteMapping("/deleteStaffByID")
    public void deleteStaff(@RequestParam(value = "ID_staff", defaultValue = "-1") int ID_staff) {
        staffService.deleteStaff(ID_staff);
    }

    /**
     * Sends request to download one staff from database by ID
     */
    @GetMapping("/downloadOneStaff")
    public String downloadOneStaff(@RequestParam(value = "ID_staff", defaultValue = "-1") int ID_staff) {
        return staffService.downloadOneStaff(ID_staff);
    }

    /**
     * Sends request to download all staff from database by ID
     */
    @GetMapping("/downloadAllStaff")
    public String downloadAllStaff() {
        return staffService.downloadAllStaff();
    }

    @GetMapping("/downloadStaffByUsername")
    public String downloadStaffByUsername(@RequestParam(value = "new_staff_username") String staff_username) {
        return staffService.downloadStaffByUsername(staff_username);
    }

}
