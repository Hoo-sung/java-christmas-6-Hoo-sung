package christmas.domain.util;

import christmas.domain.entity.Order;
import christmas.domain.entity.OrderItem;

import java.text.DecimalFormat;

import static christmas.domain.entity.Menu.*;

public final class Util {

    public static Order createOrderFromInput(String input) {
        Order order = new Order();

        String[] orderItems = input.split(",");
        for (String orderItem : orderItems) {
            String[] orderItemSpec = orderItem.split("-");
            String menu = orderItemSpec[0];
            int quantity = Integer.parseInt(orderItemSpec[1]);
            order.addOrderItem(new OrderItem(getMenuItemByName(menu).get(), quantity));
        }
        return order;
    }

    public static String createFormattedAmount(int target) {
        DecimalFormat formatter = new DecimalFormat("###,##0");
        return formatter.format(target);
    }

}
