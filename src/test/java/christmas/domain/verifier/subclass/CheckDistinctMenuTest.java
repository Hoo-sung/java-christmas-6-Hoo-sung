package christmas.domain.verifier.subclass;

import java.util.HashSet;
import java.util.Set;

import static christmas.system.ExceptionMessage.INVALID_ORDER_MESSAGE;

public class CheckDistinctMenuTest {

    public void checkDistinctMenu(String input) {
        Set<String> uniqueMenuItems = new HashSet<>();
        String[] orders = input.split(",");
        for (String order : orders) {
            validateDistinctMenu(order, uniqueMenuItems);
        }
    }

    private void validateDistinctMenu(String order, Set<String> uniqueMenuItems) {
        String[] orderInfo = order.split("-");
        if (!uniqueMenuItems.add(orderInfo[0])) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }
}
