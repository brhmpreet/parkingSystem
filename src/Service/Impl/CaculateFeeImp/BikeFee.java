package Service.Impl.CaculateFeeImp;

import Service.CalculateFee;

import java.sql.Timestamp;
import java.time.Duration;

public class BikeFee implements CalculateFee {
    @Override
    public Integer calculateFee(Duration duration) {
        return Math.toIntExact(duration.toSeconds() * 2);
    }
}
