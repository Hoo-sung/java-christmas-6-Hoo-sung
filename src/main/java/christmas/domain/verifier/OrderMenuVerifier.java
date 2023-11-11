package christmas.domain.verifier;


import christmas.domain.Menu;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderMenuVerifier implements Verifier{
    @Override
    public void check(String input) {
        checkMenuFormat(input);
        checkMenuQuantity(input);
        checkDistinctMenu(input);
        checkMenuExistence(input);
    }

    private void checkMenuFormat(String input) {
        String format = "[가-힣]+-\\d+(,[가-힣]+-\\d+)*";
        Pattern pattern = Pattern.compile(format);

        String[] orders = input.split(",");

        for (String order : orders) {
            Matcher matcher = pattern.matcher(order.trim());
            if (!matcher.matches()) {
                throw new IllegalArgumentException("[ERROR]1 유효하지 않은 주문 형식입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void checkMenuQuantity(String input){
        String[] orders = input.split(",");
        for(String order : orders){
            String[] orderInfo = order.split("-");
            check(orderInfo[1]);
            int quantity = Integer.parseInt(orderInfo[1]);
            if(quantity < 1)
                throw new IllegalArgumentException("[ERROR]2 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void checkDistinctMenu(String input){
        Set<String> uniqueMenuItems = new HashSet<>();
        String[] orders = input.split(",");
        for(String order : orders){
            String[] orderInfo = order.split("-");
            if(!uniqueMenuItems.add(orderInfo[0]))
                throw new IllegalArgumentException("[ERROR]3 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void checkMenuExistence(String input){
        String[] orders = input.split(",");
        for(String order : orders){
            String[] orderInfo = order.split("-");
            if(Menu.getMenuItemByName(orderInfo[0])== null)
                throw new IllegalArgumentException("[ERROR]4 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }


}
