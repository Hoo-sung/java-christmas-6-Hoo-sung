package christmas.domain;

public class Day {

    private final int day;

    public Day(int day) {
        this.day = day;
    }

    public int getDay(){
        return day;
    }

    public static boolean isFriday(Day day) {
        if (day.day % 7 == 1)
            return true;
        return false;
    }

    public static boolean isSaturday(Day day) {
        if (day.day % 7 == 2)
            return true;
        return false;
    }

    public static boolean isSunday(Day day) {
        if (day.day % 7 == 3)
            return true;
        return false;
    }

    public static boolean isChristmas(Day day) {
        if (day.day == 25)
            return true;
        return false;
    }
}
