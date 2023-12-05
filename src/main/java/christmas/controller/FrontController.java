package christmas.controller;

import christmas.domain.EventBadge;
import christmas.domain.event.DiscountRecord;
import christmas.domain.event.FreeGift;
import christmas.domain.order.Order;
import christmas.domain.order.OrderDay;
import christmas.dto.request.OrderRequest;
import christmas.system.IOMessage;
import christmas.util.OrderRequestMapper;


import static christmas.view.InputView.INPUT_VIEW;
import static christmas.view.OutputView.OUTPUT_VIEW;

public class FrontController {

    private final PlannerSystem plannerSystem;

    public FrontController(PlannerSystem plannerSystem) {
        this.plannerSystem = plannerSystem;
    }

    public void run(){
        startChristmasPromotion();
        final OrderDay orderDay = daySetting();
        final Order order = OrderSetting(orderDay.getDay());

        renderingPreview(orderDay,order);
        processChristmasPromotion(order);
    }

    private void startChristmasPromotion(){
        OUTPUT_VIEW.printMessage(IOMessage.START_MESSAGE);
    }

   private OrderDay daySetting(){
        return ExceptionHandler.handle(()->{
            int date = INPUT_VIEW.readDate();
            return plannerSystem.createOrderDay(date);
        });
   }
   private Order OrderSetting(final int date){
        return ExceptionHandler.handle(() ->{
            String menuForm = INPUT_VIEW.readMenuForm();
            OrderRequest orderRequest = OrderRequestMapper.fromMenuForm(menuForm,date);
            return plannerSystem.createOrder(orderRequest);
        });
   }

   private void renderingPreview(final OrderDay orderDay,final Order order){
        OUTPUT_VIEW.printPreviewEventMessage(orderDay.getDay());
        OUTPUT_VIEW.printOrderList(order);
        OUTPUT_VIEW.printOriginalTotalAmount(order);
   }

   private void processChristmasPromotion(final Order order){
       DiscountRecord discountRecord = plannerSystem.discountEvent(order);
       FreeGift freeGift = plannerSystem.giftEvent(order);
       EventBadge badge = plannerSystem.badge(discountRecord);
       renderingResult(discountRecord,freeGift,badge);

   }

   private void renderingResult(DiscountRecord discountRecord, FreeGift freeGift, EventBadge eventBadge){
       OUTPUT_VIEW.printBonusMenu(freeGift);
       OUTPUT_VIEW.printDiscountRecord(discountRecord);
       OUTPUT_VIEW.printTotalDiscountAmount(discountRecord);
       OUTPUT_VIEW.printExpectedPayment(discountRecord);
       OUTPUT_VIEW.printEventBadge(eventBadge);
   }



}
