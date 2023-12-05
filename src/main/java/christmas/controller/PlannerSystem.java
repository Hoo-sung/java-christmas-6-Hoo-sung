package christmas.controller;

import christmas.domain.EventBadge;
import christmas.domain.event.DiscountRecord;
import christmas.domain.event.FreeGift;
import christmas.domain.order.Order;
import christmas.domain.order.OrderDay;
import christmas.dto.request.OrderRequest;
import christmas.dto.response.BadgeResponse;
import christmas.dto.response.DiscountResponse;
import christmas.dto.response.FreeGiftResponse;
import christmas.service.badge.BadgeService;
import christmas.service.event.EventService;
import christmas.service.order.OrderService;
import christmas.util.Mapper.BadgeResponseMapper;
import christmas.util.Mapper.DiscountResponseMapper;
import christmas.util.Mapper.FreeGiftResponseMapper;

import java.util.Optional;

public class PlannerSystem {

    private final OrderService orderService;

    private final EventService eventService;

    private final BadgeService badgeService;

    public PlannerSystem(OrderService orderService, EventService eventService, BadgeService badgeService) {
        this.orderService = orderService;
        this.eventService = eventService;
        this.badgeService = badgeService;
    }

    public OrderDay createOrderDay(final int date) {
        return new OrderDay(date);
    }

    public Order createOrder(final OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    public DiscountResponse discountEvent(final Order order) {
        final Optional<DiscountRecord> discountRecord = eventService.applyDiscountEvent(order);

        return discountRecord.map(DiscountResponseMapper::of)
                .orElseGet(DiscountResponseMapper::of);
    }

    public FreeGiftResponse giftEvent(final Order order) {
        final Optional<FreeGift> freeGift = eventService.applyFreeGiftEvent(order);

        return freeGift.map(FreeGiftResponseMapper::of)
                .orElseGet(FreeGiftResponseMapper::of);
    }

    public BadgeResponse badge(final int totalDiscountAmount, final int freeGift) {
        final Optional<EventBadge> eventBadge = badgeService.applyBadge(totalDiscountAmount + freeGift);

        return eventBadge.map(BadgeResponseMapper::of)
                .orElseGet(BadgeResponseMapper::of);
    }

}
