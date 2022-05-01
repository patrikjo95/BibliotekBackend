package com.example.bibliotekbackend.Rooms;

public class Room {
    private int ID_room;
    private String room_name;


    public Room(int ID_room, String room_name) {
        this.ID_room = ID_room;
        this.room_name = room_name;
    }

    public int getID_room() {
        return ID_room;
    }

    public void setID_room(int ID_room) {
        this.ID_room = ID_room;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "ID_room=" + ID_room +
                ", room_name='" + room_name + '\'' +
                '}';
    }
}
