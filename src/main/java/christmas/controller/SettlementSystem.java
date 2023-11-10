package christmas.controller;

import christmas.domain.Order;
import christmas.domain.OrderItem;

public class SettlementSystem {

    private int calculateOriginalTotal(Order order){
        int total =0;
        for (OrderItem orderItem : order.getOrderItems()) {
            total += (orderItem.getPrice() * orderItem.getQuantity());
        }
        return total;
    }

}
