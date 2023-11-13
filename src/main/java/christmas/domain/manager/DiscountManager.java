package christmas.domain.manager;


import christmas.domain.*;

import static christmas.domain.service.DiscountCalculator.*;
import static christmas.system.Constant.ZERO;

public class DiscountManager {

    public DiscountManager() {
    }

    public int DDayDiscount(Day day) {
        if (day.isChristmasSeason())
            return calculateDDayDiscount(day);
        return ZERO;
    }

    public int weekDayDiscount(Day day, Order order) {
        if (day.isWeekday())
            return calculateWeekDayDiscount(order);
        return ZERO;
    }

    public int weekendDiscount(Day day, Order order) {
        if (day.isWeekend())
            return calculateWeekendDiscount(order);
        return ZERO;
    }

    public int starDayDiscount(Day day) {
        int STAR_DISCOUNT = 1000;
        if (day.hasStar())
            return STAR_DISCOUNT;
        return ZERO;
    }
}
