package christmas.controller;

import christmas.domain.*;
import christmas.domain.manager.BonusEventManager;
import christmas.domain.manager.DiscountManager;

import static christmas.domain.service.EventBadgeGenerator.*;
import static christmas.view.OutputView.*;

public class SettlementSystem {

    private final int originalTotalAmount;
    private final DiscountRecord discountRecord;

    public SettlementSystem(Day day, Order order) {
        DiscountManager discountManager = new DiscountManager();
        BonusEventManager bonusEventManager = new BonusEventManager();
        this.originalTotalAmount = order.getTotalOrderAmount();
        this.discountRecord = DiscountRecord.create(day, order, originalTotalAmount, discountManager, bonusEventManager);
    }

    public void renderSettlementResult() {
        printOriginalTotalAmount(originalTotalAmount);
        printBonusMenu(originalTotalAmount);
        printDiscountRecord(discountRecord);
        printTotalDiscountAmount(discountRecord.getTotalBenefitAmount());
        printExpectedPayment(discountRecord.getTotalWithDiscount(originalTotalAmount));
        printEventBadge(createBadge(discountRecord.getTotalBenefitAmount()));
    }
}
