package christmas.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static christmas.system.IOMessage.QUANTITY_UNIT;

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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<주문 메뉴>").append(System.lineSeparator());
        for (OrderItem orderItem : orderItems) {
            stringBuilder.append(orderItem.getName())
                    .append(" ")
                    .append(orderItem.getQuantity())
                    .append(QUANTITY_UNIT)
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
