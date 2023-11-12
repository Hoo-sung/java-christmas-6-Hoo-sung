package christmas.domain.verifier;

import christmas.domain.MenuType;
import christmas.domain.Order;
import christmas.domain.OrderItem;
import christmas.system.ExceptionMessage;

public class RuntimeVerifier {

    public void check(Order order){
        checkBeverageOnly(order);
    }

    private void checkBeverageOnly(Order order){
        for(OrderItem orderItem : order.getOrderItems()){
            if(orderItem.getMenuType() != MenuType.BEVERAGE)
                return;
        }
        throw new IllegalStateException(ExceptionMessage.BEVERAGE_ONLY_ORDER_MESSAGE);
    }
}
