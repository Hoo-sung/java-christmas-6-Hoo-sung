package christmas.domain.verifier.subclass;

import christmas.domain.Menu;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static christmas.system.ExceptionMessage.INVALID_ORDER_MESSAGE;

public class OrderMenuVerifierSubTest {


    private final Pattern pattern;

    public OrderMenuVerifierSubTest() {
        this.pattern = Pattern.compile("[가-힣]+-\\d+(,[가-힣]+-\\d+)*");
    }

    public void checkMenuFormat(String input) {
        String[] orders = input.split(",");
        for (String order : orders) {
            validateOrderFormat(order);
        }
    }

    public void checkMenuExistence(String input) {
        String[] orders = input.split(",");
        for (String order : orders) {
            validateOrderExistence(order);
        }
    }
    public void checkDistinctMenu(String input) {
        Set<String> uniqueMenuItems = new HashSet<>();
        String[] orders = input.split(",");
        for (String order : orders) {
            validateDistinctMenu(order, uniqueMenuItems);
        }
    }

    public void checkMenuQuantity(String input) {
        String[] orders = input.split(",");
        for (String order : orders) {
            validateOrderQuantity(order);
        }
    }

    private void validateOrderFormat(String order) {
        Matcher matcher = pattern.matcher(order);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }
    private void validateOrderExistence(String order) {
        String[] orderInfo = order.split("-");
        if (Menu.getMenuItemByName(orderInfo[0]) == null) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

    private void validateDistinctMenu(String order, Set<String> uniqueMenuItems) {
        String[] orderInfo = order.split("-");
        if (!uniqueMenuItems.add(orderInfo[0])) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }
    private void validateOrderQuantity(String order) {
        String[] orderInfo = order.split("-");
        try {
            int quantity = Integer.parseInt(orderInfo[1]);
            if (quantity < 1) {
                throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }
}
