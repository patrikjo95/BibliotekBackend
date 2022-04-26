package com.example.bibliotekbackend.StaffDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffDetailsController {

    @Autowired
    StaffDetailsService staffDetailsService;


}
