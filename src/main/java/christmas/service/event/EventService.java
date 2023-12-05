package christmas.service.event;

import christmas.domain.event.DiscountRecord;
import christmas.domain.event.FreeGift;
import christmas.domain.order.Order;
import christmas.service.event.discount.DiscountEventService;
import christmas.service.event.gift.FreeGiftEventService;

import java.util.Optional;

public class EventService {
    private static final int APPLICABLE_MIN_TOTAL_PRICE = 10000;

    private final DiscountEventService discountEventService;

    private final FreeGiftEventService freeGiftEventService;

    public EventService(DiscountEventService discountEventService, FreeGiftEventService freeGiftEventService) {
        this.discountEventService = discountEventService;
        this.freeGiftEventService = freeGiftEventService;
    }

    public DiscountRecord applyDiscountEvent(final Order order) {
        if (order.getTotalOrderPrice() >= APPLICABLE_MIN_TOTAL_PRICE) {
            return discountEventService.calculateDiscountEvent(order);
        }
        return null;
    }

    public FreeGift applyFreeGiftEvent(final Order order) {
        if (order.getTotalOrderPrice() >= APPLICABLE_MIN_TOTAL_PRICE) {
            return freeGiftEventService.calculateGiftEvent(order.getTotalOrderPrice());
        }
        return null;
    }
}
