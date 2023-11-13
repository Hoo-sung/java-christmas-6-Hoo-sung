package christmas.domain;


import christmas.domain.manager.BonusEventManager;
import christmas.domain.manager.DiscountManager;

import static christmas.system.Constant.*;

public class DiscountRecord {

    private final int dDayDiscountAmount;

    private final int weekdayDiscountAmount;
    private final int weekendDiscountAmount;

    private final int starDayDiscountAmount;

    private final int bonusEventDiscount;

    private DiscountRecord(Day day, Order order, int originalTotalAmount,
                           DiscountManager discountManager, BonusEventManager bonusEventManager) {
        this.dDayDiscountAmount = discountManager.getDDayDiscount(day);
        this.weekdayDiscountAmount = discountManager.getWeekDayDiscount(day, order);
        this.weekendDiscountAmount = discountManager.getWeekendDiscount(day, order);
        this.starDayDiscountAmount = discountManager.getStarDayDiscount(day);
        this.bonusEventDiscount = bonusEventManager.makeBonusEventBenefit(originalTotalAmount);
    }

    private DiscountRecord() {
        this.dDayDiscountAmount = ZERO;
        this.weekdayDiscountAmount = ZERO;
        this.weekendDiscountAmount = ZERO;
        this.starDayDiscountAmount = ZERO;
        this.bonusEventDiscount = ZERO;
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
                + weekendDiscountAmount + starDayDiscountAmount;
        return originalTotalAmount - discountTotal;
    }

    public int getTotalBenefitAmount() {
        return dDayDiscountAmount + weekdayDiscountAmount + weekendDiscountAmount + starDayDiscountAmount + bonusEventDiscount;
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

    public int getStarDayDiscountAmount() {
        return starDayDiscountAmount;
    }

    public int getBonusEventDiscount() {
        return bonusEventDiscount;
    }
}
