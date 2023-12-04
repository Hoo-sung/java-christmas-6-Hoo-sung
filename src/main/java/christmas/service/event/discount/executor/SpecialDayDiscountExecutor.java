package christmas.service.event.discount.executor;

import christmas.domain.EventType;
import christmas.domain.order.Order;

public class SpecialDayDiscountExecutor implements DiscountExecutor {
    @Override
    public int execute(Order order) {
        return EventType.SPECIAL.calculateDiscount(1000);
    }
}
