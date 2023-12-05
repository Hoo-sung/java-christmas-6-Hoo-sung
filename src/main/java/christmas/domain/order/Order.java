package christmas.domain.order;

import christmas.domain.MenuType;
import christmas.system.IOMessage;

import java.util.Collections;
import java.util.List;

import static christmas.domain.order.OrderValidator.ORDER_VALIDATOR;
import static christmas.system.IOMessage.QUANTITY_UNIT;

public class Order {

    private final List<OrderItem> orderItems;
    private final OrderDay day;

    public Order(List<OrderItem> orderItems, int day) {
        ORDER_VALIDATOR.validate(orderItems);
        this.orderItems = orderItems;
        this.day = new OrderDay(day);
    }

    public int getTotalOrderPrice() {
        int sum = 0;
        for (OrderItem orderItem : orderItems) {
            sum += orderItem.getPrice();
        }
        return sum;
    }

    public OrderDay getOrderDay(){
        return day;
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (OrderItem orderItem : orderItems) {
            stringBuilder.append(orderItem.getMenuName())
                    .append(IOMessage.EMPTY_STRING)
                    .append(orderItem.getQuantity())
                    .append(QUANTITY_UNIT)
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
