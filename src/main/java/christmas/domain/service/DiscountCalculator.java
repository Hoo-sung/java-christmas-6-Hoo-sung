package christmas.domain.service;

import christmas.domain.Day;
import christmas.domain.MenuType;
import christmas.domain.Order;
import christmas.domain.OrderItem;

import static christmas.system.Constant.*;

public class DiscountCalculator {

    private static final int DISCOUNT_AMOUNT = 2023;
    private static final int INITIAL_DISCOUNT_AMOUNT = 1000;
    private static final int DAILY_DISCOUNT_INCREASE = 100;

    public static int calculateDDayDiscount(Day day) {
        return INITIAL_DISCOUNT_AMOUNT + DAILY_DISCOUNT_INCREASE * (day.getDay() - 1);
    }

    public static int calculateWeekDayDiscount(Order order) {
        int discountTotal = ZERO;
        for (OrderItem orderItem : order.getOrderItems()) {
            if (orderItem.getMenuType() == MenuType.DESSERT) {
                discountTotal += (DISCOUNT_AMOUNT * orderItem.getQuantity());
            }
        }
        return discountTotal;
    }

    public static int calculateWeekendDiscount(Order order) {
        int discountTotal = ZERO;
        for (OrderItem orderItem : order.getOrderItems()) {
            if (orderItem.getMenuType() == MenuType.MAIN) {
                discountTotal += (DISCOUNT_AMOUNT * orderItem.getQuantity());
            }
        }
        return discountTotal;
    }
}
