package christmas.domain.order;

import static christmas.system.Constant.CHRISTMAS;
import static christmas.system.Constant.FIRST_DAY_OF_MONTH;

public class OrderDay {

    private static final int WEEK_LENGTH = 7;

    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;
    private final int day;

    public OrderDay(int day) {
        validate(day);
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public boolean isChristmasSeason() {
        if (day >= FIRST_DAY_OF_MONTH && day <= CHRISTMAS) {
            return true;
        }
        return false;
    }

    public boolean isWeekday() {
        if (!(isFriday() || isSaturday())) {
            return true;
        }
        return false;
    }

    public boolean isWeekend() {
        if (isFriday() || isSaturday()) {
            return true;
        }
        return false;
    }

    public boolean isSpecialDay() {
        if (isSunday() || isChristmas()) {
            return true;
        }
        return false;
    }

    private boolean isFriday() {
        if (day % WEEK_LENGTH == 1) {
            return true;
        }
        return false;
    }

    private boolean isSaturday() {
        if (day % WEEK_LENGTH == 2) {
            return true;
        }
        return false;
    }

    private boolean isSunday() {
        if (day % WEEK_LENGTH == 3) {
            return true;
        }
        return false;
    }

    private boolean isChristmas() {
        if (day == CHRISTMAS) {
            return true;
        }
        return false;
    }

    private void validate(int day){
        if (day <MIN_DAY || day > MAX_DAY){
            throw new IllegalArgumentException("숫자 범위 예외");
        }
    }

}
