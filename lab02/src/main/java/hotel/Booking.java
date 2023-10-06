package hotel;

import java.time.LocalDate;

import org.json.JSONObject;

public class Booking {
    private LocalDate arrival;
    private LocalDate departure;

    public Booking(LocalDate arrival, LocalDate departure) {
        this.arrival = arrival;
        this.departure = departure;
    }

    /**
    * @return a JSONObject of the form {"arrival": arrival, "departure": departure}
    */
    public JSONObject toJSON() {
        JSONObject booking = new JSONObject();
        booking.put("arrival", arrival.toString());
        booking.put("departure", departure.toString());
        return booking;
    }

    /**
     * Checks whether two dates overlap
     * @param start
     * @param end
     */
    public boolean overlaps(LocalDate start, LocalDate end) {
        // identical = true
        // start before arrival and end before arrival = false;
        // start after departure and end after departure = false;
        // every other option overlaps
        if (start.equals(end)) return true;
        if (start.isBefore(arrival) && end.isBefore(arrival)) return false;
        if (start.isAfter(departure) && end.isAfter(departure)) return false;
        return true;
    }

}
