package Service.Impl.CaculateFeeImp;

import Service.CalculateFee;

import java.time.Duration;

public class TruckFee implements CalculateFee {
    @Override
    public Integer calculateFee(Duration duration) {
        return Math.toIntExact(duration.toSeconds() * 3);
    }
}
