package christmas.service.event.discount.executor;

import christmas.domain.EventType;
import christmas.domain.MenuType;
import christmas.domain.order.Order;

public class WeekDayDiscountExecutor implements DiscountExecutor{
    @Override
    public int execute(Order order) {
        return EventType.WEEKDAY.calculateDiscount(order.getSpecificMenuOrderCount(MenuType.DESSERT));
    }

}
