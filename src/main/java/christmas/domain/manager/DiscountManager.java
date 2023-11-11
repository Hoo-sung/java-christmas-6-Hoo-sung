package christmas.domain.manager;


import christmas.domain.*;

import static christmas.domain.service.DateInfoProvider.*;
import static christmas.domain.service.DiscountCalculator.*;
import static christmas.system.Constant.ZERO;

public class DiscountManager {

    private final static int STAR_DISCOUNT = 1000;

    public DiscountManager() {
    }

    public int DDayDiscount(Day day) {
        if (isChristmasSeason(day))
            return calculateDDayDiscount(day);
        return ZERO;
    }

    public int weekDayDiscount(Day day, Order order) {
        if (isWeekday(day))
            return calculateWeekDayDiscount(order);
        return ZERO;
    }

    public int weekendDiscount(Day day, Order order) {
        if (isWeekend(day))
            return calculateWeekendDiscount(order);
        return ZERO;
    }

    public int starDayDiscount(Day day) {
        if (hasStar(day))
            return STAR_DISCOUNT;
        return ZERO;
    }
}
