package exam20211222.travel;

public class DestinationUtils {
    public static Destination getDestination(String timeSpan) {
        if(timeSpan.equals(Destination.AMSTERDAM.getTime())){
            return Destination.AMSTERDAM;
        }
        else if(timeSpan.equals(Destination.BERLIN.getTime())){
            return Destination.BERLIN;
        }
        else if(timeSpan.equals(Destination.HELSINKI.getTime())){
            return Destination.HELSINKI;
        }
        else if(timeSpan.equals(Destination.PARIS.getTime())){
            return Destination.PARIS;
        }
        else if(timeSpan.equals(Destination.ROME.getTime())){
            return Destination.ROME;
        }
        return null;
    }

    public static String getDestinationDuration(Destination destination) {
        return destination.getTime();
    }

    public static Integer getRoundedHours(Destination destination) {
        String duration = getDestinationDuration(destination);
        int hours = Integer.parseInt(duration.split(":")[0]);
        int minute = Integer.parseInt(duration.split(":")[1]);
        return minute >= 30 ? hours+1 : hours;
    }
}
