package christmas.view;

import christmas.domain.*;

import static christmas.domain.util.Util.*;
import static christmas.system.Constant.BONUS_MINIMUM_THRESHOLD;
import static christmas.system.Constant.ZERO;
import static christmas.system.IOMessage.*;

public final class OutputView {

    private OutputView() {

    }

    public static void printEventNotice() {
        printEmptyLine();
        printMessage("고객님께 안내드릴 이벤트 주의 사항!!!");
        printMessage("1. 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.");
        printMessage("2. 음료만 주문 시, 주문할 수 없습니다.");
        printMessage("3. 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        printMessage("(e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개 입니다.!)");
        printEmptyLine();
    }

    public static void printResultStartMessage(int day) {
        printMessage("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        printEmptyLine();
    }

    public static void printOrderList(Order order) {
        printMessage("<주문 메뉴>");
        for (OrderItem orderItem : order.getOrderItems()) {
            printMessage(orderItem.getName() + " " + orderItem.getQuantity() + QUANTITY_UNIT);
        }
        printEmptyLine();
    }

    public static void printOriginalTotalAmount(Order order) {
        printMessage("<할인 전 총주문 금액>");
        printMessage(createFormattedAmount(order.getTotalOrderAmount()) + MONEY_UNIT);
        printEmptyLine();
    }

    public static void printBonusMenu(Order order) {
        printMessage("<증정 메뉴>");
        if (order.getTotalOrderAmount() < BONUS_MINIMUM_THRESHOLD) {
            printMessage(NONE);
            printEmptyLine();
            return;
        }
        for (BonusMenu bonusMenu : BonusMenu.values()) {
            printMessage(bonusMenu.getName() + " " + createFormattedAmount(bonusMenu.getQuantity()) + QUANTITY_UNIT);
        }
        printEmptyLine();
    }

    public static void printDiscountRecord(DiscountRecord discountRecord) {
        printMessage("<혜택 내역>");
        if (discountRecord.getTotalBenefitAmount() == ZERO) {
            printMessage(NONE);
            printEmptyLine();
            return;
        }
        printXmasDdayDiscount(discountRecord);
        printWeekDayDiscount(discountRecord);
        printWeekEndDiscount(discountRecord);
        printSpecialDiscount(discountRecord);
        printBonusEventBenefit(discountRecord);
        printEmptyLine();
    }

    public static void printTotalDiscountAmount(DiscountRecord discountRecord) {
        printMessage("<총혜택 금액>");
        int totalDiscountAmount = discountRecord.getTotalBenefitAmount();
        if (totalDiscountAmount == ZERO) {
            printMessage(ZERO + MONEY_UNIT);
            printEmptyLine();
            return;
        }
        printMessage("-" + createFormattedAmount(totalDiscountAmount) + MONEY_UNIT);
        printEmptyLine();
    }

    public static void printExpectedPayment(Order order, DiscountRecord discountRecord ) {
        int expectedPayment = discountRecord.getTotalWithDiscount(order);
        printMessage("<할인 후 예상 결제 금액>");
        printMessage(createFormattedAmount(expectedPayment) + MONEY_UNIT);
        printEmptyLine();
    }

    public static void printEventBadge(EventBadge badge) {
        printMessage("<12월 이벤트 배지>");
        if (badge == null) {
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

    private static void printBonusEventBenefit(DiscountRecord discountRecord) {
        if (discountRecord.getBonusEventBenefit() != ZERO)
            printMessage("증정 이벤트: -" + createFormattedAmount(discountRecord.getBonusEventBenefit()) + MONEY_UNIT);
    }

    private static void printSpecialDiscount(DiscountRecord discountRecord) {
        if (discountRecord.getSpecialDayDiscountAmount() != ZERO)
            printMessage("특별 할인: -" + createFormattedAmount(discountRecord.getSpecialDayDiscountAmount()) + MONEY_UNIT);
    }

    private static void printWeekEndDiscount(DiscountRecord discountRecord) {
        if (discountRecord.getWeekendDiscountAmount() != ZERO)
            printMessage("주말 할인: -" + createFormattedAmount(discountRecord.getWeekendDiscountAmount()) + MONEY_UNIT);
    }

    private static void printWeekDayDiscount(DiscountRecord discountRecord) {
        if (discountRecord.getWeekdayDiscountAmount() != ZERO)
            printMessage("평일 할인: -" + createFormattedAmount(discountRecord.getWeekdayDiscountAmount()) + MONEY_UNIT);
    }

    private static void printXmasDdayDiscount(DiscountRecord discountRecord) {
        if (discountRecord.getdDayDiscountAmount() != ZERO)
            printMessage("크리크마스 디데이 할인: -" + createFormattedAmount(discountRecord.getdDayDiscountAmount()) + MONEY_UNIT);
    }
}
