package christmas.domain;


import christmas.domain.manager.DiscountManager;

public class DiscountRecord {

    private final int dDayDiscountAmount;

    private final int weekdayDiscountAmount;
    private final int weekendDiscountAmount;

    private final int starDayDiscountAmount;

    public DiscountRecord(Day day, Order order) {
        this.dDayDiscountAmount = DiscountManager.DDayDiscount(day);
        this.weekdayDiscountAmount = DiscountManager.weekDayDiscount(day,order);
        this.weekendDiscountAmount = DiscountManager.weekendDiscount(day,order);
        this.starDayDiscountAmount = DiscountManager.starDayDiscount(day);
    }
}
