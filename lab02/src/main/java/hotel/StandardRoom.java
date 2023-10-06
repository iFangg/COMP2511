package hotel;

import org.json.JSONObject;

public class StandardRoom extends Room {
    @Override
    public JSONObject toJSON() {
        JSONObject stdRooms = super.toJSON();
        stdRooms.put("type", "standard");
        return stdRooms;
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Welcome to your standard room. Enjoy your stay :)");
    }

}
