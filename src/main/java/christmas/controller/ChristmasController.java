package christmas.controller;

import christmas.domain.EventBadge;
import christmas.domain.event.DiscountRecord;
import christmas.domain.event.FreeGift;
import christmas.domain.order.Order;
import christmas.domain.order.OrderDay;
import christmas.dto.request.OrderRequest;
import christmas.service.badge.BadgeService;
import christmas.service.event.EventService;
import christmas.service.order.OrderService;

import java.util.Optional;

public class ChristmasController {

    private final OrderService orderService;

    private final EventService eventService;

    private final BadgeService badgeService;

    public ChristmasController(OrderService orderService, EventService eventService, BadgeService badgeService) {
        this.orderService = orderService;
        this.eventService = eventService;
        this.badgeService = badgeService;
    }

    public OrderDay createOrderDay(final int date){
        return new OrderDay(date);
    }

    public Order createOrder(final OrderRequest orderRequest){
        return orderService.createOrder(orderRequest);
    }

    public Optional<DiscountRecord> discountEvent(final Order order){
        return eventService.applyDiscountEvent(order);
    }

    public Optional<FreeGift> giftEvent(final Order order){
        return eventService.applyFreeGiftEvent(order);
    }

    public Optional<EventBadge> badge(final int totalDiscountAmount){
        return badgeService.applyBadge(totalDiscountAmount);
    }
}
