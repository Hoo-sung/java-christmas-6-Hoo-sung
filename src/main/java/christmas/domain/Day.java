package christmas.domain;

public class Day {

    private final int day;

    public Day(int day) {
        this.day = day;
    }

    public static boolean checkWeekend(Day day) {
        if (isFriday(day) || isSaturday(day))
            return true;
        return false;
    }

    public static boolean checkWeekday(Day day) {
        if (!(isFriday(day) || isSaturday(day)))
            return true;
        return false;
    }

    public static boolean checkHasStar(Day day) {
        if (isSunday(day) || isChristmas(day))
            return true;
        return false;
    }

    private static boolean isFriday(Day day) {
        if (day.day % 7 == 1)
            return true;
        return false;
    }

    private static boolean isSaturday(Day day) {
        if (day.day % 7 == 2)
            return true;
        return false;
    }

    private static boolean isSunday(Day day) {
        if (day.day % 7 == 3)
            return true;
        return false;
    }

    private static boolean isChristmas(Day day) {
        if (day.day == 25)
            return true;
        return false;
    }

}
