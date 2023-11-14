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
        if (order.getTotalOrderAmount() < EVENT_THRESHOLD_AMOUNT)
            return emptyDiscountRecord();
        return new DiscountRecord(day, order, discountManager, bonusEventManager);
    }

    private static DiscountRecord emptyDiscountRecord() {
        return new DiscountRecord();
    }

    public int getTotalWithDiscount(Order order) {
        int discountTotal = dDayDiscountAmount + weekdayDiscountAmount
                + weekendDiscountAmount + specialDayDiscountAmount;
        return order.getTotalOrderAmount() - discountTotal;
    }

    public int getTotalBenefitAmount() {
        return dDayDiscountAmount + weekdayDiscountAmount + weekendDiscountAmount + specialDayDiscountAmount + bonusEventBenefit;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<혜택 내역>").append(System.lineSeparator());
        if (getTotalBenefitAmount() == ZERO) {
            stringBuilder.append(NONE).append(System.lineSeparator());
            return stringBuilder.toString();
        }
        appendDiscountInfo(stringBuilder, "크리스마스 디데이 할인", dDayDiscountAmount);
        appendDiscountInfo(stringBuilder, "평일 할인", weekdayDiscountAmount);
        appendDiscountInfo(stringBuilder, "주말 할인", weekendDiscountAmount);
        appendDiscountInfo(stringBuilder, "특별 할인", specialDayDiscountAmount);
        appendDiscountInfo(stringBuilder, "증정 이벤트", bonusEventBenefit);

        return stringBuilder.toString();
    }

    private void appendDiscountInfo(StringBuilder stringBuilder, String label, int amount) {
        if (amount != ZERO) {
            stringBuilder.append(label).append(": -").append(Util.createFormattedAmount(amount)).append(MONEY_UNIT).append(System.lineSeparator());
        }
    }
}
