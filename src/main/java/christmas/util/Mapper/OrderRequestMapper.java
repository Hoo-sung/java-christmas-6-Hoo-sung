package christmas.util.Mapper;

import christmas.dto.request.OrderItemRequest;
import christmas.dto.request.OrderRequest;

import java.util.Arrays;
import java.util.List;

public class OrderRequestMapper {

    private static final String menuSeparator = ",";
    private static final String menuAndQuantitySeparator = "-";
    private static final int menuAndQuantityLength = 2;
    private static final int menuIndex = 0;
    private static final int quantityIndex = 1;

    public static OrderRequest fromMenuForm(String menuForm, int day) {
        List<OrderItemRequest> orderItemRequests = Arrays.stream(menuForm.split(menuSeparator))
                .map(nameAndCount -> nameAndCount.split(menuAndQuantitySeparator))
                .filter(parts -> parts.length == menuAndQuantityLength)
                .map(parts -> new OrderItemRequest(parts[menuIndex], Integer.parseInt(parts[quantityIndex])))
                .toList();

        return new OrderRequest(orderItemRequests,day);
    }
}
