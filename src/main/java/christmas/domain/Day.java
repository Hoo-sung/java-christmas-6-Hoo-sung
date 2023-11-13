package christmas.domain;

import christmas.system.Constant;

import static christmas.system.Constant.CHRISTMAS;

public class Day {

    private final int WEEK_LENGTH = 7;
    private final int FIRSTDATE = 1;
    private final int day;

    public Day(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public boolean isChristmasSeason() {
        if (day >= FIRSTDATE && day <= CHRISTMAS)
            return true;
        return false;
    }

    public boolean isWeekday() {
        if (!(isFriday() || isSaturday()))
            return true;
        return false;
    }

    public boolean isWeekend() {
        if (isFriday() || isSaturday())
            return true;
        return false;
    }

    public boolean isSpecialDay() {
        if (isSunday() || isChristmas())
            return true;
        return false;
    }

    private boolean isFriday() {
        if (day % WEEK_LENGTH == 1)
            return true;
        return false;
    }

    private boolean isSaturday() {
        if (day % WEEK_LENGTH == 2)
            return true;
        return false;
    }

    private boolean isSunday() {
        if (day % WEEK_LENGTH == 3)
            return true;
        return false;
    }

    private boolean isChristmas() {
        if (day == Constant.CHRISTMAS)
            return true;
        return false;
    }
}
