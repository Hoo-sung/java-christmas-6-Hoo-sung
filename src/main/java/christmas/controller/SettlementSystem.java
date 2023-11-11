package christmas.controller;

import christmas.domain.*;
import christmas.view.OutputView;

public class SettlementSystem {

    private final int originalTotalAmount;
    private final DiscountRecord discountRecord;

    private final int totalWithDiscount;
    private final EventBadge badge;
    private final PaymentCalculator paymentCalculator = new PaymentCalculator();


    public SettlementSystem(Day day, Order order) {
        this.originalTotalAmount = paymentCalculator.calculateOriginalTotal(order);
        this.discountRecord = DiscountRecord.create(day,order,originalTotalAmount);
        this.totalWithDiscount = paymentCalculator.calculateTotalWithDiscount(originalTotalAmount,discountRecord);
        this.badge = EventBadgeGenerator.createBadge(discountRecord.getTotalDiscountAmount());
    }

    public void renderSettlementResult(){
        OutputView.printOriginalTotalAmount(originalTotalAmount);
        OutputView.printBonusMenu(originalTotalAmount);
        OutputView.printDiscountRecord(discountRecord);
        OutputView.printTotalDiscountAmount(discountRecord);
        OutputView.printExpectedPayment(totalWithDiscount);
        OutputView.printEventBadge(badge);
    }
}
