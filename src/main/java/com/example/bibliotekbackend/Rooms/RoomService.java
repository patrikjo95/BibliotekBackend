package com.example.bibliotekbackend.Rooms;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class RoomService {

    @Autowired
    RoomDao roomDao;

    Room room;

    ArrayList<Room> rooms;
    public Map pick_a_room(Room room) {return roomDao.pick_a_room(room.getRoom_name_live(),room.getDate_pick(),room.getTime_in(),room.getCustomer_pnr_live());}
    public Map Room_calender(String room)
    {return roomDao.Room_calender(room);}

    public Map one_month_calender() {return roomDao.one_month_calender();
    }

    //public Map one_month_calender(Room room) {return roomDao.one_month_calender();
   // }





    /**
     * Sends information to DAO class for updating one room.
     */
    public void updateRoom(String ID_room, String room_name) {
        roomDao.updateRoom(ID_room, room_name);
    }


    /**
     * @param ID_room
     * @return gson String regarding info about one room, based on ID, sends it to DAO class.
     */
    public String downloadOneRoomByID(String ID_room) {
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
