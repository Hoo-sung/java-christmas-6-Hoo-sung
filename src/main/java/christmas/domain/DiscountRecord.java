package christmas.domain;


import christmas.domain.manager.DiscountManager;

public class DiscountRecord {

    private final int dDayDiscountAmount;

    private final int weekdayDiscountAmount;
    private final int weekendDiscountAmount;

    private final int starDayDiscountAmount;

    public DiscountRecord(Day day, Order order, int originalTotalAmount) {
        if(originalTotalAmount <10000){
            this.dDayDiscountAmount = 0;
            this.weekdayDiscountAmount = 0;
            this.weekendDiscountAmount = 0;
            this.starDayDiscountAmount =0 ;
            return;
        }
        this.dDayDiscountAmount = DiscountManager.DDayDiscount(day);
        this.weekdayDiscountAmount = DiscountManager.weekDayDiscount(day,order);
        this.weekendDiscountAmount = DiscountManager.weekendDiscount(day,order);
        this.starDayDiscountAmount = DiscountManager.starDayDiscount(day);
    }

    public int getTotalDiscountAmount(){
        return dDayDiscountAmount + weekdayDiscountAmount + weekendDiscountAmount + starDayDiscountAmount;
    }
}
