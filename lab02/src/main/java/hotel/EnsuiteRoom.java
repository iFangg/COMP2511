package hotel;

import org.json.JSONObject;

public class EnsuiteRoom extends Room {
    @Override
    public JSONObject toJSON() {
        JSONObject ensuiteRooms = super.toJSON();
        ensuiteRooms.put("type", "ensuite");
        return ensuiteRooms;
    }

    @Override
    public void printWelcomeMessage() {
        System.out
                .println("Welcome to your beautiful ensuite room which overlooks the Sydney harbour. Enjoy your stay");
    }

}
