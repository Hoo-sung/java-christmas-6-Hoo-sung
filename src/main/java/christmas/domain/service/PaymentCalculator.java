package christmas.domain.service;

import christmas.domain.DiscountRecord;


public class PaymentCalculator {

    public static int calculateTotalWithDiscount(int originalTotalAmount, DiscountRecord discountRecord) {
        int discountTotal = discountRecord.getdDayDiscountAmount() + discountRecord.getWeekdayDiscountAmount()
                + discountRecord.getWeekendDiscountAmount() + discountRecord.getStarDayDiscountAmount();
        return originalTotalAmount - discountTotal;
    }
}
