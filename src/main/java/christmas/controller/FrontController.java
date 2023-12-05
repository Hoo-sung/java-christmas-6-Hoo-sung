package christmas.controller;

import christmas.domain.order.Order;
import christmas.domain.order.OrderDay;
import christmas.dto.request.OrderRequest;
import christmas.dto.response.BadgeResponse;
import christmas.dto.response.DiscountResponse;
import christmas.dto.response.FreeGiftResponse;
import christmas.dto.response.OrderResponse;
import christmas.util.Mapper.OrderRequestMapper;
import christmas.util.Mapper.OrderResponseMapper;


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
        final OrderResponse orderResponse = OrderResponseMapper.of(order);

        renderingPreview(orderDay,orderResponse);
        processChristmasPromotion(order,orderResponse);
    }

    private void startChristmasPromotion(){
        OUTPUT_VIEW.printStartMessage();
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

   private void renderingPreview(final OrderDay orderDay,final OrderResponse orderResponse){
        OUTPUT_VIEW.printPreviewEventMessage(orderDay.getDay());
        OUTPUT_VIEW.printOrderMenus(orderResponse);
        OUTPUT_VIEW.printOriginalTotalAmount(orderResponse);
   }

   private void processChristmasPromotion(final Order order,final OrderResponse orderResponse){
       final DiscountResponse discountResponse = plannerSystem.discountEvent(order);
       final FreeGiftResponse freeGiftResponse = plannerSystem.giftEvent(order);
       final BadgeResponse badgeResponse = plannerSystem.badge(discountResponse.getTotalDiscountAmount(), freeGiftResponse.getBenefitPrice());
       renderingResult(orderResponse,freeGiftResponse,discountResponse,badgeResponse);

   }

   private void renderingResult(final OrderResponse orderResponse,final FreeGiftResponse freeGiftResponse,
                                final DiscountResponse discountResponse, final BadgeResponse badgeResponse){
       OUTPUT_VIEW.printFreeGiftResult(freeGiftResponse);
       OUTPUT_VIEW.printBenefitResult(discountResponse,freeGiftResponse);
       OUTPUT_VIEW.printTotalBenefitAmount(discountResponse,freeGiftResponse);
       OUTPUT_VIEW.printExpectedPayment(orderResponse,discountResponse);
       OUTPUT_VIEW.printEventBadge(badgeResponse);
   }



}
