package christmas.domain.order;


import static christmas.system.ExceptionMessage.INVALID_DATE_MESSAGE;

public class OrderDay {

    /**
     * OrderDay 도메인은 1부터 31 사이인지 검증하는 역할
     */
    private static final int WEEK_LENGTH = 7;
    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;
    private static final int CHRISTMAS = 25;
    private final int day;

    public OrderDay(int day) {
        validate(day);
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public boolean isChristmasSeason() {
        if (day >= MIN_DAY && day <= CHRISTMAS) {
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
            throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
        }
    }

}
