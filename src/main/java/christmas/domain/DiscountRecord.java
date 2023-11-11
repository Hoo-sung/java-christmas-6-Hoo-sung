package christmas.domain;


import christmas.domain.manager.BonusEventManager;
import christmas.domain.manager.DiscountManager;

public class DiscountRecord {

    private final int dDayDiscountAmount;

    private final int weekdayDiscountAmount;
    private final int weekendDiscountAmount;

    private final int starDayDiscountAmount;

    private final int bonusEventDiscount;

    private final DiscountManager discountManager;

    private final BonusEventManager bonusEventManager;

    public static DiscountRecord create(Day day, Order order, int originalTotalAmount) {
        if(originalTotalAmount < 10000)
            return emptyDiscountRecord();
        return new DiscountRecord(day,order,originalTotalAmount);
    }

    private DiscountRecord(Day day, Order order, int originalTotalAmount) {
        this.discountManager = new DiscountManager();
        this.bonusEventManager = new BonusEventManager();
        this.dDayDiscountAmount = discountManager.DDayDiscount(day);
        this.weekdayDiscountAmount = discountManager.weekDayDiscount(day,order);
        this.weekendDiscountAmount = discountManager.weekendDiscount(day,order);
        this.starDayDiscountAmount = discountManager.starDayDiscount(day);
        this.bonusEventDiscount = bonusEventManager.makeBonusEventDiscount(originalTotalAmount);
    }
    private static DiscountRecord emptyDiscountRecord() {
        return new DiscountRecord();
    }
    private DiscountRecord() {
        this.discountManager = null;
        this.bonusEventManager = null;
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
