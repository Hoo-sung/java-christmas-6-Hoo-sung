package christmas.domain.order;

import christmas.domain.MenuType;

import java.util.Collections;
import java.util.List;

public class Order {

    private final List<OrderItem> orderItems;
    private final OrderDay day;

    public Order(List<OrderItem> orderItems, OrderDay day) {
        //validate order
        this.orderItems = orderItems;
        this.day = day;
    }

    public int getTotalOrderPrice() {
        int sum = 0;
        for (OrderItem orderItem : orderItems) {
            sum += orderItem.getPrice();
        }
        return sum;
    }

    public int getDay() {
        return day.getDay();
    }

    public int getSpecificMenuOrderCount(MenuType menuType) {
        int count = 0;
        for (OrderItem orderItem : orderItems) {
            if (orderItem.isSameMenuType(menuType)) {
                count += orderItem.getQuantity();
            }
        }
        return count;
    }

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }
}