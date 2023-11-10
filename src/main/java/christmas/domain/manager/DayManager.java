package christmas.domain.manager;

import christmas.domain.Day;

import static christmas.domain.Day.*;


public class DayManager {
    public static boolean isWeekend(Day day) {
        if (isFriday(day) || isSaturday(day))
            return true;
        return false;
    }

    public static boolean isWeekday(Day day) {
        if (!(isFriday(day) || isSaturday(day)))
            return true;
        return false;
    }

    public static boolean hasStar(Day day) {
        if (isSunday(day) || isChristmas(day))
            return true;
        return false;
    }

    public static boolean isChristmasSeason(Day day){
        if (day.getDay() >=1 && day.getDay() <=25)
            return true;
        return false;
    }

}
