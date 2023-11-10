package christmas.view;

import christmas.domain.*;
import christmas.domain.manager.BonusEventManager;

public final class OutputView {

    private static int MONTH = 12;

    private OutputView() {

    }
    public static void printResultStartMessage(int day){
        printMessage("12월 "+day+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        printEmptyLine();
    }
    public static void printOrderList(Order order){
        printMessage("<주문 메뉴>");
        for(OrderItem orderItem: order.getOrderItems()){
            printMessage(orderItem.getName()+" "+orderItem.getQuantity()+"개");
        }
        printEmptyLine();
    }

    public static void printOriginalTotalAmount(int originalTotalAmount){
        printMessage("<할인 전 총주문 금액>");
        printMessage(originalTotalAmount+"원");
        printEmptyLine();
    }

    public static void printBonusMenu(int originalTotalAmount){
        printMessage("<증정 메뉴>");
        if(originalTotalAmount < BonusEventManager.BONUS_MINIMUM_THRESHOLD) {
            printMessage("없음");
            printEmptyLine();
            return;
        }
        for(BonusMenu bonusMenu : BonusMenu.values()){
            printMessage(bonusMenu.getName()+" "+bonusMenu.getQuantity()+"개");
        }
        printEmptyLine();
    }

    public static void printDiscountRecord(DiscountRecord discountRecord){
        printMessage("<혜택 내역>");
        if(discountRecord.getTotalDiscountAmount()==0){
            printMessage("없음");
            printEmptyLine();
            return;
        }
        if(discountRecord.getdDayDiscountAmount() !=0 )
            printMessage("크리크마스 디데이 할인: -"+discountRecord.getdDayDiscountAmount()+"원");
        if(discountRecord.getWeekdayDiscountAmount()!=0)
            printMessage("평일 할인: -"+discountRecord.getWeekdayDiscountAmount()+"원");
        if(discountRecord.getWeekendDiscountAmount()!=0)
            printMessage("주말 할인: -"+discountRecord.getWeekendDiscountAmount()+"원");
        if(discountRecord.getStarDayDiscountAmount()!=0)
            printMessage("특별 할인: -"+discountRecord.getStarDayDiscountAmount()+"원");
        if(discountRecord.getBonusEventDiscount()!=0)
            printMessage("증정 이벤트: -"+discountRecord.getBonusEventDiscount()+"원");
        printEmptyLine();
    }

    public  static void printTotalDiscountAmount(DiscountRecord discountRecord){
        printMessage("<총혜택 금액>");
        if(discountRecord.getTotalDiscountAmount() == 0){
            printMessage("0원");
            printEmptyLine();
            return;
        }
        printMessage("-"+discountRecord.getTotalDiscountAmount()+"원");
        printEmptyLine();
    }

    public static void printExpectedPayment(int expectedPayment){
        printMessage("<할인 후 예상 결제 금액>");
        printMessage(expectedPayment+"원");
        printEmptyLine();
    }

    public static void printEventBadge(EventBadge badge){
        printMessage("<"+MONTH+"월 이벤트 배지>");
        if(badge == null){
            printMessage("없음");
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
