package christmas.domain.manager;


import christmas.domain.*;

import static christmas.system.Constant.ZERO;

public class DiscountManager {

    private final int DISCOUNT_AMOUNT = 2023;
    private final int INITIAL_DISCOUNT_AMOUNT = 1000;
    private final int DAILY_DISCOUNT_INCREASE = 100;

    public DiscountManager() {
    }

    public int getDDayDiscount(Day day) {
        if (day.isChristmasSeason())
            return calculateDDayDiscount(day);
        return ZERO;
    }

    public int getWeekDayDiscount(Day day, Order order) {
        if (day.isWeekday())
            return calculateWeekDayDiscount(order);
        return ZERO;
    }

    public int getWeekendDiscount(Day day, Order order) {
        if (day.isWeekend())
            return calculateWeekendDiscount(order);
        return ZERO;
    }

    public int getStarDayDiscount(Day day) {
        int STAR_DISCOUNT = 1000;
        if (day.hasStar())
            return STAR_DISCOUNT;
        return ZERO;
    }

    private int calculateDDayDiscount(Day day) {
        return INITIAL_DISCOUNT_AMOUNT + DAILY_DISCOUNT_INCREASE * (day.getDay() - 1);
    }

    private int calculateWeekDayDiscount(Order order) {
        return order.getOrderItems().stream()
                .filter(orderItem -> orderItem.getMenuType() == MenuType.DESSERT)
                .mapToInt(orderItem -> DISCOUNT_AMOUNT * orderItem.getQuantity())
                .sum();
    }

    private int calculateWeekendDiscount(Order order) {
        return order.getOrderItems().stream()
                .filter(orderItem -> orderItem.getMenuType() == MenuType.MAIN)
                .mapToInt(orderItem -> DISCOUNT_AMOUNT * orderItem.getQuantity())
                .sum();
    }
}
