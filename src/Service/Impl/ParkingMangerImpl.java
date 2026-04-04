package Service.Impl;

import Exceptions.ParkingException;
import Model.ParkingSpot;
import Model.ParkingTicket;
import Model.Vehicle;
import Enums.VehicleType;
import Repo.Repository;
import Service.CalculateFee;
import Service.Impl.CaculateFeeImp.FeeContext;
import Service.ParkingManager;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class ParkingMangerImpl implements ParkingManager {

    Repository repository;

    FeeContext context;

    public ParkingMangerImpl(){
        this.repository = new Repository();
        this.context = new FeeContext();
    }

    @Override
    public void park(String registrationId, VehicleType type) {
        ParkingSpot parkingSpot = getEmptyParkingSpot(type);
        if(Objects.isNull(parkingSpot)){
            throw new ParkingException("All parking spots are ful");
        }
        Vehicle vehicle = createAndGetVehicle(registrationId, type);

        ParkingTicket parkingTicket = new ParkingTicket(UUID.randomUUID().toString(),vehicle,parkingSpot, Instant.now());

        repository.saveParkingTicket(parkingTicket);

        parkingSpot.setEmpty(false);
    }

    @Override
    public Integer unpark(String regId) {
        Optional<ParkingTicket> parkingTicket = repository.getParkingTicketById(regId);
        if(parkingTicket.isEmpty()){
            throw new ParkingException("Invalid parking Ticket");
        }
        ParkingTicket pt = parkingTicket.get();
        pt.setExitTime(Instant.now());
        pt.getParkingSpot().setEmpty(true);
        pt.setActive(false);
        Duration duration = Duration.between(pt.getEntryTime(),pt.getExitTime());
        return context.payFee(pt.getVehicle().getType(),duration);
    }

    @Override
    public void InitializeParkingSpots(List<ParkingSpot> parkingSpotList) {
        repository.setParkingSpots(parkingSpotList);
    }

    private Vehicle createAndGetVehicle(String registrationId, VehicleType type){
        Optional<Vehicle> vehicle = repository.getVehicleByRegId(registrationId);
        if(vehicle.isPresent()){
            return vehicle.get();
        }
        Vehicle createVehicle = new Vehicle(UUID.randomUUID().toString(),type,registrationId);
        repository.saveVehicle(createVehicle);
        return createVehicle;
    }

    private ParkingSpot getEmptyParkingSpot(VehicleType type){
        Optional<ParkingSpot> parkingSpot = repository.getParkingSpotByVehicleType(type);
        return parkingSpot.orElse(null);
    }

    private ParkingTicket creatParkingTicket(Vehicle vehicle, Timestamp timestamp){
        return null;
    }




}
