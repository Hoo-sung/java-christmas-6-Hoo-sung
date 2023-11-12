package christmas.domain.verifier;


import christmas.domain.Menu;
import christmas.system.ExceptionMessage;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderMenuVerifier implements Verifier<String> {

    @Override
    public void check(String input) {
        checkMenuFormat(input);
        checkMenuExistence(input);
        checkDistinctMenu(input);
        checkMenuQuantity(input);
    }

    private void checkMenuFormat(String input) {
        String format = "[가-힣]+-\\d+(,[가-힣]+-\\d+)*";
        Pattern pattern = Pattern.compile(format);

        String[] orders = input.split(",");

        for (String order : orders) {
            Matcher matcher = pattern.matcher(order.trim());
            if (!matcher.matches()) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MESSAGE);
            }
        }
    }

    private void checkMenuExistence(String input) {
        String[] orders = input.split(",");
        for (String order : orders) {
            String[] orderInfo = order.split("-");
            if (Menu.getMenuItemByName(orderInfo[0]) == null)
                throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MESSAGE);
        }
    }

    private void checkDistinctMenu(String input) {
        Set<String> uniqueMenuItems = new HashSet<>();
        String[] orders = input.split(",");
        for (String order : orders) {
            String[] orderInfo = order.split("-");
            if (!uniqueMenuItems.add(orderInfo[0]))
                throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MESSAGE);
        }
    }

    private void checkMenuQuantity(String input) {
        String[] orders = input.split(",");
        for (String order : orders) {
            String[] orderInfo = order.split("-");
            try {
                int quantity = Integer.parseInt(orderInfo[1]);
                if (quantity < 1)
                    throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MESSAGE);
            }catch(NumberFormatException e){
                throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_MESSAGE);
            }
        }
    }

}
