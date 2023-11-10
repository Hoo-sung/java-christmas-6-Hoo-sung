package christmas.domain.manager;


import christmas.domain.Day;

public class DiscountManager {

    public static int DDayDiscount(Day day){
        if(DayManager.isChristmasSeason(day))
            return calculateDDayDiscount(day);
        return 0;
    }
    private static int calculateDDayDiscount(Day day){
        return 1000 + 100 * (day.getDay()-1);
    }
}
