package christmas.domain;


import christmas.domain.manager.BonusEventManager;
import christmas.domain.manager.DiscountManager;

import static christmas.system.Constant.*;

public class DiscountRecord {

    private final int dDayDiscountAmount;

    private final int weekdayDiscountAmount;
    private final int weekendDiscountAmount;

    private final int specialDayDiscountAmount;

    private final int bonusEventBenefit;

    private DiscountRecord(Day day, Order order, int originalTotalAmount,
                           DiscountManager discountManager, BonusEventManager bonusEventManager) {
        this.dDayDiscountAmount = discountManager.getDDayDiscount(day);
        this.weekdayDiscountAmount = discountManager.getWeekDayDiscount(day, order);
        this.weekendDiscountAmount = discountManager.getWeekendDiscount(day, order);
        this.specialDayDiscountAmount = discountManager.getStarDayDiscount(day);
        this.bonusEventBenefit = bonusEventManager.makeBonusEventBenefit(originalTotalAmount);
    }

    private DiscountRecord() {
        this.dDayDiscountAmount = ZERO;
        this.weekdayDiscountAmount = ZERO;
        this.weekendDiscountAmount = ZERO;
        this.specialDayDiscountAmount = ZERO;
        this.bonusEventBenefit = ZERO;
    }

    public static DiscountRecord create(Day day, Order order, int originalTotalAmount,
                                        DiscountManager discountManager, BonusEventManager bonusEventManager) {
        if (originalTotalAmount < EVENT_THRESHOLD_AMOUNT)
            return emptyDiscountRecord();
        return new DiscountRecord(day, order, originalTotalAmount, discountManager, bonusEventManager);
    }
    private static DiscountRecord emptyDiscountRecord() {
        return new DiscountRecord();
    }

    public  int getTotalWithDiscount(int originalTotalAmount) {
        int discountTotal = dDayDiscountAmount + weekdayDiscountAmount
                + weekendDiscountAmount + specialDayDiscountAmount;
        return originalTotalAmount - discountTotal;
    }

    public int getTotalBenefitAmount() {
        return dDayDiscountAmount + weekdayDiscountAmount + weekendDiscountAmount + specialDayDiscountAmount + bonusEventBenefit;
    }

    public int getdDayDiscountAmount() {
        return dDayDiscountAmount;
    }

    public int getWeekendDiscountAmount() {
        return weekendDiscountAmount;
    }

    public int getWeekdayDiscountAmount() {
        return weekdayDiscountAmount;
    }

    public int getSpecialDayDiscountAmount() {
        return specialDayDiscountAmount;
    }

    public int getBonusEventBenefit() {
        return bonusEventBenefit;
    }
}
