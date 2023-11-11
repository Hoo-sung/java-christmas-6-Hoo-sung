package christmas.domain.service;

import christmas.domain.DiscountRecord;
import christmas.domain.Order;
import christmas.domain.OrderItem;
import christmas.system.Constant;

public class PaymentCalculator {

    public static int calculateOriginalTotal(Order order){
        int total = Constant.ZERO;
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
