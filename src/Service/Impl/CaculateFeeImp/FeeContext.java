package Service.Impl.CaculateFeeImp;

import Enums.VehicleType;
import Service.CalculateFee;

import java.time.Duration;

public class FeeContext {
    CalculateFee feeStrategy;

    FeeFactory feeFactory;

    public FeeContext(){
        feeFactory = new FeeFactory();
    }
    public Integer payFee(VehicleType type, Duration duration){
        this.feeStrategy = feeFactory.getFeeStrategy(type);
        return feeStrategy.calculateFee(duration);
    }
}
