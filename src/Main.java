import Enums.VehicleType;
import Model.ParkingSpot;
import Repo.Repository;
import Service.Impl.ParkingMangerImpl;
import Service.ParkingManager;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ParkingManager parkingManager = new ParkingMangerImpl();
        List<ParkingSpot> parkingSpotList = Arrays.asList(new ParkingSpot(VehicleType.CAR),new ParkingSpot(VehicleType.BIKE), new ParkingSpot(VehicleType.CAR),new ParkingSpot(VehicleType.TRUCK));

        parkingManager.InitializeParkingSpots(parkingSpotList);

        parkingManager.park("CH0123", VehicleType.TRUCK);
        Thread.sleep(10000);
        Integer payAmount = parkingManager.unpark("CH0123");

        System.out.println("Pay amount: "+ payAmount);


    }
}
