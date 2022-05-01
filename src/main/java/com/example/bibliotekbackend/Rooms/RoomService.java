package com.example.bibliotekbackend.Rooms;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoomService {

    @Autowired
    RoomDao roomDao;

    Room room;

    ArrayList<Room> rooms;

    /**
     * Sends information to DAO class for inserting one new room.
     */
    public void insertRoom(String room_name) {
        roomDao.insertRoom(room_name);
    }

    /**
     * Sends information to DAO class for updating one room.
     */
    public void updateRoom(int ID_room, String room_name) {
        roomDao.updateRoom(ID_room, room_name);
    }

    /**
     * Sends information to DAO class for deleting one room using ID_room
     */
    public void deleteRoom(int ID_room) {
        roomDao.deleteRoom(ID_room);
    }

    /**
     * @param ID_room
     * @return gson String regarding info about one room, based on ID, sends it to DAO class.
     */
    public String downloadOneRoomByID(int ID_room) {
        Gson gson = new Gson();
        room = roomDao.downloadOneRoomByID(ID_room);
        String roomString = gson.toJson(room);
        return roomString;
    }

    public String downloadOneRoomByName(String room_name) {
        return roomDao.downloadOneRoomByName(room_name);
    }

    /**
     * @return gson String with information regarding all rooms, sends it to DAO class.
     */
    public String downloadAllRooms() {
        rooms = roomDao.downloadAllRooms();
        Gson gson = new Gson();
        String roomListString = gson.toJson(rooms);
        return roomListString;
    }
}
