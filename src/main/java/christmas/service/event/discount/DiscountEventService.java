package christmas.service.event.discount;

import christmas.domain.EventType;
import christmas.domain.event.DiscountRecord;
import christmas.domain.order.Order;
import christmas.service.event.discount.executor.*;

import java.util.EnumMap;
import java.util.List;

public class DiscountEventService {

    private final EnumMap<EventType, DiscountExecutor> discountExecutors;

    public DiscountEventService() {
        EnumMap<EventType, DiscountExecutor> discountExecutors = new EnumMap<>(EventType.class);
        discountExecutors.put(EventType.CHRISTMAS, new ChristmasDiscountExecutor());
        discountExecutors.put(EventType.WEEKDAY, new WeekDayDiscountExecutor());
        discountExecutors.put(EventType.WEEKEND, new WeekendDiscountExecutor());
        discountExecutors.put(EventType.SPECIAL, new SpecialDayDiscountExecutor());
        this.discountExecutors = discountExecutors;
    }

    public DiscountRecord calculateDiscountEvent(final Order order) {
        List<EventType> applicableEventTypes = EventType.getApplicableEventTypes(order.getOrderDay());

        EnumMap<EventType, Integer> discounts = new EnumMap<>(EventType.class);
        for (EventType eventType : applicableEventTypes) {
            DiscountExecutor executor = discountExecutors.get(eventType);
            discounts.put(eventType, executor.execute(order));
        }
        return new DiscountRecord(discounts);
    }

}
