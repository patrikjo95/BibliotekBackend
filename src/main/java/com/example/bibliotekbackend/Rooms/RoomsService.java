package com.example.bibliotekbackend.Rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomsService {

    @Autowired
    RoomsDao roomsDao;
}
