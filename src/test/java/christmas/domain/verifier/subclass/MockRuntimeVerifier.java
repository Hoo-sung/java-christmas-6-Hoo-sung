package christmas.domain.verifier.subclass;

import christmas.domain.entity.MenuType;
import christmas.domain.entity.Order;
import christmas.domain.entity.OrderItem;

import static christmas.system.ExceptionMessage.BEVERAGE_ONLY_ORDER_MESSAGE;
import static christmas.system.ExceptionMessage.MAX_ORDER_QUANTITY_EXCEEDED_MESSAGE;

public class MockRuntimeVerifier {

    public void checkOrderQuantity(Order order) {
        int totalQuantity = order.getOrderItems().stream()
                .mapToInt(OrderItem::getQuantity)
                .sum();
        if (totalQuantity > 20) {
            throw new IllegalStateException(MAX_ORDER_QUANTITY_EXCEEDED_MESSAGE);
        }
    }

    public void checkBeverageOnly(Order order) {
        for (OrderItem orderItem : order.getOrderItems()) {
            if (orderItem.getMenuType() != MenuType.BEVERAGE) {
                return;
            }
        }
        throw new IllegalStateException(BEVERAGE_ONLY_ORDER_MESSAGE);
    }
}
