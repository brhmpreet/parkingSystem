package Service.Impl.CaculateFeeImp;

import Enums.VehicleType;
import Model.Vehicle;
import Service.CalculateFee;

public class FeeFactory {

    public CalculateFee getFeeStrategy(VehicleType vehicleType){
        return switch (vehicleType){
            case BIKE -> new BikeFee();
            case CAR -> new CarFee();
            case TRUCK -> new TruckFee();
            default -> null;
        };
    }
}
