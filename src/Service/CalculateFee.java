package Service;

import java.sql.Timestamp;
import java.time.Duration;

public interface CalculateFee {

    Integer calculateFee(Duration duration);
}
