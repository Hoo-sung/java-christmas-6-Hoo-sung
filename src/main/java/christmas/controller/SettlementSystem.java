package christmas.controller;

import christmas.domain.*;

public class SettlementSystem {

    private final Day day;

    private final Order order;

    private final DiscountRecord discountRecord;

    private final int originalTotalAmount;

    private final PaymentCalculator paymentCalculator = new PaymentCalculator();

    public SettlementSystem(Day day, Order order) {
        this.day = day;
        this.order = order;
        this.discountRecord = new DiscountRecord(day,order);
        this.originalTotalAmount = paymentCalculator.calculateOriginalTotal(order);
    }
}