package com.example.bibliotekbackend.CustomerDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerDetailsController {

    @Autowired
    CustomerDetailsService customerDetailsService;


}
