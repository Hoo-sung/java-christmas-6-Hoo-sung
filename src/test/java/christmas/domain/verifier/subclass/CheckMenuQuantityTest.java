package christmas.domain.verifier.subclass;

import static christmas.system.ExceptionMessage.INVALID_ORDER_MESSAGE;

public class CheckMenuQuantityTest {

    public void checkMenuQuantity(String input) {
        String[] orders = input.split(",");
        for (String order : orders) {
            validateOrderQuantity(order);
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
