package com.example.bibliotekbackend.Rooms;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }



    /**
     * Sends request to update a new room in the database, specify ID
     */
    @PostMapping("/updateRoom")
    public void updateRoom(@RequestParam(value = "ID_room", defaultValue = "0") String ID_room,
                           @RequestParam(value = "room_name", defaultValue = "noRoom_name") String room_name) {
        roomService.updateRoom(ID_room, room_name);
    }



    /**
     * Sends request to download one room from database by ID
     */
    @GetMapping("/downloadOneRoom")
    public String downloadOneRoom(@RequestParam(value = "ID_room", defaultValue = "-1") String ID_room) {
        return roomService.downloadOneRoomByID(ID_room);
    }

    @GetMapping("/downloadRoomByName")
    public String downloadRoomByName(@RequestParam(value = "room_name", defaultValue = "noRoom_name") String room_name) {
        return roomService.downloadOneRoomByName(room_name);
    }

    /**
     * Sends request to download all rooms from database by ID
     */
    @GetMapping("/downloadAllRooms")
    public String downloadAllRooms() {
        return roomService.downloadAllRooms();
    }

    @GetMapping ("/one_month_calender")
    public String one_month_calender() {

        Map outParameters = roomService.one_month_calender();

        Gson gson = new Gson();
        return gson.toJson(outParameters);
    }

    @GetMapping ("/Room_calender")
    public String Room_calender(@RequestParam(value = "room_name_live")String room_name_live
    ) {
        Room room = new Room(room_name_live);
        Map outParameters = roomService.Room_calender(room_name_live);

        Gson gson = new Gson();
        return gson.toJson(outParameters);
        
    }

    @GetMapping ("/pick_a_room")
    public String pick_a_room(@RequestParam(value = "room_name_live")String room_name_live,
                              @RequestParam(value = "date_pick") String date_pick,
                              @RequestParam(value = "time_in") String time_in,
                              @RequestParam(value = "customer_id")String customer_id) {
        Room room = new Room(room_name_live,date_pick,time_in,customer_id);
        Map outParameters = roomService.pick_a_room(room);

        Gson gson = new Gson();
        return gson.toJson(outParameters);
    }




}
