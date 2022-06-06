package com.example.bibliotekbackend.Rooms;

import com.example.bibliotekbackend.Books.Book;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Data access object for rooms table in database
 */
@Repository
public class RoomDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String error;

    public RoomDao() {
        this.error = "no";
        this.jdbcTemplate = new JdbcTemplate();
    }

/**
 * SELECT A ROOM
 */
//public static Room searchRoom(String ID_room) throws SQLException, ClassNotFoundException {
    //String selectStmt = "SELECT * FROM rooms WHERE ID_room" = +ID_room;

    //Execute SELECT statement


    /**
     * method to insert a new room into the database
     */
//    public void insertRoom(String room_name) {
//         String query = "INSERT INTO rooms VALUES(null, ?);";
//
//
//        String result = jdbcTemplate.update(query, room_name);
//
//        if (result > 0) {
//            System.out.println(result + " room added to database");
//            this.error = "room added to database";
//        }
//    }

    /**
     * updates a room in database by ID
     */
    public void updateRoom(String ID_room, String room_name) {

        String query = "UPDATE rooms SET room_name = ? WHERE ID_room = ?;";

        int result = jdbcTemplate.update(query, room_name, ID_room);

        if (result > 0) {
            System.out.println(result + " room updated in database");
            this.error = "room updated in database";
        }
    }



    /**
     * gets one room from the database by id
     */
    public Room downloadOneRoomByID(String ID_room) {

        String query = "SELECT * FROM rooms WHERE ID_room = ?;";

        return this.jdbcTemplate.queryForObject(query, new RowMapper<Room>() {
            @Override
            public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
                Room innerRoom = new Room(
                        rs.getString("ID_room"),
                        rs.getString("room_name")
                );
                return innerRoom;
            }
        }, ID_room);
    }

    /**
     * gets one room from the database by room_name
     */
    public String downloadOneRoomByName(String room_name) {
        Gson gson = new Gson();
        String query = "SELECT * FROM rooms WHERE room_name = ?;";
        Room temp = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Room(
                rs.getString("ID_room"),
                rs.getString("room_name")), room_name);
        return gson.toJson(temp);
    }

    /**
     * downloads all rooms from the database
     * @return ArrayList<Room>
     */
    public ArrayList<Room> downloadAllRooms() {
        String query = "SELECT * FROM rooms;";
        ArrayList<Room> rooms = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows) {
            Room room = new Room(
                    String.valueOf(row.get("ID_room")),
                    String.valueOf(row.get("room_name")));
            rooms.add(room);

        }
        rooms.sort(Comparator.comparing(Room::getRoom_name));
        return rooms;
    }



    public Map one_month_calender() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("one_month_calender");

        //Map<String,String> inParameters = new HashMap<>();

        SqlParameterSource in = new MapSqlParameterSource();

        Map<String, Object> outParameters = jdbcCall.execute();


        return outParameters;

    }



    public Map Room_calender(String room_name_live) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("Room_Calender");

        Map<String,String> inParameters = new HashMap<>();

        inParameters.put("room_name_live", room_name_live);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        Map<String,Object> outParameters = jdbcCall.execute(in);



        return outParameters;

    }

    public Map pick_a_room(String room_name_live,String date_pick,String time_in, String customer_pnr_live) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("pick_a_room");

        Map<String,Integer> inParameters = new HashMap<>();

        Room room = new Room(room_name_live,date_pick,time_in,customer_pnr_live);

        SqlParameterSource in = new MapSqlParameterSource(inParameters);

        Map<String,Object> outParameters = jdbcCall.execute(in);


        room.setRoom_name_live(room_name_live);
        room.setDate_pick(date_pick);
        room.setTime_in(time_in);
        room.setCustomer_pnr_live(customer_pnr_live);

        return outParameters;

    }


}
