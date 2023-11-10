package christmas.controller;

import christmas.domain.*;

public class SettlementSystem {

    private final Day day;

    private final Order order;

    private final int originalTotalAmount;
    private final DiscountRecord discountRecord;

    private final int totalWithDiscount;

    private final EventBadge badge;

    private final PaymentCalculator paymentCalculator = new PaymentCalculator();


    public SettlementSystem(Day day, Order order) {
        this.day = day;
        this.order = order;
        this.originalTotalAmount = paymentCalculator.calculateOriginalTotal(order);
        this.discountRecord = new DiscountRecord(day,order,originalTotalAmount);
        this.totalWithDiscount = paymentCalculator.calculateTotalWithDiscount(originalTotalAmount,discountRecord);
        this.badge = EventBadgeGenerator.createBadge(discountRecord.getTotalDiscountAmount());
    }
}
