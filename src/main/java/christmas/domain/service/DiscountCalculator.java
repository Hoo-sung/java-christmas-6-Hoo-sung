package christmas.domain.service;

import christmas.domain.Day;
import christmas.domain.MenuType;
import christmas.domain.Order;

public class DiscountCalculator {

    private static final int DISCOUNT_AMOUNT = 2023;
    private static final int INITIAL_DISCOUNT_AMOUNT = 1000;
    private static final int DAILY_DISCOUNT_INCREASE = 100;

    public static int calculateDDayDiscount(Day day) {
        return INITIAL_DISCOUNT_AMOUNT + DAILY_DISCOUNT_INCREASE * (day.getDay() - 1);
    }

    public static int calculateWeekDayDiscount(Order order) {
        return order.getOrderItems().stream()
                .filter(orderItem -> orderItem.getMenuType() == MenuType.DESSERT)
                .mapToInt(orderItem -> DISCOUNT_AMOUNT * orderItem.getQuantity())
                .sum();
    }

    public static int calculateWeekendDiscount(Order order) {
        return order.getOrderItems().stream()
                .filter(orderItem -> orderItem.getMenuType() == MenuType.MAIN)
                .mapToInt(orderItem -> DISCOUNT_AMOUNT * orderItem.getQuantity())
                .sum();
    }

}
