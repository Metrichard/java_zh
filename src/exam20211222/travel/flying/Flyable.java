package exam20211222.travel.flying;

import exam20211222.travel.Destination;

public interface Flyable {
    Integer estimatedArrivalTime(Destination destination);
    double getPrice(double discount);
}
