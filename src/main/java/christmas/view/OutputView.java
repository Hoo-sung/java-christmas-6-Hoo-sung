package christmas.view;

import christmas.domain.*;

import static christmas.domain.util.Util.*;
import static christmas.system.Constant.BONUS_MINIMUM_THRESHOLD;
import static christmas.system.Constant.ZERO;
import static christmas.system.IOMessage.*;

public final class OutputView {

    private OutputView() {

    }
    public static void printResultStartMessage(int day){
        printMessage("12월 "+day+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        printEmptyLine();
    }
    public static void printOrderList(Order order){
        printMessage("<주문 메뉴>");
        for(OrderItem orderItem: order.getOrderItems()){
            printMessage(orderItem.getName()+" "+orderItem.getQuantity()+ QUANTITY_UNIT);
        }
        printEmptyLine();
    }

    public static void printOriginalTotalAmount(int originalTotalAmount){
        printMessage("<할인 전 총주문 금액>");
        printMessage(createFormattedAmount(originalTotalAmount)+ MONEY_UNIT);
        printEmptyLine();
    }

    public static void printBonusMenu(int originalTotalAmount){
        printMessage("<증정 메뉴>");
        if(originalTotalAmount < BONUS_MINIMUM_THRESHOLD) {
            printMessage(NONE);
            printEmptyLine();
            return;
        }
        for(BonusMenu bonusMenu : BonusMenu.values()){
            printMessage(bonusMenu.getName()+" "+ createFormattedAmount(bonusMenu.getQuantity())+ QUANTITY_UNIT);
        }
        printEmptyLine();
    }

    public static void printDiscountRecord(DiscountRecord discountRecord){
        printMessage("<혜택 내역>");
        if(discountRecord.getTotalDiscountAmount()== ZERO){
            printMessage(NONE);
            printEmptyLine();
            return;
        }
        if(discountRecord.getdDayDiscountAmount() != ZERO )
            printMessage("크리크마스 디데이 할인: -"+ createFormattedAmount(discountRecord.getdDayDiscountAmount())+ MONEY_UNIT);
        if(discountRecord.getWeekdayDiscountAmount()!= ZERO)
            printMessage("평일 할인: -"+ createFormattedAmount(discountRecord.getWeekdayDiscountAmount())+ MONEY_UNIT);
        if(discountRecord.getWeekendDiscountAmount()!= ZERO)
            printMessage("주말 할인: -"+ createFormattedAmount(discountRecord.getWeekendDiscountAmount())+ MONEY_UNIT);
        if(discountRecord.getStarDayDiscountAmount()!= ZERO)
            printMessage("특별 할인: -"+ createFormattedAmount(discountRecord.getStarDayDiscountAmount())+ MONEY_UNIT);
        if(discountRecord.getBonusEventDiscount()!= ZERO)
            printMessage("증정 이벤트: -"+ createFormattedAmount(discountRecord.getBonusEventDiscount())+ MONEY_UNIT);
        printEmptyLine();
    }

    public  static void printTotalDiscountAmount(DiscountRecord discountRecord){
        printMessage("<총혜택 금액>");
        if(discountRecord.getTotalDiscountAmount() == ZERO){
            printMessage(ZERO+ MONEY_UNIT);
            printEmptyLine();
            return;
        }
        printMessage("-"+ createFormattedAmount(discountRecord.getTotalDiscountAmount())+ MONEY_UNIT);
        printEmptyLine();
    }

    public static void printExpectedPayment(int expectedPayment){
        printMessage("<할인 후 예상 결제 금액>");
        printMessage(createFormattedAmount(expectedPayment)+ MONEY_UNIT);
        printEmptyLine();
    }

    public static void printEventBadge(EventBadge badge){
        printMessage("<12월 이벤트 배지>");
        if(badge == null){
            printMessage(NONE);
            return;
        }
        printMessage(badge.getName());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
    public static void printEmptyLine() {
        System.out.println();
    }
}
