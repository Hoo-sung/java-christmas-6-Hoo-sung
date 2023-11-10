package christmas.domain.manager;


import christmas.domain.Day;
import christmas.domain.MenuType;
import christmas.domain.Order;
import christmas.domain.OrderItem;

public class DiscountManager {

    public static int DDayDiscount(Day day){
        if(DayManager.isChristmasSeason(day))
            return calculateDDayDiscount(day);
        return 0;
    }

    public static int weekDayDiscount(Day day,Order order){
        if(DayManager.isWeekday(day))
            return calculateWeekDayDiscount(day, order);
        return 0;
    }

    public static int weekendDiscount(Day day, Order order){
        if(DayManager.isWeekend(day))
            return calculateWeekendDiscount(day,order);
        return 0;
    }

    public static int starDayDiscount(Day day){
        if(DayManager.hasStar(day))
            return 1000;
        return 0;
    }
    private static int calculateDDayDiscount(Day day){
        return 1000 + 100 * (day.getDay()-1);
    }

    private static int calculateWeekDayDiscount(Day day, Order order){
        int discountTotal=0;
        for (OrderItem orderItem : order.getOrderItems()) {
            if(orderItem.getMenuType() == MenuType.DESSERT){
                discountTotal += (2023 * orderItem.getQuantity());
            }
        }
        return discountTotal;
    }

    private static int calculateWeekendDiscount(Day day, Order order){
        int discountTotal=0;
        for (OrderItem orderItem : order.getOrderItems()) {
            if(orderItem.getMenuType() == MenuType.MAIN){
                discountTotal += (2023 * orderItem.getQuantity());
            }
        }
        return discountTotal;
    }

}
