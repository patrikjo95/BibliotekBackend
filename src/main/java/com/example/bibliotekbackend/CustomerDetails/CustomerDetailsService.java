package com.example.bibliotekbackend.CustomerDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService {

    @Autowired
    CustomerDetailsDao customerDetailsDao;

}
