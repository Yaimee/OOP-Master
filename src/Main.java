import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    private Events[] events = new Events[1];
    static boolean run = true;
    private static int eventPosition = 0;
    private static Events[] eventArray = new Events[1];
    private static int yearInCalendar = 2021;
    private static int yearCounter = 0;
    private static Calendar[][] yearArray = {{new Calendar(yearInCalendar, 0), new Calendar(yearInCalendar, 1), new Calendar(yearInCalendar, 2), new Calendar(yearInCalendar, 3), new Calendar(yearInCalendar, 4), new Calendar(yearInCalendar, 5), new Calendar(yearInCalendar, 6), new Calendar(yearInCalendar, 7), new Calendar(yearInCalendar, 8), new Calendar(yearInCalendar, 9), new Calendar(yearInCalendar, 10), new Calendar(yearInCalendar, 11)}};

    //udvider eventArray og lægger event i
    public static void newEventArray(Events event, int position) {
        eventArray[position] = event;
        Events[] eventArrayTemp = new Events[eventArray.length + 1];
        for (int i = 0; i < eventArray.length; i++) {
            eventArrayTemp[i] = eventArray[i];
        }
        eventArray = eventArrayTemp;
    }

    public static void main(String[] args) {
        menu();
    }
    //initialiserer yearArray med en ekstra plads i første dimension for at skabe 12 nye pladser til næste år
    public static void initializeYearArray() {
        Calendar[][] tempYearArray = new Calendar[yearArray.length + 1][];
        for (int i = 0; i < yearArray.length; i++) {
            for (int u = 0; u < 12; u++) {
                tempYearArray[i][u] = yearArray[i][u];
            }
        }
        for (int i = 0; i < 12; i++) {
            tempYearArray[yearCounter][i] = new Calendar(yearInCalendar, i);
        }
        yearArray = tempYearArray;
    }
    //skifter til næste år og printer året
    public static void nextYear() {
        yearInCalendar++;
        try {
            printYear(yearArray);
        } catch ( Exception e) {
            yearCounter++;
            initializeYearArray();
            printYear(yearArray);
        }
    }
    //skifter tilbage til året før
    public static void previousYear() {
        yearInCalendar--;
        yearCounter--;
        printYear(yearArray);
    }
    //printer menuen
    public static void menu () {
        int menu;
        do {
            try {
                System.out.println("\tMenu");
                System.out.println("1. create event");
                System.out.println("2. print calendar");
                System.out.println("3. print month");
                System.out.println("4. exit");
                menu = scan.nextInt();
                scan.nextLine();
                switch (menu) {
                    case 1:
                        createNewEvent();
                        break;
                    case 2:
                        printYear(yearArray);
                        break;
                    case 3:
                        /*printMonth();*/
                        break;
                    case 4:
                        run = false;
                }
            } catch (Exception e) {
                System.out.println("Illegal value! Try again.");
            }
        } while(run);

    }
    //printer et specifikt eventobjekt
    public static void printEvent() {
        int month = 0;
        int day = 0;
        do {
            run = false;
            try {
                System.out.print("Insert month of the event: ");
                month = scan.nextInt();
                scan.nextLine();
                System.out.print("Insert day of the event: ");
                day = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Illegal value! Try again.");
                run = true;
            }
        } while (run);
        for (int i = 0; i < eventArray.length; i++) {
            if (eventArray[i].getMonth() == month && eventArray[i].getDay() == day) {
                eventArray[i].printEvent();
            }
        }


    }
    //printer all måned objekterne i et år
    public static void printYear(Calendar[][] yearArray) {
        for (int i = 0; i < 12; i++) {
            yearArray[yearCounter][i].drawCalendar();
        }
        int menu;
        do {
            run = false;
            try {
                System.out.println("\n\n1. next year");
                System.out.println("2. previous year");
                System.out.println("3. print event");
                menu = scan.nextInt();
                scan.nextLine();
                switch (menu) {
                    case 1:
                        nextYear();
                        break;
                    case 2:
                        previousYear();
                        break;
                    case 3:
                        printEvent();
                }
                if (menu != 1 && menu != 2 && menu != 3) {
                    System.out.println("Illegal value! You must insert either \"1\" or \"2\". Try again.");
                    run = true;
                }
            } catch (Exception e) {
                System.out.println("Illegal value! Try again.");
                run = true;
            }
        } while (run);
    }
    //laver nyt event
    public static void createNewEvent() {

        String eventName;
        String genre;
        String details;
        String venue;
        int hour;
        int minute;
        int month;
        int day;
        int year;

        System.out.print("Insert event name: ");
        eventName = scan.nextLine();
        System.out.print("Insert genre: ");
        genre = scan.nextLine();
        System.out.print("Insert description: ");
        details = scan.nextLine();
        System.out.print("Insert name of the venue: ");
        venue = scan.nextLine();
        System.out.print("What is the start hour of the event?: ");
        hour = scan.nextInt();
        scan.nextLine();
        System.out.print("What is the start minute of the event?: ");
        minute = scan.nextInt();
        scan.nextLine();
        System.out.print("Which month is the event?: ");
        month = scan.nextInt();
        scan.nextLine();
        System.out.print("What day is the event: ");
        day = scan.nextInt();
        scan.nextLine();
        System.out.print("Which year is the event?: ");
        year = scan.nextInt();
        scan.nextLine();
        newEventArray(new Events(eventName, genre, details, venue, hour, minute, month, day, year), eventPosition);
        eventPosition++;
        putInCalendar(day - 1, month - 1);
    }
    //
    public static void putInCalendar(int day, int month) {
        for (int i = 0; i < 12; i++) {
            if (month == yearArray[yearCounter][i].getMonth()) {
                yearArray[yearCounter][i].registerEventInCalendar(day);
                break;
            }
        }
    }

    public static int getYearInCalendar() {
        return yearInCalendar;
    }
    /*public static void printMonth() {
        System.out.println("Choose month. (decimal)");
        Calendar.setMonth(scan.nextInt() - 1);
        Calendar.drawCalendar(Calendar.getMonth());
    }*/
}
