package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

}
