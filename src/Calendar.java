import java.util.ArrayList;

public class Calendar {

    Events event;
    private int year;
    private int month;

    private String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] monthsArray = {"januar", "februar", "marts", "april", "maj", "juni", "juli", "august", "september", "oktober", "november", "december"};


    public Calendar(int year, int month) {
        this.month = month;
        this.year = year;
    }

    public Calendar(Events event) {
        this.event = event;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
    }


    public void previousMonth() {

    }

    public void drawCalendar () {

        System.out.println("\n\t\t" + monthsArray[month] + " " + Main.getYearInCalendar());
        switch (month) {
            case 0, 2, 4, 6, 7, 9, 11:
                drawDays(0);
                break;
            case 3, 5, 8, 10:
                drawDays(1);
                break;
            case 1:
                if (Main.getYearInCalendar() % 4 == 0) {
                    drawDays(2);
                } else {
                    drawDays(3);
                }
        }
    }
    public void registerEventInCalendar(int day) {
        this.days[day] = "X";
    }

    public void drawDays(int subtractDays) {
        int daysInAMonth = 31 - subtractDays;
        for (int i = 0; i < daysInAMonth; i++) {
            System.out.print(days[i] + "\t");
            if (days[i] != "X" && Integer.parseInt(days[i]) % 7 == 0) {
                System.out.print("\n");
            }
        }
    }
}
