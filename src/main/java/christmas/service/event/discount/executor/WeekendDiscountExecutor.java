package christmas.service.event.discount.executor;

import christmas.domain.EventType;
import christmas.domain.MenuType;
import christmas.domain.order.Order;

public class WeekendDiscountExecutor implements DiscountExecutor {
    @Override
    public int execute(Order order) {
        return EventType.WEEKEND.calculateDiscount(order.getSpecificMenuOrderCount(MenuType.MAIN));
    }

}
