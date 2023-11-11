package christmas.domain;


import christmas.domain.manager.BonusEventManager;
import christmas.domain.manager.DiscountManager;

public class DiscountRecord {

    private final int dDayDiscountAmount;

    private final int weekdayDiscountAmount;
    private final int weekendDiscountAmount;

    private final int starDayDiscountAmount;

    private final int bonusEventDiscount;

    public static DiscountRecord create(Day day, Order order, int originalTotalAmount,
                                        DiscountManager discountManager, BonusEventManager bonusEventManager) {
        if (originalTotalAmount < 10000)
            return emptyDiscountRecord();
        return new DiscountRecord(day, order, originalTotalAmount, discountManager, bonusEventManager);
    }

    private DiscountRecord(Day day, Order order, int originalTotalAmount,
                           DiscountManager discountManager, BonusEventManager bonusEventManager) {
        this.dDayDiscountAmount = discountManager.DDayDiscount(day);
        this.weekdayDiscountAmount = discountManager.weekDayDiscount(day, order);
        this.weekendDiscountAmount = discountManager.weekendDiscount(day, order);
        this.starDayDiscountAmount = discountManager.starDayDiscount(day);
        this.bonusEventDiscount = bonusEventManager.makeBonusEventDiscount(originalTotalAmount);
    }

    private static DiscountRecord emptyDiscountRecord() {
        return new DiscountRecord();
    }

    private DiscountRecord() {
        this.dDayDiscountAmount = 0;
        this.weekdayDiscountAmount = 0;
        this.weekendDiscountAmount = 0;
        this.starDayDiscountAmount = 0;
        this.bonusEventDiscount = 0;
    }

    public int getTotalDiscountAmount() {
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
