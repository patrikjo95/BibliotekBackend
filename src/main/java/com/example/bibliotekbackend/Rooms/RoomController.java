package com.example.bibliotekbackend.Rooms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * Sends request to insert a new room to database
     */
    @PostMapping("/insertRoom")
    public void insertRoom(@RequestParam(value = "room_name", defaultValue = "noRoom_name") String room_name) {
        roomService.insertRoom(room_name);
    }

    /**
     * Sends request to update a new room in the database, specify ID
     */
    @PostMapping("/updateRoom")
    public void updateRoom(@RequestParam(value = "ID_room", defaultValue = "0") int ID_room,
                           @RequestParam(value = "room_name", defaultValue = "noRoom_name") String room_name) {
        roomService.updateRoom(ID_room, room_name);
    }

    /**
     * Sends request to delete a room from database by ID
     */
    @DeleteMapping("/deleteRoomByID")
    public void deleteRoom(@RequestParam(value = "ID_room", defaultValue = "-1") int ID_room) {
        roomService.deleteRoom(ID_room);
    }

    /**
     * Sends request to download one room from database by ID
     */
    @GetMapping("/downloadOneRoom")
    public String downloadOneRoom(@RequestParam(value = "ID_room", defaultValue = "-1") int ID_room) {
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
}
