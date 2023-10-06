package hotel;

import org.json.JSONObject;

public class PenthouseRoom extends Room {
    @Override
    public JSONObject toJSON() {
        JSONObject penthouseRooms = super.toJSON();
        penthouseRooms.put("type", "penthouse");
        // System.out.println(obj.toString(2));
        return penthouseRooms;
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println(
                "Welcome to your penthouse apartment, complete with ensuite, lounge, kitchen and master bedroom.");
    }

}
