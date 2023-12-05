package christmas.configuration;

import christmas.controller.FrontController;
import christmas.controller.PlannerSystem;
import christmas.service.badge.BadgeService;
import christmas.service.event.EventService;
import christmas.service.event.discount.DiscountEventService;
import christmas.service.event.gift.FreeGiftEventService;
import christmas.service.order.OrderService;

public class ApplicationConfiguration {

    public FrontController frontController(){
        return new FrontController(plannerSystem());
    }
    public PlannerSystem plannerSystem(){
        return new PlannerSystem(orderService(),eventService(),badgeService());
    }

    public OrderService orderService(){
        return new OrderService();
    }
    public EventService eventService(){
        return new EventService(discountEventService(), giftEventService());
    }
    public DiscountEventService discountEventService(){
        return new DiscountEventService();
    }
    public FreeGiftEventService giftEventService(){
        return new FreeGiftEventService();
    }
    public BadgeService badgeService(){
        return new BadgeService();
    }

}
