package christmas.domain;


import christmas.domain.manager.BonusEventManager;
import christmas.domain.manager.DiscountManager;

public class DiscountRecord {

    private final int dDayDiscountAmount;

    private final int weekdayDiscountAmount;
    private final int weekendDiscountAmount;

    private final int starDayDiscountAmount;

    private final int bonusEventDiscount;

    public static DiscountRecord create(Day day, Order order, int originalTotalAmount) {
        if(originalTotalAmount < 10000)
            return emptyDiscountRecord();
        return new DiscountRecord(day,order,originalTotalAmount);
    }

    private DiscountRecord(Day day, Order order, int originalTotalAmount) {
        this.dDayDiscountAmount = DiscountManager.DDayDiscount(day);
        this.weekdayDiscountAmount = DiscountManager.weekDayDiscount(day,order);
        this.weekendDiscountAmount = DiscountManager.weekendDiscount(day,order);
        this.starDayDiscountAmount = DiscountManager.starDayDiscount(day);
        this.bonusEventDiscount = BonusEventManager.makeBonusEventDiscount(originalTotalAmount);
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

    public int getTotalDiscountAmount(){
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
