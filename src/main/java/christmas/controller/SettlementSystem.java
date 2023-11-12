package christmas.controller;

import christmas.domain.*;
import christmas.domain.manager.BonusEventManager;
import christmas.domain.manager.DiscountManager;

import static christmas.domain.service.EventBadgeGenerator.*;
import static christmas.domain.service.PaymentCalculator.*;
import static christmas.view.OutputView.*;

public class SettlementSystem {

    private final int originalTotalAmount;
    private final DiscountRecord discountRecord;

    private final int totalWithDiscount;
    private final EventBadge badge;

    public SettlementSystem(Day day, Order order) {
        DiscountManager discountManager = new DiscountManager();
        BonusEventManager bonusEventManager = new BonusEventManager();
        this.originalTotalAmount = calculateOriginalTotal(order);
        this.discountRecord = DiscountRecord.create(day, order, originalTotalAmount, discountManager, bonusEventManager);
        this.totalWithDiscount = calculateTotalWithDiscount(originalTotalAmount, discountRecord);
        this.badge = createBadge(discountRecord.getTotalDiscountAmount());
    }

    public void renderSettlementResult() {
        printOriginalTotalAmount(originalTotalAmount);
        printBonusMenu(originalTotalAmount);
        printDiscountRecord(discountRecord);
        printTotalDiscountAmount(discountRecord);
        printExpectedPayment(totalWithDiscount);
        printEventBadge(badge);
    }
}
