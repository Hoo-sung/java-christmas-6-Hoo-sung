package christmas.domain;

import christmas.system.Constant;

public class Day {

    private static final int WEEK_LENGTH = 7;
    private final int day;

    public Day(int day) {
        this.day = day;
    }

    public int getDay(){
        return day;
    }

    public static boolean isFriday(Day day) {
        if (day.day % WEEK_LENGTH == 1)
            return true;
        return false;
    }

    public static boolean isSaturday(Day day) {
        if (day.day % WEEK_LENGTH == 2)
            return true;
        return false;
    }

    public static boolean isSunday(Day day) {
        if (day.day % WEEK_LENGTH == 3)
            return true;
        return false;
    }

    public static boolean isChristmas(Day day) {
        if (day.day == Constant.CHRISTMAS)
            return true;
        return false;
    }
}
