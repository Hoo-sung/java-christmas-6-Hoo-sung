package christmas.domain.manager;


import christmas.domain.*;
import christmas.domain.service.DateInfoProvider;

public class DiscountManager {

    public static int DDayDiscount(Day day){
        if(DateInfoProvider.isChristmasSeason(day))
            return calculateDDayDiscount(day);
        return 0;
    }

    public static int weekDayDiscount(Day day,Order order){
        if(DateInfoProvider.isWeekday(day))
            return calculateWeekDayDiscount(order);
        return 0;
    }

    public static int weekendDiscount(Day day, Order order){
        if(DateInfoProvider.isWeekend(day))
            return calculateWeekendDiscount(order);
        return 0;
    }

    public static int starDayDiscount(Day day){
        if(DateInfoProvider.hasStar(day))
            return 1000;
        return 0;
    }
    private static int calculateDDayDiscount(Day day){
        return 1000 + 100 * (day.getDay()-1);
    }

    private static int calculateWeekDayDiscount(Order order){
        int discountTotal=0;
        for (OrderItem orderItem : order.getOrderItems()) {
            if(orderItem.getMenuType() == MenuType.DESSERT){
                discountTotal += (2023 * orderItem.getQuantity());
            }
        }
        return discountTotal;
    }

    private static int calculateWeekendDiscount( Order order){
        int discountTotal=0;
        for (OrderItem orderItem : order.getOrderItems()) {
            if(orderItem.getMenuType() == MenuType.MAIN){
                discountTotal += (2023 * orderItem.getQuantity());
            }
        }
        return discountTotal;
    }

}
