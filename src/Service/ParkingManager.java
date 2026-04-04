package Service;

import Enums.VehicleType;
import Model.ParkingSpot;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public interface ParkingManager {

    void park(String registrationId, VehicleType type);

    Integer unpark(String registrationId);

    void InitializeParkingSpots(List<ParkingSpot> parkingSpotList);
}
