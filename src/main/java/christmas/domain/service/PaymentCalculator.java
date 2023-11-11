package christmas.domain.service;

import christmas.domain.DiscountRecord;
import christmas.domain.Order;
import christmas.domain.OrderItem;

public class PaymentCalculator {

    public static int calculateOriginalTotal(Order order){
        int total =0;
        for (OrderItem orderItem : order.getOrderItems()) {
            total += (orderItem.getPrice() * orderItem.getQuantity());
        }
        return total;
    }

    public static int calculateTotalWithDiscount(int originalTotalAmount, DiscountRecord discountRecord){
        int minusValue = discountRecord.getdDayDiscountAmount() + discountRecord.getWeekdayDiscountAmount()
                + discountRecord.getWeekendDiscountAmount() + discountRecord.getStarDayDiscountAmount();
        return originalTotalAmount - minusValue;
    }
}
