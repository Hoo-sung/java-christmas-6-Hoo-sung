package christmas.domain.manager;


import christmas.domain.*;
import christmas.domain.service.DateInfoProvider;
import christmas.domain.service.DiscountCalculator;

public class DiscountManager {

    public static int DDayDiscount(Day day) {
        if (DateInfoProvider.isChristmasSeason(day))
            return DiscountCalculator.calculateDDayDiscount(day);
        return 0;
    }

    public static int weekDayDiscount(Day day, Order order) {
        if (DateInfoProvider.isWeekday(day))
            return DiscountCalculator.calculateWeekDayDiscount(order);
        return 0;
    }

    public static int weekendDiscount(Day day, Order order) {
        if (DateInfoProvider.isWeekend(day))
            return DiscountCalculator.calculateWeekendDiscount(order);
        return 0;
    }

    public static int starDayDiscount(Day day) {
        if (DateInfoProvider.hasStar(day))
            return 1000;
        return 0;
    }
}
