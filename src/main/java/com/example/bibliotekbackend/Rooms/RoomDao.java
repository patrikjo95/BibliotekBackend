package com.example.bibliotekbackend.Rooms;

import com.example.bibliotekbackend.Books.Book;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

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
     * method to insert a new room into the database
     */
    public void insertRoom(String room_name) {
        String query = "INSERT INTO rooms VALUES(null, ?);";

        int result = jdbcTemplate.update(query, room_name);

        if (result > 0) {
            System.out.println(result + " room added to database");
            this.error = "room added to database";
        }
    }

    /**
     * updates a room in database by ID
     */
    public void updateRoom(int ID_room, String room_name) {

        String query = "UPDATE rooms SET room_name = ? WHERE ID_room = ?;";

        int result = jdbcTemplate.update(query, room_name, ID_room);

        if (result > 0) {
            System.out.println(result + " room updated in database");
            this.error = "room updated in database";
        }
    }

    /**
     * method to delete a room from database using ID
     */
    public void deleteRoom(int ID_room) {

        String query = "DELETE FROM rooms WHERE ID_room = ?;";

        int result = jdbcTemplate.update(query, ID_room);

        if (result > 0) {
            System.out.println(result + " room deleted from database");
            this.error = "room deleted from database";
        }
    }

    /**
     * gets one room from the database by id
     */
    public Room downloadOneRoomByID(int ID_room) {

        String query = "SELECT * FROM rooms WHERE ID_room = ?;";

        return this.jdbcTemplate.queryForObject(query, new RowMapper<Room>() {
            @Override
            public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
                Room innerRoom = new Room(
                        rs.getInt("ID_room"),
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
        String query = "SELECT * FROM books WHERE room_name = ?;";
        Room temp = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Room(
                rs.getInt("ID_room"),
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
                    (int) (long) row.get("ID_book"),
                    String.valueOf(row.get("room_name")));
            rooms.add(room);
        }
        rooms.sort(Comparator.comparing(Room::getRoom_name));
        return rooms;
    }
}
