package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Hotel {
    private List<Room> rooms = new ArrayList<Room>();
    private String name;

    public Hotel(String name) {
        this.name = name;
    }

    /**
     * Makes a booking in any available room with the given preferences.
     *
     * @param arrival
     * @param departure
     * @param standard - does the client want a standard room?
     * @param ensuite - does the client want an ensuite room?
     * @param penthouse - does the client want a penthouse room?
     * @return If there were no available rooms for the given preferences, returns false.
     * Returns true if the booking was successful
     */
    public boolean makeBooking(LocalDate arrival, LocalDate departure, boolean standard, boolean ensuite,
            boolean penthouse) {
        for (Room room : rooms) {
            if (roomDesired(room, standard, ensuite, penthouse) && room.book(arrival, departure) != null) {
                return true;
            }
        }

        return false;
    }

    private boolean roomDesired(Room room, boolean standard, boolean ensuite, boolean penthouse) {
        if (room instanceof StandardRoom) return standard;
        if (room instanceof EnsuiteRoom) return ensuite;
        if (room instanceof PenthouseRoom) return penthouse;
        return false;
    }

    /**
     * @return A JSON Object of the form:
     * { "name": name, "rooms": [ each room as a JSON object, in order of creation ]}
     */
    public JSONObject toJSON() {
        JSONObject hotel = new JSONObject();
        hotel.put("name", name);
        JSONArray roomArray = new JSONArray();
        for (Room r: rooms) {
            roomArray.put(r.toJSON());
        }
        hotel.put("rooms", roomArray);
        return hotel;
    }

    public String getName() {
        return name;
    }

    public void addRoom(String roomType) {
        Room room = null;

        switch (roomType) {
        case "standard":
            room = new StandardRoom();
            break;
        case "ensuite":
            room = new EnsuiteRoom();
            break;
        case "penthouse":
            room = new PenthouseRoom();
            break;
        default:
            break;
        }

        rooms.add(room);
    }
}
