package christmas.domain.verifier;

import christmas.domain.MenuType;
import christmas.domain.Order;
import christmas.domain.OrderItem;
import christmas.system.ExceptionMessage;

public class RuntimeVerifier {

    public void check(Order order) {
        checkOrderQuantity(order);
        checkBeverageOnly(order);
    }

    private void checkOrderQuantity(Order order) {
        int total = 0;
        for (OrderItem orderItem : order.getOrderItems()) {
            total += orderItem.getQuantity();
            if (total > 20)
                throw new IllegalStateException(ExceptionMessage.MAX_ORDER_QUANTITY_EXCEEDED_MESSAGE);
        }
    }

    private void checkBeverageOnly(Order order) {
        for (OrderItem orderItem : order.getOrderItems()) {
            if (orderItem.getMenuType() != MenuType.BEVERAGE)
                return;
        }
        throw new IllegalStateException(ExceptionMessage.BEVERAGE_ONLY_ORDER_MESSAGE);
    }


}
