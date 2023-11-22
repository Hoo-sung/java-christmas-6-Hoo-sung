package christmas.domain.manager;


import christmas.domain.entity.Day;
import christmas.domain.entity.Order;

import static christmas.domain.entity.MenuType.*;
import static christmas.system.Constant.ZERO;

public class DiscountManager {

    private final int DISCOUNT_AMOUNT = 2023;
    private final int INITIAL_DISCOUNT_AMOUNT = 1000;
    private final int DAILY_DISCOUNT_INCREASE = 100;

    public DiscountManager() {
    }

    public int calculateDDayDiscount(Day day) {
        if (day.isChristmasSeason()) {
            return calculateDDayAmount(day);
        }
        return ZERO;
    }

    public int calculateWeekDayDiscount(Day day, Order order) {
        if (day.isWeekday()) {
            return calculateWeekDayAmount(order);
        }
        return ZERO;
    }

    public int calculateWeekendDiscount(Day day, Order order) {
        if (day.isWeekend()) {
            return calculateWeekendAmount(order);
        }
        return ZERO;
    }

    public int calculateSpecialDayDiscount(Day day) {
        int STAR_DISCOUNT = 1000;
        if (day.isSpecialDay()) {
            return STAR_DISCOUNT;
        }
        return ZERO;
    }

    private int calculateDDayAmount(Day day) {
        return INITIAL_DISCOUNT_AMOUNT + DAILY_DISCOUNT_INCREASE * (day.getDay() - 1);
    }

    private int calculateWeekDayAmount(Order order) {
        return order.getOrderItems().stream()
                .filter(orderItem -> orderItem.getMenuType() == DESSERT)
                .mapToInt(orderItem -> DISCOUNT_AMOUNT * orderItem.getQuantity())
                .sum();
    }

    private int calculateWeekendAmount(Order order) {
        return order.getOrderItems().stream()
                .filter(orderItem -> orderItem.getMenuType() == MAIN)
                .mapToInt(orderItem -> DISCOUNT_AMOUNT * orderItem.getQuantity())
                .sum();
    }
}
