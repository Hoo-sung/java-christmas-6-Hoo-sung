package christmas.view;

import christmas.domain.Order;
import christmas.domain.OrderItem;

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

    public static void printMessage(String message) {
        System.out.println(message);
    }
    public static void printEmptyLine() {
        System.out.println();
    }
}
