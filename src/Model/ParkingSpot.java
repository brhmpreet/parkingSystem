package Model;

import Enums.VehicleType;

import java.util.UUID;

public class ParkingSpot {
    private String id;
    private boolean isEmpty;
    private VehicleType vehicleType;

    public ParkingSpot(String id, boolean isEmpty, VehicleType vehicleType) {
        this.id = id;
        this.isEmpty = isEmpty;
        this.vehicleType = vehicleType;
    }

    public ParkingSpot(VehicleType type){
        this.id = UUID.randomUUID().toString();
        this.isEmpty = true;
        this.vehicleType = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
