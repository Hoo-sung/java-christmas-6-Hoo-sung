package christmas.domain.entity;

import christmas.system.IOMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static christmas.system.IOMessage.QUANTITY_UNIT;

public class Order {

    private final List<OrderItem> orderItems = new ArrayList<>();

    public int calculateTotalOrderAmount() {
        return orderItems.stream()
                .mapToInt(OrderItem::calculateTotalItemAmount)
                .sum();
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (OrderItem orderItem : orderItems) {
            stringBuilder.append(orderItem.getName())
                    .append(IOMessage.EMPTY_STRING)
                    .append(orderItem.getQuantity())
                    .append(QUANTITY_UNIT)
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
