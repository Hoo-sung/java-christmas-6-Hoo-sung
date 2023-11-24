package christmas.domain.verifier;


import christmas.domain.entity.Menu;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static christmas.system.ExceptionMessage.*;

public class OrderMenuVerifier implements Verifier<String> {

    public static final OrderMenuVerifier ORDER_MENU_VERIFIER = new OrderMenuVerifier();

    private final Pattern pattern;

    private OrderMenuVerifier() {
        this.pattern = Pattern.compile("[가-힣]+-\\d+(,[가-힣]+-\\d+)*");
    }

    @Override
    public void validate(final String input) {
        validateMenuFormat(input);
    }

    public void validateInputInDomain(final String input) {
        validateMenuExistence(input);
        validateDistinctMenu(input);
        validateMenuQuantity(input);
    }

    private void validateMenuFormat(final String input) {
        String[] orders = input.split(",");
        for (String order : orders) {
            validateOrderFormat(order);
        }
    }

    private void validateMenuExistence(final String input) {
        String[] orders = input.split(",");
        for (String order : orders) {
            validateOrderExistence(order);
        }
    }

    private void validateDistinctMenu(final String input) {
        Set<String> uniqueMenuItems = new HashSet<>();
        String[] orders = input.split(",");
        for (String order : orders) {
            validateDistinctMenu(order, uniqueMenuItems);
        }
    }

    private void validateMenuQuantity(final String input) {
        String[] orders = input.split(",");
        for (String order : orders) {
            validateOrderQuantity(order);
        }
    }

    private void validateOrderFormat(final String order) {
        Matcher matcher = pattern.matcher(order);
        if (!matcher.matches()) {
            Verifier.throwIllegalArgumentError(INVALID_ORDER_MESSAGE);
        }
    }

    private void validateOrderExistence(final String order) {
        String[] orderInfo = order.split("-");
        if (Menu.getMenuItemByName(orderInfo[0]) == null) {
            Verifier.throwIllegalArgumentError(INVALID_ORDER_MESSAGE);
        }
    }

    private void validateDistinctMenu(final String order, Set<String> uniqueMenuItems) {
        String[] orderInfo = order.split("-");
        if (!uniqueMenuItems.add(orderInfo[0])) {
            Verifier.throwIllegalArgumentError(INVALID_ORDER_MESSAGE);
        }
    }

    private void validateOrderQuantity(final String order) {
        String[] orderInfo = order.split("-");
        try {
            int quantity = Integer.parseInt(orderInfo[1]);
            if (quantity < 1) {
                Verifier.throwIllegalArgumentError(INVALID_ORDER_MESSAGE);
            }
        } catch (NumberFormatException e) {
            Verifier.throwIllegalArgumentError(INVALID_ORDER_MESSAGE);
        }
    }


}
