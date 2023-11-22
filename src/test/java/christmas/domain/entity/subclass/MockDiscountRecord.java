package christmas.domain.entity.subclass;

import christmas.domain.entity.Day;
import christmas.domain.entity.Order;
import christmas.domain.manager.BonusEventManager;
import christmas.domain.manager.DiscountManager;

import static christmas.system.Constant.EVENT_THRESHOLD_AMOUNT;
import static christmas.system.Constant.ZERO;

public class MockDiscountRecord {
    private final int dDayDiscountAmount;
    private final int weekdayDiscountAmount;
    private final int weekendDiscountAmount;
    private final int specialDayDiscountAmount;
    private final int bonusEventBenefit;

    private MockDiscountRecord(Day day, Order order,
                               DiscountManager discountManager, BonusEventManager bonusEventManager) {
        this.dDayDiscountAmount = discountManager.calculateDDayDiscount(day);
        this.weekdayDiscountAmount = discountManager.calculateWeekDayDiscount(day, order);
        this.weekendDiscountAmount = discountManager.calculateWeekendDiscount(day, order);
        this.specialDayDiscountAmount = discountManager.calculateSpecialDayDiscount(day);
        this.bonusEventBenefit = bonusEventManager.makeBonusEventBenefit(order);
    }

    private MockDiscountRecord() {
        this.dDayDiscountAmount = ZERO;
        this.weekdayDiscountAmount = ZERO;
        this.weekendDiscountAmount = ZERO;
        this.specialDayDiscountAmount = ZERO;
        this.bonusEventBenefit = ZERO;
    }

    public static MockDiscountRecord create(Day day, Order order,
                                            DiscountManager discountManager, BonusEventManager bonusEventManager) {
        if (order.calculateTotalOrderAmount() < EVENT_THRESHOLD_AMOUNT) {
            return emptyDiscountRecord();
        }
        return new MockDiscountRecord(day, order, discountManager, bonusEventManager);
    }

    private static MockDiscountRecord emptyDiscountRecord() {
        return new MockDiscountRecord();
    }

    public int getdDayDiscountAmount() {
        return dDayDiscountAmount;
    }

    public int getWeekdayDiscountAmount() {
        return weekdayDiscountAmount;
    }

    public int getWeekendDiscountAmount() {
        return weekendDiscountAmount;
    }

    public int getSpecialDayDiscountAmount() {
        return specialDayDiscountAmount;
    }

    public int getBonusEventBenefit() {
        return bonusEventBenefit;
    }
}
