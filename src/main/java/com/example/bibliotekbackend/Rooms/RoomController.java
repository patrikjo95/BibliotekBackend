package com.example.bibliotekbackend.Rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @Autowired
    RoomService roomsService;

}