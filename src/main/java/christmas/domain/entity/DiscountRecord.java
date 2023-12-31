package christmas.domain.entity;


import christmas.domain.manager.BonusEventManager;
import christmas.domain.manager.DiscountManager;
import christmas.domain.util.Util;

import static christmas.system.Constant.*;
import static christmas.system.IOMessage.*;

public class DiscountRecord {

    private final int dDayDiscountAmount;
    private final int weekdayDiscountAmount;
    private final int weekendDiscountAmount;
    private final int specialDayDiscountAmount;
    private final int bonusEventBenefit;

    private DiscountRecord(Day day, Order order,
                           DiscountManager discountManager, BonusEventManager bonusEventManager) {
        this.dDayDiscountAmount = discountManager.calculateDDayDiscount(day);
        this.weekdayDiscountAmount = discountManager.calculateWeekDayDiscount(day, order);
        this.weekendDiscountAmount = discountManager.calculateWeekendDiscount(day, order);
        this.specialDayDiscountAmount = discountManager.calculateSpecialDayDiscount(day);
        this.bonusEventBenefit = bonusEventManager.makeBonusEventBenefit(order);
    }

    private DiscountRecord() {
        this.dDayDiscountAmount = ZERO;
        this.weekdayDiscountAmount = ZERO;
        this.weekendDiscountAmount = ZERO;
        this.specialDayDiscountAmount = ZERO;
        this.bonusEventBenefit = ZERO;
    }

    public static DiscountRecord create(Day day, Order order,
                                        DiscountManager discountManager, BonusEventManager bonusEventManager) {
        if (order.calculateTotalOrderAmount() < EVENT_THRESHOLD_AMOUNT) {
            return emptyDiscountRecord();
        }
        return new DiscountRecord(day, order, discountManager, bonusEventManager);
    }

    private static DiscountRecord emptyDiscountRecord() {
        return new DiscountRecord();
    }

    public int calculateTotalWithDiscount(Order order) {
        int discountTotal = dDayDiscountAmount + weekdayDiscountAmount
                + weekendDiscountAmount + specialDayDiscountAmount;
        return order.calculateTotalOrderAmount() - discountTotal;
    }

    public int calculateTotalBenefitAmount() {
        return dDayDiscountAmount + weekdayDiscountAmount + weekendDiscountAmount + specialDayDiscountAmount + bonusEventBenefit;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (calculateTotalBenefitAmount() == ZERO) {
            stringBuilder.append(NONE).append(System.lineSeparator());
            return stringBuilder.toString();
        }
        appendDiscountInfo(stringBuilder, XMAS_DDAY_DISCOUNT, dDayDiscountAmount);
        appendDiscountInfo(stringBuilder, WEEKDAY_DISCOUNT, weekdayDiscountAmount);
        appendDiscountInfo(stringBuilder, WEEKEND_DISCOUNT, weekendDiscountAmount);
        appendDiscountInfo(stringBuilder, SPECIAL_DISCOUNT, specialDayDiscountAmount);
        appendDiscountInfo(stringBuilder, BONUS_EVENT, bonusEventBenefit);

        return stringBuilder.toString();
    }

    private void appendDiscountInfo(StringBuilder stringBuilder, String label, int amount) {
        if (amount != ZERO) {
            stringBuilder.append(label).append(MESSAGE_DELIMITER).append(Util.createFormattedAmount(amount)).append(MONEY_UNIT).append(System.lineSeparator());
        }
    }
}
