package Model;

import Enums.VehicleType;

public class Vehicle {
    private String id;
    private VehicleType type;

    private String registrationId;

    public Vehicle(String id, VehicleType type, String registrationId) {
        this.id = id;
        this.type = type;
        this.registrationId = registrationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
}
