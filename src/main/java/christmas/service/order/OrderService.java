package christmas.service.order;

import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;
import christmas.dto.request.OrderItemRequest;
import christmas.dto.request.OrderRequest;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public Order createOrder(final OrderRequest orderRequest){
        List<OrderItem> orderItems = createOrderItems(orderRequest.getOrderItems());
        return new Order(orderItems,orderRequest.getOrderDay());
    }

    private List<OrderItem> createOrderItems(final List<OrderItemRequest> orderItemRequests){
        List<OrderItem> orderItems = new ArrayList<>();
        for(OrderItemRequest orderItemRequest: orderItemRequests){
            orderItems.add(new OrderItem(orderItemRequest.getMenuName(), orderItemRequest.getQuantity()));
        }
        return orderItems;
    }
}
