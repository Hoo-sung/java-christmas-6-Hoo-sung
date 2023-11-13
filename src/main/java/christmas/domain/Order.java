package christmas.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private final List<OrderItem> orderItems = new ArrayList<>();

    public int getTotalOrderAmount() {
        return orderItems.stream()
                .mapToInt(OrderItem::getTotalItemAmount)
                .sum();
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }

}
