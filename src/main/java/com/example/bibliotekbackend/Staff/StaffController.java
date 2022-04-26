package com.example.bibliotekbackend.Staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {

    @Autowired
    StaffService staffService;


}
