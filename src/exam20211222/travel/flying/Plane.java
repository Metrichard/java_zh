package exam20211222.travel.flying;

import exam20211222.travel.Destination;
import exam20211222.travel.DestinationUtils;

import java.util.Objects;

public class Plane extends Flight implements Flyable {
    private String name;
    private Integer id;
    private Integer ticketPrice;

    private Plane(String name, Integer id, Integer ticketPrice){
        if(name == null || ticketPrice < 10)
            throw new IllegalArgumentException("Either name is null or ticket price is too low");
        this.name = name;
        this.id = id;
        this.ticketPrice = ticketPrice;
    }

    public static Plane make(String data) {
        String name = data.split(",")[0];
        Integer id = Integer.parseInt(data.split(",")[1]);
        Integer ticketPrice = Integer.parseInt(data.split(",")[2]);

        return new Plane(name, id, ticketPrice);
    }

    public Integer estimatedArrivalTime(Integer departHour, Destination destination) {
        return departHour + DestinationUtils.getRoundedHours(destination);
    }

    @Override
    public String toString() {
        return name + "," + id + "," + ticketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return Objects.equals(name, plane.name) && id.equals(plane.id) && ticketPrice.equals(plane.ticketPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, ticketPrice);
    }

    @Override
    public Integer estimatedArrivalTime(Destination destination) {
        return null;
    }

    @Override
    public double getPrice(double discount) {
        double actualDiscount = 1 - discount;
        if(actualDiscount == 0)
            return ticketPrice;
        else
            return ticketPrice * actualDiscount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }
}
