package exam20211222.travel;

public class DateAndTime {
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer minute;

    public DateAndTime(Integer year, Integer month, Integer day, Integer hour, Integer minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public DateAndTime() {
        this(2021, 12, 22, 4, 30);
    }

    @Override
    public String toString() {
        return year + "." + month + "." + day + " at " + hour + ":" + (minute < 10 ? "0" + minute : minute);
    }

    public String getTime() {
        return hour + ":" + (minute < 10 ? "0" + minute : minute);
    }
}
