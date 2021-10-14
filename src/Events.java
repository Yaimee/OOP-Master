import java.util.Locale;

public class Events {
    private int hour;
    private int minute;
    private int month;
    private int day;
    private int year;
    private String genre;
    private String eventName;
    private String details;
    private String venue;

    public Events (String eventName, String genre, String details, String venue, int hour, int minute, int month, int day, int year) {
        this.eventName = eventName;
        this.genre = genre;
        this.details = details;
        this.venue = venue;
        this.hour = hour;
        this.minute = minute;
        this.month = month;
        this.day = day;
        this.year = year;
    }
    public void printEvent() {
        System.out.println("\n***" + eventName.toUpperCase() + "*** (" + genre + ")");
        System.out.println("Venue: " + venue);
        System.out.printf(((day < 10) ? "0%d" : "%d") + "/" + ((month < 10) ? "0%d" : "%d") + "-%d  at " + ((hour < 10) ?  "0%d"  : "%d" ) + ":" + ((minute < 10) ?  "0%d"  : "%d" )+ "\n", day, month, year, hour, minute);
        System.out.println("------------------------------");
        System.out.println("Info: " + details);
        System.out.println("------------------------------\n");

    }
    public void setDay(int day) {
        this.day = day;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getMonth() {
        return month;
    }


    public String getDetails() {
        return details;
    }

    public String getEventName() {
        return eventName;
    }

    public String getGenre() {
        return genre;
    }

    public String getVenue() {
        return venue;
    }
}
