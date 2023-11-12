package christmas.domain.service;

import christmas.domain.DiscountRecord;
import christmas.domain.Order;


public class PaymentCalculator {

    public static int calculateOriginalTotal(Order order) {
        return order.getOrderItems().stream()
                .mapToInt(orderItem -> orderItem.getPrice() * orderItem.getQuantity())
                .sum();
    }

    public static int calculateTotalWithDiscount(int originalTotalAmount, DiscountRecord discountRecord) {
        int discountTotal = discountRecord.getdDayDiscountAmount() + discountRecord.getWeekdayDiscountAmount()
                + discountRecord.getWeekendDiscountAmount() + discountRecord.getStarDayDiscountAmount();
        return originalTotalAmount - discountTotal;
    }
}
