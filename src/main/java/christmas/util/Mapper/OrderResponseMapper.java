package christmas.util.Mapper;

import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;
import christmas.dto.response.OrderItemResponse;
import christmas.dto.response.OrderResponse;

import java.util.ArrayList;
import java.util.List;

public class OrderResponseMapper {

    public static OrderResponse of(Order order){
        List<OrderItemResponse> orderItemResponses = new ArrayList<>();
        for(OrderItem orderItem: order.getOrderItems()){
            orderItemResponses.add(
                    new OrderItemResponse(orderItem.getMenuName(), orderItem.getQuantity(),orderItem.getPrice()));
        }
        return new OrderResponse(orderItemResponses);
    }
}
