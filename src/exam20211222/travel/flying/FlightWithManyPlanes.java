package exam20211222.travel.flying;

import exam20211222.travel.DateAndTime;
import exam20211222.travel.Destination;

import java.io.*;
import java.util.*;

public class FlightWithManyPlanes extends Flight{
    private List<Plane> planes = new ArrayList<>();

    public FlightWithManyPlanes(String name, Destination destinationCity, Integer numberOfTravellers, DateAndTime flightDateAndTime, List<Plane> planes)
    {
        super(name, destinationCity, numberOfTravellers, flightDateAndTime);
        this.planes = planes;
    }

    public void save(String fileName) throws IOException {
        File file = new File(fileName);
        if(file.createNewFile()) {
            System.out.println("File created under the name " + file.getName());
        } else {
            System.out.println("File already exists");
            throw new IOException("The File already exists");
        }
        FileWriter writer = new FileWriter(fileName);
        writer.write(getName() + "\n" + getDestinationCity() + "\n" + getNumberOfTravellers() + "\n" + getFlightDateAndTime() + "\n");
        for (Plane plane : planes){
            writer.write(plane.toString() + "\n");
        }
        writer.close();
    }

    public void load(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String name = reader.readLine();
        String destination = reader.readLine();
        int numberOfTravellers = Integer.parseInt(reader.readLine());
        reader.readLine(); // skipping this that's what's in the task
        String rawPlaneData;
        while((rawPlaneData = reader.readLine()) != null) {
            planes.add(Plane.make(rawPlaneData));
        }
        this.name = name;
        if(destination.equals(Destination.AMSTERDAM.name())){
            this.destinationCity = Destination.AMSTERDAM;
        }
        if(destination.equals(Destination.ROME.name())){
            this.destinationCity = Destination.ROME;
        }
        if(destination.equals(Destination.HELSINKI.name())){
            this.destinationCity = Destination.HELSINKI;
        }
        if(destination.equals(Destination.BERLIN.name())){
            this.destinationCity = Destination.BERLIN;
        }
        if(destination.equals(Destination.PARIS.name())){
            this.destinationCity = Destination.PARIS;
        }
        this.numberOfTravellers = numberOfTravellers;
    }

    public Plane getCheapestRide(double discountRateIncreased) {
        if(planes.size() == 0)
            throw new IllegalStateException("There are no planes");
        Plane result = planes.get(0);
        double price = result.getPrice(0);
        for(int i = 1; i < planes.size(); i++) {
            if(price > planes.get(i).getPrice(i*discountRateIncreased))
            {
                price = planes.get(i).getPrice(i*discountRateIncreased);
                result = planes.get(i);
            }
        }
        return result;
    }
}
