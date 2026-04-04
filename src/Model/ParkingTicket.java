package Model;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.Temporal;

public class ParkingTicket {
    private String id;

    private Vehicle vehicle;

    private ParkingSpot parkingSpot;

    boolean isActive;

    private Instant entryTime;

    private Instant exitTime;

    public ParkingTicket(String id, Vehicle vehicle, ParkingSpot parkingSpot, Instant entryTime) {
        this.id = id;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
        this.isActive = true;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    public Instant getEntryTime() {
        return this.entryTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setEntryTime(Instant entryTime) {
        this.entryTime = entryTime;
    }

    public Instant getExitTime() {
        return exitTime;
    }

    public void setExitTime(Instant exitTime) {
        this.exitTime = exitTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
