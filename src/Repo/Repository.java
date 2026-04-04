package Repo;

import Model.ParkingSpot;
import Model.ParkingTicket;
import Model.Vehicle;
import Enums.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Repository {
    List<ParkingTicket> parkingTicketList;
    List<ParkingSpot> parkingSpots;
    List<Vehicle> vehicles;

    public Repository(){
        parkingSpots = new ArrayList<>();
        vehicles = new ArrayList<>();
        parkingTicketList = new ArrayList<>();
    }

    public Optional<ParkingSpot> getParkingSpotByVehicleType(VehicleType type){
        return parkingSpots.stream().filter(ParkingSpot::isEmpty).
                filter(x->x.getVehicleType().equals(type)).findFirst();
    }

    public void setParkingTicketList(List<ParkingTicket> parkingTicketList) {
        this.parkingTicketList = parkingTicketList;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Optional<Vehicle> getVehicleByRegId(String regId){
        return vehicles.stream().filter(x->x.getRegistrationId().equals(regId)).findFirst();
    }

    public void saveVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void saveParkingTicket(ParkingTicket parkingTicket){
        parkingTicketList.add(parkingTicket);
    }

    public Optional<ParkingTicket> getParkingTicketById(String regId){
        return parkingTicketList.stream().filter(ParkingTicket::isActive).filter(x->x.getVehicle().getRegistrationId().equals(regId)).findFirst();
    }
}
