package christmas.controller;

import christmas.domain.*;
import christmas.domain.manager.BonusEventManager;
import christmas.domain.manager.DiscountManager;

import static christmas.domain.service.EventBadgeGenerator.*;
import static christmas.view.OutputView.*;

public class SettlementSystem {

    private final Order order;
    private final DiscountRecord discountRecord;

    public SettlementSystem(Day day, Order order) {
        DiscountManager discountManager = new DiscountManager();
        BonusEventManager bonusEventManager = new BonusEventManager();
        this.order = order;
        this.discountRecord = DiscountRecord.create(day, order, discountManager, bonusEventManager);
    }

    public void renderSettlementResult() {
        printOriginalTotalAmount(order);
        printBonusMenu(order);
        printDiscountRecord(discountRecord);
        printTotalDiscountAmount(discountRecord);
        printExpectedPayment(order, discountRecord);
        printEventBadge(createBadge(discountRecord));
    }
}
