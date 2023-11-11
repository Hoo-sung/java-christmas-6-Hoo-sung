package christmas.domain.service;

import christmas.domain.Day;
import christmas.domain.MenuType;
import christmas.domain.Order;
import christmas.domain.OrderItem;

public class DiscountCalculator {
    public static int calculateDDayDiscount(Day day) {
        return 1000 + 100 * (day.getDay() - 1);
    }

    public static int calculateWeekDayDiscount(Order order) {
        int discountTotal = 0;
        for (OrderItem orderItem : order.getOrderItems()) {
            if (orderItem.getMenuType() == MenuType.DESSERT) {
                discountTotal += (2023 * orderItem.getQuantity());
            }
        }
        return discountTotal;
    }

    public static int calculateWeekendDiscount(Order order) {
        int discountTotal = 0;
        for (OrderItem orderItem : order.getOrderItems()) {
            if (orderItem.getMenuType() == MenuType.MAIN) {
                discountTotal += (2023 * orderItem.getQuantity());
            }
        }
        return discountTotal;
    }
}
