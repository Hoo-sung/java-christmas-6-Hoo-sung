package christmas.domain.service;

import christmas.domain.Day;

import static christmas.domain.Day.*;
import static christmas.system.Constant.CHRISTMAS;


public class DateInfoProvider {

    private static final int FIRSTDATE = 1;

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

    public static boolean isChristmasSeason(Day day) {
        if (day.getDay() >= FIRSTDATE && day.getDay() <= CHRISTMAS)
            return true;
        return false;
    }

}
