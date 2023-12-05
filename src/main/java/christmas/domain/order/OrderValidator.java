package christmas.domain.order;

import christmas.domain.Menu;
import christmas.domain.MenuType;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static christmas.system.ExceptionMessage.*;

public class OrderValidator {

    /**
     * 중복 메뉴 존재 검사
     * 20개 넘는지 검사
     * 음료수만 주문한 경우 검사
     */

    public static final OrderValidator ORDER_VALIDATOR = new OrderValidator();
    private static final int TOTAL_ORDER_COUNT_LIMIT = 20;

    private OrderValidator() {

    }

    public void validate(List<OrderItem> orderMenus) {
        validateDuplicateMenu(orderMenus);
        validateTotalOrderCount(orderMenus);
        validateOnlyDrinkMenu(orderMenus);
    }

    private void validateDuplicateMenu(List<OrderItem> orderMenus) {
        Set<Menu> uniqueMenus = createUniqueOrderMenus(orderMenus);

        if (uniqueMenus.size() != orderMenus.size()) {
            throw new IllegalStateException(INVALID_ORDER_MESSAGE);
        }
    }

    private Set<Menu> createUniqueOrderMenus(List<OrderItem> orderMenus) {
        return orderMenus.stream()
                .map(OrderItem::getMenuName)
                .map(christmas.domain.Menu::findMenuItemByName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    private void validateTotalOrderCount(List<OrderItem> orderMenus) {
        int totalOrderCount = calculateTotalOrderCount(orderMenus);
        if (totalOrderCount > TOTAL_ORDER_COUNT_LIMIT) {
            throw new IllegalStateException(MAX_ORDER_QUANTITY_EXCEEDED_MESSAGE);
        }
    }

    private int calculateTotalOrderCount(List<OrderItem> orderMenus) {
        return orderMenus.stream()
                .mapToInt(OrderItem::getQuantity)
                .sum();
    }

    private void validateOnlyDrinkMenu(List<OrderItem> orderMenus) {
        if (!isAllMenuBeverage(orderMenus)) {
            throw new IllegalStateException(BEVERAGE_ONLY_ORDER_MESSAGE);
        }
    }

    private boolean isAllMenuBeverage(List<OrderItem> orderMenus) {
        return orderMenus.stream()
                .map(OrderItem::getMenuName)
                .map(Menu::findMenuItemByName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Menu::getMenuType)
                .allMatch(menyType -> menyType.equals(MenuType.BEVERAGE));
    }
}
