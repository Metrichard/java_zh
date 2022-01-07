package exam20211222.travel.flying;

import exam20211222.travel.DateAndTime;
import exam20211222.travel.Destination;

public class Flight {
    protected String name;
    protected Destination destinationCity;
    protected Integer numberOfTravellers;
    protected DateAndTime flightDateAndTime;

    public Flight(String name, Destination destinationCity, Integer numberOfTravellers, DateAndTime flightDateAndTime) {
        if(15 > numberOfTravellers || numberOfTravellers > 100)
            throw new IllegalArgumentException("Number of travellers can't be less than 15 or more than 100");
        this.name = name;
        this.destinationCity = destinationCity;
        this.numberOfTravellers = numberOfTravellers;
        this.flightDateAndTime = flightDateAndTime;
    }

    public Flight() {
        this("AirBus", Destination.ROME, 83, new DateAndTime());
    }

    public Destination getFlightDuration() {
        return destinationCity;
    }

    public String getName() {
        return name;
    }

    public String getDestinationCity() {
        return destinationCity.name();
    }

    public Integer getNumberOfTravellers() {
        return numberOfTravellers;
    }

    public String getFlightDateAndTime() {
        return flightDateAndTime.toString();
    }

    @Override
    public String toString() {
        return "Flying " + name + " with "
                + numberOfTravellers + " passengers to "
                + destinationCity.name() + " on "
                + flightDateAndTime.toString();
    }
}
