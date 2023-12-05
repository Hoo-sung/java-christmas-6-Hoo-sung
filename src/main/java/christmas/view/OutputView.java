package christmas.view;

import christmas.domain.EventBadge;
import christmas.domain.event.DiscountRecord;
import christmas.domain.event.FreeGift;
import christmas.domain.order.Order;
import christmas.system.IOMessage;

import static christmas.system.Constant.ZERO;
import static christmas.system.IOMessage.MONEY_UNIT;
import static christmas.system.IOMessage.NONE;
import static christmas.util.Formatting.createFormattedAmount;

public final class OutputView {

    public static OutputView OUTPUT_VIEW = new OutputView();

    private OutputView() {

    }

    public void printEventNotice() {
        printEmptyLine();
        printMessage("고객님께 안내드릴 이벤트 주의 사항!!!");
        printMessage("1. 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.");
        printMessage("2. 음료만 주문 시, 주문할 수 없습니다.");
        printMessage("3. 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        printMessage("(e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개 입니다.!)");
        printEmptyLine();
    }

    public void printPreviewEventMessage(int day) {
        printMessage("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        printEmptyLine();
    }

    public void printOrderList(Order order) {
        printMessage("<주문 메뉴>");
        printMessage(order.toString());
    }

    public void printOriginalTotalAmount(Order order) {
        printMessage("<할인 전 총주문 금액>");
        printMessage(createFormattedAmount(order.getTotalOrderPrice()) + MONEY_UNIT);
        printEmptyLine();
    }

    public void printBonusMenu(FreeGift freeGift) {
        printMessage("<증정 메뉴>");
        if (freeGift == null) {
            printMessage(NONE);
            printEmptyLine();
            return;
        }
        printMessage(freeGift.getGiftName() + IOMessage.EMPTY_STRING + freeGift.getQuantity() + IOMessage.QUANTITY_UNIT);
        printEmptyLine();
    }

    public void printDiscountRecord(DiscountRecord discountRecord, FreeGift freeGift) {
        printMessage("<혜택 내역>");
        if (discountRecord == null && freeGift == null) {
            printMessage(NONE);
            printEmptyLine();
            return;
        }
        if (discountRecord != null) {
            printMessage(discountRecord.toString());
        }
        if (freeGift != null) {
            printMessage(freeGift.toString());
        }

    }

    public void printTotalBenefitAmount(DiscountRecord discountRecord, FreeGift freeGift) {
        printMessage("<총혜택 금액>");
        int totalBenefitAmount = 0;
        if (discountRecord != null) {
            totalBenefitAmount += discountRecord.getTotalDiscountAmount();
        }
        if (freeGift != null) {
            totalBenefitAmount += freeGift.calculateBenefitPrice();
        }
        if (totalBenefitAmount == ZERO) {
            printMessage(ZERO + MONEY_UNIT);
            printEmptyLine();
            return;
        }
        printMessage("-" + createFormattedAmount(totalBenefitAmount) + MONEY_UNIT);
        printEmptyLine();
    }

    public void printExpectedPayment(Order order, DiscountRecord discountRecord) {
        printMessage("<할인 후 예상 결제 금액>");
        if (discountRecord == null) {
            printMessage(createFormattedAmount(order.getTotalOrderPrice()) + MONEY_UNIT);
            printEmptyLine();
            return;
        }
        int totalDiscountAmount = discountRecord.getTotalDiscountAmount();
        printMessage(createFormattedAmount(order.getTotalOrderPrice() - totalDiscountAmount) + MONEY_UNIT);
        printEmptyLine();

    }

    public void printEventBadge(EventBadge badge) {
        printMessage("<12월 이벤트 배지>");
        if(badge == null){
            printMessage(NONE);
            return;
        }
        printMessage(badge.getName());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }

}
