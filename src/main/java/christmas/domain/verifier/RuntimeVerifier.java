package christmas.domain.verifier;

import christmas.domain.entity.Order;
import christmas.domain.entity.OrderItem;

import static christmas.domain.entity.MenuType.*;
import static christmas.system.ExceptionMessage.*;


public class RuntimeVerifier implements Verifier<Order> {

    private static final int MAX_QUANTITY = 20;
    public static final RuntimeVerifier RUNTIME_VERIFIER = new RuntimeVerifier();

    private RuntimeVerifier() {
    }

    @Override
    public void validate(Order order) {
        validateOrderQuantity(order);
        validateBeverageOnly(order);
    }

    private void validateOrderQuantity(Order order) {
        int totalQuantity = order.getOrderItems().stream()
                .mapToInt(OrderItem::getQuantity)
                .sum();
        if (totalQuantity > MAX_QUANTITY) {
            Verifier.throwIllegalStateError(MAX_ORDER_QUANTITY_EXCEEDED_MESSAGE);
        }
    }

    private void validateBeverageOnly(Order order) {
        for (OrderItem orderItem : order.getOrderItems()) {
            if (orderItem.getMenuType() != BEVERAGE) {
                return;
            }
        }
        Verifier.throwIllegalStateError(BEVERAGE_ONLY_ORDER_MESSAGE);
    }
}
