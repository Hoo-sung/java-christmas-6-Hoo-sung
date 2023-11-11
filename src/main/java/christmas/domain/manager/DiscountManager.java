package christmas.domain.manager;


import christmas.domain.*;

import static christmas.domain.service.DateInfoProvider.*;
import static christmas.domain.service.DiscountCalculator.*;

public class DiscountManager {

    public DiscountManager() {
    }

    public int DDayDiscount(Day day) {
        if (isChristmasSeason(day))
            return calculateDDayDiscount(day);
        return 0;
    }

    public int weekDayDiscount(Day day, Order order) {
        if (isWeekday(day))
            return calculateWeekDayDiscount(order);
        return 0;
    }

    public int weekendDiscount(Day day, Order order) {
        if (isWeekend(day))
            return calculateWeekendDiscount(order);
        return 0;
    }

    public int starDayDiscount(Day day) {
        if (hasStar(day))
            return 1000;
        return 0;
    }
}
