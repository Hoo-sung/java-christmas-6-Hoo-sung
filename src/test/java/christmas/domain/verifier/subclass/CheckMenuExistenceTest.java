package christmas.domain.verifier.subclass;

import christmas.domain.Menu;

import static christmas.system.ExceptionMessage.INVALID_ORDER_MESSAGE;

public class CheckMenuExistenceTest {
    public void checkMenuExistence(String input) {
        String[] orders = input.split(",");
        for (String order : orders) {
            validateOrderExistence(order);
        }
    }

    private void validateOrderExistence(String order) {
        String[] orderInfo = order.split("-");
        if (Menu.getMenuItemByName(orderInfo[0]) == null) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }
}
