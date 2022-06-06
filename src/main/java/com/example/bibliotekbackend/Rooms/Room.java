package com.example.bibliotekbackend.Rooms;

public class Room {
    private String room_name_live;
    private String ID_room;
    private String room_name;
    private String date_pick;
    private String time_in;
    private String customer_pnr_live;



    public Room(String ID_room, String room_name) {
        this.ID_room = ID_room;
        this.room_name = room_name;
    }
    public Room( String ID_room) {
        this.ID_room = ID_room;
    }


    public Room(String room_name_live, String date_pick, String time_in, String customer_pnr_live) {
        this.room_name_live = room_name_live;
        this.date_pick = date_pick;
        this.time_in = time_in;
        this.customer_pnr_live = customer_pnr_live;

    }




    public String getID_room() {
        return ID_room;
    }

    public void setID_room(String ID_room) {
        this.ID_room = ID_room;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getRoom_name_live() {return room_name_live;}
    public void setRoom_name_live(String room_name_live) {this.room_name_live = room_name_live;}

    public String getDate_pick() {return date_pick;}
    public void setDate_pick(String date_pick) {this.date_pick = date_pick; }

    public String getTime_in() {return time_in;}
    public void setTime_in(String time_in) { this.time_in = time_in;}

    public String getCustomer_pnr_live() {return customer_pnr_live;}
    public void setCustomer_pnr_live(String customer_pnr_live) {this.customer_pnr_live = customer_pnr_live;}


    @Override
    public String toString() {
        return "Rooms{" +
                "ID_room=" + ID_room +
                ", room_name='" + room_name + '\'' +
                '}';
    }
    }


