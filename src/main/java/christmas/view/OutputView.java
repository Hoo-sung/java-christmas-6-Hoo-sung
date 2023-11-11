package christmas.view;

import christmas.domain.*;
import christmas.domain.manager.BonusEventManager;
import christmas.domain.util.Util;
import christmas.system.IOMessage;

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
            printMessage(orderItem.getName()+" "+orderItem.getQuantity()+IOMessage.QUANTITY_UNIT);
        }
        printEmptyLine();
    }

    public static void printOriginalTotalAmount(int originalTotalAmount){
        printMessage("<할인 전 총주문 금액>");
        printMessage(Util.createFormattedAmount(originalTotalAmount)+IOMessage.MONEY_UNIT);
        printEmptyLine();
    }

    public static void printBonusMenu(int originalTotalAmount){
        printMessage("<증정 메뉴>");
        if(originalTotalAmount < BonusEventManager.BONUS_MINIMUM_THRESHOLD) {
            printMessage(IOMessage.NONE);
            printEmptyLine();
            return;
        }
        for(BonusMenu bonusMenu : BonusMenu.values()){
            printMessage(bonusMenu.getName()+" "+Util.createFormattedAmount(bonusMenu.getQuantity())+IOMessage.QUANTITY_UNIT);
        }
        printEmptyLine();
    }

    public static void printDiscountRecord(DiscountRecord discountRecord){
        printMessage("<혜택 내역>");
        if(discountRecord.getTotalDiscountAmount()==IOMessage.ZERO){
            printMessage(IOMessage.NONE);
            printEmptyLine();
            return;
        }
        if(discountRecord.getdDayDiscountAmount() !=IOMessage.ZERO )
            printMessage("크리크마스 디데이 할인: -"+Util.createFormattedAmount(discountRecord.getdDayDiscountAmount())+IOMessage.MONEY_UNIT);
        if(discountRecord.getWeekdayDiscountAmount()!=IOMessage.ZERO)
            printMessage("평일 할인: -"+Util.createFormattedAmount(discountRecord.getWeekdayDiscountAmount())+IOMessage.MONEY_UNIT);
        if(discountRecord.getWeekendDiscountAmount()!=IOMessage.ZERO)
            printMessage("주말 할인: -"+Util.createFormattedAmount(discountRecord.getWeekendDiscountAmount())+IOMessage.MONEY_UNIT);
        if(discountRecord.getStarDayDiscountAmount()!=IOMessage.ZERO)
            printMessage("특별 할인: -"+Util.createFormattedAmount(discountRecord.getStarDayDiscountAmount())+IOMessage.MONEY_UNIT);
        if(discountRecord.getBonusEventDiscount()!=IOMessage.ZERO)
            printMessage("증정 이벤트: -"+Util.createFormattedAmount(discountRecord.getBonusEventDiscount())+IOMessage.MONEY_UNIT);
        printEmptyLine();
    }

    public  static void printTotalDiscountAmount(DiscountRecord discountRecord){
        printMessage("<총혜택 금액>");
        if(discountRecord.getTotalDiscountAmount() == IOMessage.ZERO){
            printMessage(IOMessage.ZERO+IOMessage.MONEY_UNIT);
            printEmptyLine();
            return;
        }
        printMessage("-"+Util.createFormattedAmount(discountRecord.getTotalDiscountAmount())+IOMessage.MONEY_UNIT);
        printEmptyLine();
    }

    public static void printExpectedPayment(int expectedPayment){
        printMessage("<할인 후 예상 결제 금액>");
        printMessage(Util.createFormattedAmount(expectedPayment)+IOMessage.MONEY_UNIT);
        printEmptyLine();
    }

    public static void printEventBadge(EventBadge badge){
        printMessage("<12월 이벤트 배지>");
        if(badge == null){
            printMessage(IOMessage.NONE);
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
