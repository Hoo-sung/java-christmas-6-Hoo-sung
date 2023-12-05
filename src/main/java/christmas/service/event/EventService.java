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

    public Optional<DiscountRecord> applyDiscountEvent(final Order order) {
        if (order.getTotalOrderPrice() >= APPLICABLE_MIN_TOTAL_PRICE) {
            return Optional.of(discountEventService.calculateDiscountEvent(order));
        }
        return Optional.empty();
    }

    public Optional<FreeGift> applyFreeGiftEvent(final Order order) {
        if (order.getTotalOrderPrice() >= APPLICABLE_MIN_TOTAL_PRICE) {
            return freeGiftEventService.calculateGiftEvent(order.getTotalOrderPrice());
        }
        return Optional.empty();
    }
}
